package net.llvg.llvg_utils.reference

import net.llvg.llvg_utils.function.Gettable

/**
 * A value reference, which means it references an object that is readable
 *
 * @see ValRef.getValue
 */
public interface ValRef<out T> : Gettable<T> {
    /**
     * @return The value of the object the instance references to
     */
    override fun get(): T
}