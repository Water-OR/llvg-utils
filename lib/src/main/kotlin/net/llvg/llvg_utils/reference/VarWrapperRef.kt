package net.llvg.llvg_utils.reference

/**
 * An implementation of [VarRef] that contains a variance in type [T]
 *
 * @see VarRef
 */
public class VarWrapperRef<T>(
    private var value: T
) : VarRef<T> {
    override fun get(): T =
        value
    
    override fun set(
        value: T
    ) {
        this.value = value
    }
}