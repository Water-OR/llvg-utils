package net.llvg.loliutils.exception

@Suppress("UNUSED")
class ArrayCollection<T>(private val array: Array<out T>) : Collection<T> {
        override val size: Int get() = array.size
        override fun isEmpty(): Boolean = array.isEmpty()
        override fun iterator(): Iterator<T> = array.iterator()
        override fun contains(element: T): Boolean = array.contains(element)
        override fun containsAll(elements: Collection<T>): Boolean = elements.all(array::contains)
}