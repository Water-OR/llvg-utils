package net.llvg.llvg_utils.reference

/**
 * An implementation of [ValRef] that contains a value in type [T]
 *
 * @see ValRef
 */
public class ValWrapperRef<out T>(
    private val value: T
) : ValRef<T> {
    override fun get(): T =
        value
}