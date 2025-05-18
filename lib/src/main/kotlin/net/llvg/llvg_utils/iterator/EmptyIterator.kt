package net.llvg.llvg_utils.iterator

/**
 * An implementation of [Iterator], [ListIterator] and [MutableIterator] which is always empty
 *
 * @see Iterator
 * @see ListIterator
 * @see MutableIterator
 */
public data object EmptyIterator :
  Iterator<Nothing>,
  ListIterator<Nothing>,
  MutableIterator<Nothing> {
    override fun hasNext(): Boolean =
        false
    
    override fun next(): Nothing =
        throw NoSuchElementException()
    
    override fun nextIndex(): Int =
        0
    
    override fun hasPrevious(): Boolean =
        false
    
    override fun previous(): Nothing =
        throw NoSuchElementException()
    
    override fun previousIndex(): Int =
        -1
    
    override fun remove(): Nothing =
        throw IllegalStateException()
}