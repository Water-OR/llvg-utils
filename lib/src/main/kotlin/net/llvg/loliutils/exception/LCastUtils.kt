@file:JvmName("LCastUtils")
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