package net.llvg.llvg_utils.reference

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * An implementation of [ReadWriteProperty] that wraps a [VarRef]
 *
 * @see VarRef
 * @see ReadWriteProperty
 */
@JvmInline
@Suppress("OVERRIDE_BY_INLINE")
public value class VarRefAsProperty<T>(
    public val ref: VarRef<T>
) : ReadWriteProperty<Any?, T> {
    override inline fun getValue(
        thisRef: Any?,
        property: KProperty<*>
    ): T =
        ref.get()
    
    override inline fun setValue(
        thisRef: Any?,
        property: KProperty<*>,
        value: T
    ) {
        ref.set(value)
    }
}