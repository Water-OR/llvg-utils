@file:JvmName("ThreadLocalUtils")

package net.llvg.llvg_utils.reference

import kotlin.internal.InlineOnly
import kotlin.reflect.KProperty

/**
 * @return A [VarRef] that warps the receiver [ThreadLocal]
 */
@InlineOnly
public inline val <T> ThreadLocal<T>.asRef: ThreadLocalAsRef<T>
    get() = ThreadLocalAsRef(this)

/**
 * Constructs a [ThreadLocal] with initial value
 *
 * @param initializer The initial value supplier
 * 
 * @see ThreadLocal.withInitial
 */
@InlineOnly
public inline fun <T> ThreadLocal(
    crossinline initializer: () -> T
): ThreadLocal<T> =
    ThreadLocal.withInitial { initializer() }

@InlineOnly
public inline operator fun <T> ThreadLocal<T>.getValue(
    self: Any?,
    property: KProperty<*>
): T =
    get()

@InlineOnly
public inline operator fun <T> ThreadLocal<T>.setValue(
    self: Any?,
    property: KProperty<*>,
    value: T
) {
    set(value)
}