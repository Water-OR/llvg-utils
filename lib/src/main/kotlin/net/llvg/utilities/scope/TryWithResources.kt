@file:JvmName("TryWithResources")

package net.llvg.utilities.scope

import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import kotlin.internal.InlineOnly
import net.llvg.utilities.noExcept

context(scope: TryWithResourcesScope)
@InlineOnly
public inline operator fun <C : AutoCloseable> C.unaryPlus(): C =
    scope.use(this)

context(scope: TryWithResourcesScope)
@InlineOnly
public inline fun <C : AutoCloseable> C.use(): C =
    scope.use(this)

@PublishedApi
internal data class TryWithResourcesScopeImpl(
    private val resources: MutableCollection<AutoCloseable>
) : TryWithResourcesScope {
    override fun <C : AutoCloseable> use(resource: C): C {
        resources += resource
        return resource
    }
}

@InlineOnly
public inline fun <R> tryWithResources(action: TryWithResourcesScope.() -> R): R {
    contract {
        callsInPlace(action, InvocationKind.EXACTLY_ONCE)
    }
    
    val resources: MutableList<AutoCloseable> = ArrayList()
    return try {
        TryWithResourcesScopeImpl(resources).action()
    } finally {
        resources.asReversed().forEach { noExcept { it.close() } }
    }
}