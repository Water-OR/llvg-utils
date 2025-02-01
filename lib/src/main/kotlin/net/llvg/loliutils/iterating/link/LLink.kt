package net.llvg.loliutils.iterating.link

import net.llvg.loliutils.iterating.LCanBeEmpty
import net.llvg.loliutils.iterating.LIterable

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
}