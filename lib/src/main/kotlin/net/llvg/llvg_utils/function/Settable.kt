package net.llvg.llvg_utils.function

/**
 * A functional interface that provides [set] function
 */
@FunctionalInterface
public fun interface Settable<in T> {
    public infix fun set(value: T)
}