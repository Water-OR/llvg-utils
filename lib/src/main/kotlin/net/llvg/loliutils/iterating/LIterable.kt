package net.llvg.loliutils.iterating

interface LIterable<T> : LCanBeEmpty {
        fun begin(): LIterator<T>
        
        fun end(): LIterator<T>
        
        fun rBegin(): LIterator<T>
        
        fun rEnd(): LIterator<T>
        
        fun clear()
        
        fun size(): Int
}