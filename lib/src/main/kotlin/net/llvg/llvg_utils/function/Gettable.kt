package net.llvg.llvg_utils.function

/**
 * A functional interface that provides [get] function
 */
@FunctionalInterface
public fun interface Gettable<out T> {
    public fun get(): T
}