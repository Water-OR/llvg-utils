/*
 * Copyright (C) 2025 Water-OR
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

@file:JvmName("NumberUtils")

package net.llvg.loliutils.primitive

import kotlin.internal.InlineOnly

@InlineOnly
public inline val Number.double: Double
    get() = toDouble()

@InlineOnly
public inline val Number.float: Float
    get() = toFloat()

@InlineOnly
public inline val Number.long: Long
    get() = toLong()

@InlineOnly
public inline val Number.int: Int
    get() = toInt()

@InlineOnly
public inline val Number.char: Char
    get() = toInt().toChar()

@InlineOnly
public inline val Number.short: Short
    get() = toShort()

@InlineOnly
public inline val Number.byte: Byte
    get() = toByte()