package net.llvg.llvg_utils.reference

import kotlin.internal.InlineOnly
import kotlin.reflect.KProperty

/**
 * An implementation of [ValRef] that warps a value in type [T]
 */
@JvmInline
@Suppress("OVERRIDE_BY_INLINE")
public value class BoxRef<out T>(
    public val value: T
) : ValRef<T> {
    override inline fun get(): T =
        value
    
    @InlineOnly
    public inline operator fun getValue(
        thisRef: Any?,
        property: KProperty<*>
    ): T =
        value
}