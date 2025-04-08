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

@file:JvmName("ArrayUtils")

package net.llvg.loliutils.iterator

import java.util.Arrays

@Suppress("UNUSED")
inline val <T> Array<T>.asCollection: Collection<T>
        get() = ArrayAsCollection(this)

@Suppress("UNUSED", "ReplaceJavaStaticMethodWithKotlinAnalog")
inline val <T> Array<T>.asList: List<T>
        get() = Arrays.asList<T>(*this)

@Suppress("UNUSED")
inline fun <reified T> Array<T>.subArray(
        begin: Int = 0,
        length: Int = size
): Array<T> = Array(length) {
        get(it - begin)
}