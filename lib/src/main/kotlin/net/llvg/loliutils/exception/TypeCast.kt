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

@file:JvmName("TypeCast")

package net.llvg.loliutils.exception

@Suppress("UNUSED")
inline val <N : Number> N.double
        get() = toDouble()

@Suppress("UNUSED")
inline val <N : Number> N.float
        get() = toFloat()

@Suppress("UNUSED")
inline val <N : Number> N.long
        get() = toLong()

@Suppress("UNUSED")
inline val <N : Number> N.int
        get() = toInt()

@Suppress("UNUSED")
inline val <N : Number> N.char
        get() = toInt().toChar()

@Suppress("UNUSED")
inline val <N : Number> N.short
        get() = toShort()

@Suppress("UNUSED")
inline val <N : Number> N.byte
        get() = toByte()

@Suppress("UNUSED")
inline val <T> T.wrapped: ValueWrapper<T>
        get() = ValueWrapper(this)

@Suppress("UNUSED", "UNCHECKED_CAST")
fun <T, R> T.uncheckedCast(
) = this as R

@Suppress("UNUSED", "UNCHECKED_CAST")
fun <R> ValueWrapper<*>.cast(
): R = value as R

@Suppress("UNUSED", "UNCHECKED_CAST")
@get:JvmName("asNotNull")
inline val <T> T?.asNotNull: T
        get() = this as T