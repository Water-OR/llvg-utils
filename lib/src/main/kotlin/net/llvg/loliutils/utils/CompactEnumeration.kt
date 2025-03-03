package net.llvg.loliutils.utils

import java.util.Enumeration

@Suppress("UNUSED")
class CompactEnumeration<T>(private vararg val enums: Enumeration<T>) : Enumeration<T> {
        private var index = 0
        override fun hasMoreElements(): Boolean {
                while (index < enums.size) {
                        if (enums[index].hasMoreElements()) return true
                        ++index
                }
                return false
        }
        
        override fun nextElement(): T {
                if (hasMoreElements()) return enums[index].nextElement()
                
                throw NoSuchElementException()
        }
}