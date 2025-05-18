package net.llvg.llvg_utils.reference

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
    
    override inline fun set(
        value: T
    ) {
        threadLocal.set(value)
    }
}