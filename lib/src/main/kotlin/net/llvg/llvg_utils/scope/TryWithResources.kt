package net.llvg.llvg_utils.scope

import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import kotlin.internal.InlineOnly

/**
 * Calls the [action] with [TryWithResourcesContext] as its receiver and returns its result
 *
 * [TryWithResourcesContext] provides methods to add [AutoCloseable] object to [dispatcher]
 *
 * All [AutoCloseable] objects in added to the [dispatcher] are closed after [action] called
 *
 * @param dispatcher The [TryWithResourcesDispatcher] to manage and close the resources. default is [TryWithResourcesDispatcherListImpl] with a [ArrayList]
 * @param action The action to be
 *
 * @see TryWithResourcesContext
 * @see TryWithResourcesDispatcher
 */
@InlineOnly
public inline fun <R> tryWithResources(
    dispatcher: TryWithResourcesDispatcher = TryWithResourcesDispatcherListImpl(ArrayList()),
    action: TryWithResourcesContext.() -> R
): R {
    contract {
        callsInPlace(action, InvocationKind.EXACTLY_ONCE)
    }
    
    val context = TryWithResourcesContext(dispatcher)
    var e1: Throwable? = null
    
    try {
        return context.action()
    } catch (e: Throwable) {
        e1 = e
        throw e
    } finally {
        dispatcher.closeResources(e1)
    }
}

/**
 * For stacktrace
 */
@PublishedApi
internal fun TryWithResourcesDispatcher.closeResources(
    e1: Throwable?
): Unit = when (e1) {
    null -> close()
    else -> try {
        close()
    } catch (e: Throwable) {
        e1.addSuppressed(e)
    }
}