@file:JvmName("TypeCast")

package net.llvg.loliutils.exception

@Suppress("UNUSED")
inline val <N : Number> N.double get() = toDouble()

@Suppress("UNUSED")
inline val <N : Number> N.float get() = toFloat()

@Suppress("UNUSED")
inline val <N : Number> N.long get() = toLong()

@Suppress("UNUSED")
inline val <N : Number> N.int get() = toInt()

@Suppress("UNUSED")
inline val <N : Number> N.char get() = toInt().toChar()

@Suppress("UNUSED")
inline val <N : Number> N.short get() = toShort()

@Suppress("UNUSED")
inline val <N : Number> N.byte get() = toByte()

@Suppress("UNUSED")
inline val <T> T.wrapped: ValueWrapper<T> get() = ValueWrapper(this)

@Suppress("UNUSED", "UNCHECKED_CAST")
fun <T, R> T.uncheckedCast() = this as R

@Suppress("UNUSED", "UNCHECKED_CAST")
fun <R> ValueWrapper<*>.cast(): R = value as R

@Suppress("UNUSED", "UNCHECKED_CAST")
@get:JvmName("asNotNull")
inline val <T> T?.asNotNull: T get() = this as T