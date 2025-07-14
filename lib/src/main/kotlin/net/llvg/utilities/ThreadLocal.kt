@file:JvmName("ThreadLocalUtil")

package net.llvg.utilities

import kotlin.internal.InlineOnly
import kotlin.reflect.KProperty

@InlineOnly
public inline fun <T> ThreadLocal(noinline supplier: () -> T): ThreadLocal<T> =
    ThreadLocal.withInitial(supplier)

@InlineOnly
public inline operator fun <T> ThreadLocal<T>.getValue(
    caller: Any?,
    property: KProperty<*>
): T = get()

@InlineOnly
public inline operator fun <T> ThreadLocal<T>.setValue(
    caller: Any?,
    property: KProperty<*>,
    value: T
) {
    set(value)
}