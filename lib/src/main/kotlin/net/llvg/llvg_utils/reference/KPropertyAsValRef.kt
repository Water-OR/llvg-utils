package net.llvg.llvg_utils.reference

import kotlin.reflect.KProperty0

/**
 * An implementation of [ValRef] that warps a [KProperty0]
 *
 * @see ValRef
 * @see KProperty0
 */
@JvmInline
@Suppress("OVERRIDE_BY_INLINE")
public value class KPropertyAsValRef<out T>(
    public val property: KProperty0<T>
) : ValRef<T> {
    public override inline fun get(): T =
        property.get()
}