package net.llvg.llvg_utils.reference

import net.llvg.llvg_utils.function.Settable

/**
 * A variance reference, which means it references an object that is readable and writable
 *
 * @see ValRef.getValue
 * @see VarRef.setValue
 */
public interface VarRef<T> : ValRef<T>, Settable<T> {
    /**
     * @return The value of the object the instance references to
     */
    override fun get(): T
    
    /**
     * Sets [value] to the object the instance references to
     */
    override fun set(value: T)
}