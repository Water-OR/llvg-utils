/*
 * Copyright (C) 2025-2025 Water-OR
 *
 * This file is part of llvg-utils
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */

@file:JvmName("PrimitiveUtils")

package net.llvg.loliutils.primitive

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
@Deprecated("Deprecated by kotlin", ReplaceWith("int.char", "net.llvg.loliutils.primitive.int"))
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