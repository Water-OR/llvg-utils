package net.llvg.llvg_utils.reference

import net.llvg.llvg_utils.function.Gettable
import net.llvg.llvg_utils.function.Settable

/**
 * An implementation of [VarRef] with a [getter] lambda and a [setter] lambda
 *
 * @see ValRef
 * @see Gettable
 * @see Settable
 */
public class LambdaVarRef<T>(
    public val getter: Gettable<T>,
    public val setter: Settable<T>
) : VarRef<T> {
    override fun get(): T =
        getter.get()
    
    override fun set(
        value: T
    ) {
        setter.set(value)
    }
}