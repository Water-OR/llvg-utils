package net.llvg.loliutils.iterating

interface LIterator<T> : Cloneable, LCanBeEmpty {
        fun increase(): LIterator<T>
        
        fun decrease(): LIterator<T>
        
        fun set(other: T): T
        
        fun get(): T
        
        infix fun compare(other: LIterator<T>) = get() === other.get()
        
        public override fun clone(): LIterator<T>
}