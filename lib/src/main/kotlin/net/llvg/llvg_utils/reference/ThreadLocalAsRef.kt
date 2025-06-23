package net.llvg.llvg_utils.reference

import kotlin.internal.InlineOnly
import kotlin.reflect.KProperty

/**
 * An implementation of [VarRef] that warps a [ThreadLocal]
 *
 * @see VarRef
 * @see ThreadLocal
 */
@JvmInline
@Suppress("OVERRIDE_BY_INLINE")
public value class ThreadLocalAsRef<T>(
    public val threadLocal: ThreadLocal<T>
) : VarRef<T> {
    override inline fun get(): T =
        threadLocal.get()
    
    @InlineOnly
    public inline operator fun getValue(
        thisRef: Any?,
        property: KProperty<*>
    ): T =
        threadLocal.get()
    
    override inline fun set(
        value: T
    ) {
        threadLocal.set(value)
    }
    
    @InlineOnly
    public inline operator fun getValue(
        thisRef: Any?,
        property: KProperty<*>,
        value: T
    ) {
        threadLocal.set(value)
    }
}