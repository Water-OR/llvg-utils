package net.llvg.llvg_utils.reference

import kotlin.reflect.KMutableProperty0

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
    
    override inline fun set(
        value: T
    ) {
        property.set(value)
    }
}