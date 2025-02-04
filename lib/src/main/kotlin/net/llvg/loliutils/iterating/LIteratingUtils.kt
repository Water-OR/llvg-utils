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
        
        override fun isSameTo(other: LIterator<T>): Boolean = other isSameTo raw
        
        override fun isEmpty(): Boolean = raw.isEmpty()
}

@get:JvmName("reverse")
val <T> LIterator<T>.reverse: LIterator<T> get() = if (this is ReverseIterator) raw else ReverseIterator(this)

infix fun <T> LIterator<T>.notSameTo(other: LIterator<T>) = !isSameTo(other)

operator fun <T> LIterator<T>.inc(): LIterator<T> = increase()

operator fun <T> LIterator<T>.dec(): LIterator<T> = decrease()

@Suppress("unused")
inline fun <T, R> LIterable<T>.collect(result: R, crossinline collector: R.(T) -> Unit): R {
        val it = begin()
        val end = end()
        while (it notSameTo end) {
                collector(result, it.get())
                it.increase()
        }
        
        return result
}

@Suppress("unused")
inline infix fun <T> LIterable<T>.runEach(crossinline action: T.() -> Unit): LIterable<T> {
        val it = begin()
        val end = end()
        while (it notSameTo end) {
                action(it.get())
                it.increase()
        }
        return this
}

@Suppress("unused")
inline infix fun <T> LIterable<T>.letEach(crossinline action: (T) -> Unit): LIterable<T> {
        val it = begin()
        val end = end()
        while (it notSameTo end) {
                action(it.get())
                it.increase()
        }
        return this
}

@Suppress("unused")
inline infix fun <T> LIterable<T>.runEachReverse(crossinline action: T.() -> Unit): LIterable<T> {
        val it = end()
        val end = begin()
        if (it notSameTo end) do {
                it.decrease()
                action(it.get())
        } while (it notSameTo end)
        return this
}

@Suppress("unused")
inline infix fun <T> LIterable<T>.letEachReverse(crossinline action: (T) -> Unit): LIterable<T> {
        val it = end()
        val end = begin()
        if (it notSameTo end) do {
                it.decrease()
                action(it.get())
        } while (it notSameTo end)
        return this
}