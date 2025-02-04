package net.llvg.loliutils.iterating.link

import net.llvg.loliutils.iterating.LCanBeEmpty
import net.llvg.loliutils.iterating.LIterable
import net.llvg.loliutils.iterating.LIterator

interface LLink<T> : LIterable<T> {
        fun head(): Node<T>
        
        fun tail(): Node<T>
        
        interface Node<T> : LCanBeEmpty {
                fun prev(): Node<T>
                
                fun next(): Node<T>
                
                fun insertPrev(value: T): Node<T>
                
                fun insertNext(value: T): Node<T>
                
                fun delete()
                
                fun get(): T
                
                fun set(value: T): T
        }
        
        class Iterator<T>(private var node: Node<T>) : LIterator<T> {
                override fun increase(): LIterator<T> {
                        node = node.next()
                        return this
                }
                
                override fun decrease(): LIterator<T> {
                        node = node.prev()
                        return this
                }
                
                override fun get(): T = node.get()
                override fun set(other: T): T = node.set(other)
                
                override fun clone(): LIterator<T> = Iterator(node)
                
                override fun isSameTo(other: LIterator<T>): Boolean = other is Iterator && other.node == node
                
                override fun isEmpty(): Boolean = node.isEmpty()
        }
}