package net.llvg.loliutils.iterating.list

import net.llvg.loliutils.iterating.LIterable

interface LList<T> : LIterable<T> {
        fun insert(index: Int, value: T)
        
        fun delete(index: Int)
        
        operator fun contains(value: T): Boolean
        
        operator fun get(index: Int): T
        
        operator fun set(index: Int, value: T): T
}