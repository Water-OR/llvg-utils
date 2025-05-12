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

@file:JvmName("ArrayUtils")
@file:Suppress("ReplaceJavaStaticMethodWithKotlinAnalog")

package net.llvg.loliutils.array

import java.util.Arrays
import kotlin.internal.InlineOnly
import kotlin.internal.PureReifiable

@InlineOnly
public inline fun <T> newArray(
    type: Class<T>,
    size: Int
): Array<T> =
    ArrayHelper.newArray(
        type,
        size
    )

@InlineOnly
public inline fun <@PureReifiable reified T> newArray(
    size: Int
): Array<T> =
    newArray(
        T::class.java,
        size
    )

@InlineOnly
@Suppress("ReplaceJavaStaticMethodWithKotlinAnalog")
public inline val <T> Array<T>.asList: MutableList<T>
    get() = Arrays.asList(*this)

@InlineOnly
@PublishedApi
internal fun subArrayRangeCheck(
    from: Int,
    till: Int,
    size: Int
): Int {
    require(0 <= from) { "Failed in check 0 <= from, from=$from" }
    require(from < till) { "Failed in check from < till, from=$from, till=$till" }
    require(till < size) { "Failed in check till < size, till=$till, size=$size" }
    
    return till
}

@InlineOnly
public inline fun ByteArray.subArray(
    from: Int = 0,
    size: Int = this.size - from
): ByteArray =
    subArrayRangeCheck(from, from + size, this.size).let { till ->
        if (from == 0) {
            Arrays.copyOf(this, size)
        } else {
            Arrays.copyOfRange(this, from, till)
        }
    }

@InlineOnly
public inline fun ShortArray.subArray(
    from: Int = 0,
    size: Int = this.size - from
): ShortArray =
    subArrayRangeCheck(from, from + size, this.size).let { till ->
        if (from == 0) {
            Arrays.copyOf(this, size)
        } else {
            Arrays.copyOfRange(this, from, till)
        }
    }

@InlineOnly
public inline fun IntArray.subArray(
    from: Int = 0,
    size: Int = this.size - from
): IntArray =
    subArrayRangeCheck(from, from + size, this.size).let { till ->
        if (from == 0) {
            Arrays.copyOf(this, size)
        } else {
            Arrays.copyOfRange(this, from, till)
        }
    }

@InlineOnly
public inline fun LongArray.subArray(
    from: Int = 0,
    size: Int = this.size - from
): LongArray =
    subArrayRangeCheck(from, from + size, this.size).let { till ->
        if (from == 0) {
            Arrays.copyOf(this, size)
        } else {
            Arrays.copyOfRange(this, from, till)
        }
    }

@InlineOnly
public inline fun CharArray.subArray(
    from: Int = 0,
    size: Int = this.size - from
): CharArray =
    subArrayRangeCheck(from, from + size, this.size).let { till ->
        if (from == 0) {
            Arrays.copyOf(this, size)
        } else {
            Arrays.copyOfRange(this, from, till)
        }
    }

@InlineOnly
public inline fun FloatArray.subArray(
    from: Int = 0,
    size: Int = this.size - from
): FloatArray =
    subArrayRangeCheck(from, from + size, this.size).let { till ->
        if (from == 0) {
            Arrays.copyOf(this, size)
        } else {
            Arrays.copyOfRange(this, from, till)
        }
    }

@InlineOnly
public inline fun DoubleArray.subArray(
    from: Int = 0,
    size: Int = this.size - from
): DoubleArray =
    subArrayRangeCheck(from, from + size, this.size).let { till ->
        if (from == 0) {
            Arrays.copyOf(this, size)
        } else {
            Arrays.copyOfRange(this, from, till)
        }
    }

@InlineOnly
public inline fun BooleanArray.subArray(
    from: Int = 0,
    size: Int = this.size - from
): BooleanArray =
    subArrayRangeCheck(from, from + size, this.size).let { till ->
        if (from == 0) {
            Arrays.copyOf(this, size)
        } else {
            Arrays.copyOfRange(this, from, till)
        }
    }

@InlineOnly
public inline fun <T> Array<T>.subArray(
    from: Int = 0,
    size: Int = this.size - from
): Array<T> =
    subArrayRangeCheck(from, from + size, this.size).let { till ->
        if (from == 0) {
            Arrays.copyOf(this, size)
        } else {
            Arrays.copyOfRange(this, from, till)
        }
    }