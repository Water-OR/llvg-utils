@file:JvmName("PrimitiveUtils")

package net.llvg.llvg_utils.primitive

import kotlin.internal.InlineOnly

/**
 * @return [Number.toDouble] of the receiver
 */
@InlineOnly
public inline val Number.double: Double
    get() = toDouble()

/**
 * @return [Number.toFloat] of the receiver
 */
@InlineOnly
public inline val Number.float: Float
    get() = toFloat()

/**
 * @return [Number.toLong] of the receiver
 */
@InlineOnly
public inline val Number.long: Long
    get() = toLong()

/**
 * @return [Number.toInt] of the receiver
 */
@InlineOnly
public inline val Number.int: Int
    get() = toInt()

/**
 * @return [Number.toChar] of the receiver
 */
@InlineOnly
@Suppress("DEPRECATION")
@Deprecated("Deprecated by kotlin", ReplaceWith("int.char", "net.llvg.llvg_utils.int"))
public inline val Number.char: Char
    get() = toChar()

/**
 * @return [Int.toChar] of the receiver
 */
@InlineOnly
public inline val Int.char: Char
    get() = toChar()

/**
 * @return [Number.toShort] of the receiver
 */
@InlineOnly
public inline val Number.short: Short
    get() = toShort()

/**
 * @return [Number.toByte] of the receiver
 */
@InlineOnly
public inline val Number.byte: Byte
    get() = toByte()