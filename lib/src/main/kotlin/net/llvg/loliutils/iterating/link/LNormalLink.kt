package net.llvg.loliutils.iterating.link

import net.llvg.loliutils.iterating.LIterator
import net.llvg.loliutils.iterating.reverse

@Suppress("unused")
class LNormalLink<T> : LLink<T> {
        private var head = object : SideNode("Head") {
                private lateinit var next: LNormalLink<T>.Node
                
                override fun next(): LNormalLink<T>.Node = next
                override fun next(node: LNormalLink<T>.Node) {
                        next = node
                }
                
                override fun prev(node: LNormalLink<T>.Node) = throw IndexOutOfBoundsException("It's head node!")
                override fun prev(): LNormalLink<T>.Node = throw IndexOutOfBoundsException("It's head node!")
        }
        
        private var tail = object : SideNode("Tail") {
                private lateinit var prev: LNormalLink<T>.Node
                
                override fun prev(): LNormalLink<T>.Node = prev
                override fun prev(node: LNormalLink<T>.Node) {
                        prev = node
                }
                
                override fun next(node: LNormalLink<T>.Node) = throw IndexOutOfBoundsException("It's tail node!")
                override fun next(): LNormalLink<T>.Node = throw IndexOutOfBoundsException("It's tail node!")
        }
        
        private var size = 0
        
        init {
                head.next(tail)
                tail.prev(head)
        }
        
        override fun head(): LLink.Node<T> = head
        override fun tail(): LLink.Node<T> = tail
        
        override fun begin(): LIterator<T> = LLink.Iterator(head.next())
        override fun end(): LIterator<T> = LLink.Iterator(tail)
        
        override fun rBegin(): LIterator<T> = LLink.Iterator(tail.prev()).reverse
        override fun rEnd(): LIterator<T> = LLink.Iterator(head).reverse
        
        override fun size(): Int = size
        
        override fun clear() {
                while (head.next() !== tail) head.next().delete()
        }
        
        override fun isEmpty(): Boolean = size == 0
        
        private abstract inner class Node : LLink.Node<T> {
                abstract fun prev(node: Node)
                abstract fun next(node: Node)
                
                override fun insertPrev(value: T): Node = NormalNode(value, prev() as Node, this)
                override fun insertNext(value: T): Node = NormalNode(value, this, next() as Node)
        }
        
        private inner class NormalNode(
                private var value: T,
                private var prev: Node,
                private var next: Node
        ) : Node() {
                init {
                        prev.next(this)
                        next.prev(this)
                        ++size
                }
                
                override fun prev(): Node = prev
                override fun prev(node: Node) {
                        prev = node
                }
                
                override fun next(): Node = next
                override fun next(node: Node) {
                        next = node
                }
                
                override fun delete() {
                        next.prev(prev)
                        prev.next(next)
                        --size
                }
                
                override fun get(): T = value
                override fun set(value: T): T {
                        val result = this.value
                        this.value = value
                        return result
                }
                
                override fun isEmpty(): Boolean = false
        }
        
        private abstract inner class SideNode(val side: String) : Node() {
                override fun delete() = throw UnsupportedOperationException("$side node cannot be deleted!")
                override fun get(): T = throw NoSuchElementException("$side node is always empty!")
                override fun set(value: T): T = throw NoSuchElementException("$side node is always empty!")
                override fun isEmpty(): Boolean = true
        }
}