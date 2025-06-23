package net.llvg.llvg_utils.reference

import kotlin.internal.InlineOnly
import kotlin.reflect.KMutableProperty0
import kotlin.reflect.KProperty

/**
 * An implementation of [VarRef] that warps a [KMutableProperty0]
 *
 * @see VarRef
 * @see KMutableProperty0
 */
@JvmInline
@Suppress("OVERRIDE_BY_INLINE")
public value class KPropertyAsVarRef<T>(
    public val property: KMutableProperty0<T>
) : VarRef<T> {
    override inline fun get(): T =
        property.get()
    
    @InlineOnly
    public inline operator fun getValue(
        thisRef: Any?,
        property: KProperty<*>
    ): T =
        this.property.get()
    
    override inline fun set(
        value: T
    ) {
        property.set(value)
    }
    
    @InlineOnly
    public inline operator fun setValue(
        thisRef: Any?,
        property: KProperty<*>,
        value: T
    ) {
        this.property.set(value)
    }
}