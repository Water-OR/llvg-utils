@file:JvmName("ValRefUtils")

package net.llvg.llvg_utils.reference

import kotlin.internal.InlineOnly
import kotlin.reflect.KProperty
import kotlin.reflect.KProperty0

/**
 * @return A [ValRef] that warps the receiver [KProperty0]
 */
@InlineOnly
public inline val <T> KProperty0<T>.asValRef: KPropertyAsValRef<T>
    get() = KPropertyAsValRef(this)

/**
 * @return A [kotlin.properties.ReadOnlyProperty] that warps the receiver [ValRef]
 */
@InlineOnly
public inline val <T> ValRef<T>.asProperty: ValRefAsProperty<T>
    get() = ValRefAsProperty(this)

@InlineOnly
public inline operator fun <T> ValRef<T>.getValue(
    thisRef: Any?,
    property: KProperty<*>
): T =
    get()