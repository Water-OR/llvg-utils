package net.llvg.loliutils.iterating.list

import net.llvg.loliutils.iterating.LIterator
import net.llvg.loliutils.iterating.reverse

@Suppress("unused")
class LArrayList<T>(private var activeSize: Int) : LList<T> {
        constructor() : this(16)
        
        private var availableSize = 16
        private var storage: Array<Any?>
        
        init {
                while (availableSize < activeSize) activeSize = activeSize shl 1
                storage = arrayOfNulls(availableSize)
        }
        
        override fun insert(index: Int, value: T) {
                ++activeSize
                checkIndex(index)
                var i = activeSize
                while (i-- > index) storage[i + 1] = storage[i]
                storage[index] = value
                
                if (activeSize < availableSize) return
                availableSize = availableSize shl 1
                val result = arrayOfNulls<Any>(availableSize)
                storage.copyInto(result, endIndex = activeSize)
                System.arraycopy(storage, 0, result, 0, activeSize)
                storage = result
        }
        
        override fun delete(index: Int) {
                checkIndex(index)
                --activeSize
                for (i in index..<activeSize) storage[i] = storage[i + 1]
        }
        
        override fun contains(value: T): Boolean {
                for (i in 0..<activeSize) if (storage[i] == value) return true
                return false
        }
        
        @Suppress("unchecked_cast")
        override fun get(index: Int): T {
                checkIndex(index)
                return storage[index] as T
        }
        
        override fun set(index: Int, value: T): T {
                checkIndex(index)
                val result = get(index)
                storage[index] = value
                return result
        }
        
        override fun clear() {
                activeSize = 0
        }
        
        override fun size(): Int = activeSize
        
        override fun isEmpty(): Boolean = activeSize == 0
        
        private fun checkIndex(index: Int) {
                if (index in 0..<activeSize) return
                throw IndexOutOfBoundsException("Index $index is out of range [0, $activeSize)!")
        }
        
        override fun begin(): LIterator<T> = ListIterator(0)
        override fun end(): LIterator<T> = ListIterator(activeSize)
        
        override fun rBegin(): LIterator<T> = ListIterator(activeSize - 1).reverse
        override fun rEnd(): LIterator<T> = ListIterator(-1).reverse
        
        private inner class ListIterator(private var index: Int) : LIterator<T> {
                override fun increase(): LIterator<T> {
                        ++index
                        if (index > activeSize) throw IndexOutOfBoundsException("It's the tail!")
                        return this
                }
                
                override fun decrease(): LIterator<T> {
                        --index
                        if (index > activeSize) throw IndexOutOfBoundsException("It's the head!")
                        return this
                }
                
                override fun set(other: T) = set(index, other)
                
                override fun get(): T = get(index)
                
                override fun clone(): LIterator<T> = ListIterator(index)
                
                override fun isEmpty(): Boolean = index in 0..<activeSize
        }
}