package net.llvg.llvg_utils.iterator

/**
 * An implementation of [Iterable] and [MutableIterable] which is always empty
 *
 * @see Iterable
 * @see MutableIterable
 */
public data object EmptyIterable :
  Iterable<Nothing>,
  MutableIterable<Nothing> {
    override fun iterator(): MutableIterator<Nothing> =
        EmptyIterator
}