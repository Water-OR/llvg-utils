/*
 * Copyright (C) 2025 Water-OR
 *
 * This file is part of LolI Utils
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

@file:[JvmName("NumberUtils") Suppress("UNUSED")]

package net.llvg.loliutils.primitive

inline val Number.double: Double
    get() = toDouble()

inline val Number.float: Float
    get() = toFloat()

inline val Number.long: Long
    get() = toLong()

inline val Number.int: Int
    get() = toInt()

inline val Number.char: Char
    get() = toInt().toChar()

inline val Number.short: Short
    get() = toShort()

inline val Number.byte: Byte
    get() = toByte()