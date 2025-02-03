@file:JvmName("LIteratingUtils")

package net.llvg.loliutils.iterating

@Suppress("unused")
fun LCanBeEmpty.notEmpty() = !isEmpty()

private class ReverseIterator<T>(val raw: LIterator<T>) : LIterator<T> {
        override fun increase(): LIterator<T> = raw.decrease()
        override fun decrease(): LIterator<T> = raw.increase()
        
        override fun set(other: T): T = raw.set(other)
        override fun get(): T = raw.get()
        
        override fun clone(): LIterator<T> = ReverseIterator(raw.clone())
        
        override fun isEmpty(): Boolean = raw.isEmpty()
}

@get:JvmName("reverse")
val <T> LIterator<T>.reverse: LIterator<T> get() = if (this is ReverseIterator) raw else ReverseIterator(this)

operator fun <T> LIterator<T>.inc(): LIterator<T> = increase()

operator fun <T> LIterator<T>.dec(): LIterator<T> = decrease()

@Suppress("unused")
inline fun <T, R> LIterable<T>.collect(result: R, crossinline collector: R.(T) -> Unit): R {
        val it = begin()
        while (it != end()) {
                collector(result, it.get())
                it.increase()
        }
        
        return result
}

@Suppress("unused")
inline infix fun <T> LIterable<T>.runEach(crossinline action: T.() -> Unit) = letEach(action)
inline infix fun <T> LIterable<T>.letEach(crossinline action: (T) -> Unit): LIterable<T> {
        val it = begin()
        while (it != end()) {
                action(it.get())
                it.increase()
        }
        /*
        Think about cpp iterator
        
        for (Iterable::Iterator it = iterable.begin(); it != iterable.end(); ++it)
         */
        return this
}

