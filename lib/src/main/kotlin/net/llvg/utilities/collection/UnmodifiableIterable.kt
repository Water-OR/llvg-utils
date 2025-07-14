package net.llvg.utilities.collection

public class UnmodifiableIterable<out T>(
    private val delegatee: Iterable<T>
) : Iterable<T> {
    override fun iterator(): Iterator<T> =
        delegatee.iterator().unmodifiable
}