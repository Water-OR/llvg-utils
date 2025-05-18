package net.llvg.llvg_utils.reference

import net.llvg.llvg_utils.function.Gettable

/**
 * An implementation of [ValRef] with a [getter] lambda
 *
 * @see ValRef
 * @see Gettable
 */
public class LambdaValRef<out T>(
    public val getter: Gettable<T>
) : ValRef<T> {
    override fun get(): T =
        getter.get()
}