@file:JvmName("VarRefUtils")

package net.llvg.llvg_utils.reference

import kotlin.internal.InlineOnly
import kotlin.reflect.KMutableProperty0
import kotlin.reflect.KProperty

/**
 * @return A [VarRef] that warps the receiver [KMutableProperty0]
 */
@InlineOnly
public inline val <T> KMutableProperty0<T>.asVarRef: KPropertyAsVarRef<T>
    get() = KPropertyAsVarRef(this)

/**
 * @return A [kotlin.properties.ReadWriteProperty] that warps the receiver [VarRef]
 */
@InlineOnly
public inline val <T> VarRef<T>.asProperty: VarRefAsProperty<T>
    get() = VarRefAsProperty(this)

@InlineOnly
public inline operator fun <T> VarRef<T>.setValue(
    thisRef: Any?,
    property: KProperty<*>,
    value: T
) {
    set(value)
}