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
import net.llvg.loliutils.iterator.ArrayHelper.*

@Suppress("UNUSED")
fun <T> newArray(
        type: Class<T>,
        size: Int
): Array<T> = array(
        type,
        size
)

@Suppress("UNUSED")
inline fun <reified T> newArray(
        size: Int
): Array<T> = array(
        T::class.java,
        size
)

@Suppress("UNUSED")
inline val <T> Array<T>.asCollection: Collection<T>
        get() = ArrayAsCollection(this)

@Suppress("UNUSED", "ReplaceJavaStaticMethodWithKotlinAnalog")
inline val <T> Array<T>.asList: List<T>
        get() = Arrays.asList(*this)

@Suppress("UNUSED")
fun ByteArray.subArray(
        from: Int = 0,
        size: Int = this.size - from
): ByteArray {
        if (from == 0) {
                checkRangeTill(this.size, from)
                return copyOf(size)
        } else {
                val till = from + size
                checkRangeFromTill(this.size, from, till)
                return Arrays.copyOfRange(this, from, till)
        }
}

@Suppress("UNUSED")
fun ShortArray.subArray(
        from: Int = 0,
        size: Int = this.size - from
): ShortArray {
        if (from == 0) {
                checkRangeTill(this.size, from)
                return copyOf(size)
        } else {
                val till = from + size
                checkRangeFromTill(this.size, from, till)
                return Arrays.copyOfRange(this, from, till)
        }
}

@Suppress("UNUSED")
fun IntArray.subArray(
        from: Int = 0,
        size: Int = this.size - from
): IntArray {
        if (from == 0) {
                checkRangeTill(this.size, from)
                return copyOf(size)
        } else {
                val till = from + size
                checkRangeFromTill(this.size, from, till)
                return Arrays.copyOfRange(this, from, till)
        }
}

@Suppress("UNUSED")
fun LongArray.subArray(
        from: Int = 0,
        size: Int = this.size - from
): LongArray {
        if (from == 0) {
                checkRangeTill(this.size, from)
                return copyOf(size)
        } else {
                val till = from + size
                checkRangeFromTill(this.size, from, till)
                return Arrays.copyOfRange(this, from, till)
        }
}

@Suppress("UNUSED")
fun CharArray.subArray(
        from: Int = 0,
        size: Int = this.size - from
): CharArray {
        if (from == 0) {
                checkRangeTill(this.size, from)
                return copyOf(size)
        } else {
                val till = from + size
                checkRangeFromTill(this.size, from, till)
                return Arrays.copyOfRange(this, from, till)
        }
}

@Suppress("UNUSED")
fun FloatArray.subArray(
        from: Int = 0,
        size: Int = this.size - from
): FloatArray {
        if (from == 0) {
                checkRangeTill(this.size, from)
                return copyOf(size)
        } else {
                val till = from + size
                checkRangeFromTill(this.size, from, till)
                return Arrays.copyOfRange(this, from, till)
        }
}

@Suppress("UNUSED")
fun DoubleArray.subArray(
        from: Int = 0,
        size: Int = this.size - from
): DoubleArray {
        if (from == 0) {
                checkRangeTill(this.size, from)
                return copyOf(size)
        } else {
                val till = from + size
                checkRangeFromTill(this.size, from, till)
                return Arrays.copyOfRange(this, from, till)
        }
}

@Suppress("UNUSED")
fun BooleanArray.subArray(
        from: Int = 0,
        size: Int = this.size - from
): BooleanArray {
        if (from == 0) {
                checkRangeTill(this.size, from)
                return copyOf(size)
        } else {
                val till = from + size
                checkRangeFromTill(this.size, from, till)
                return Arrays.copyOfRange(this, from, till)
        }
}

@Suppress("UNUSED", "ReplaceJavaStaticMethodWithKotlinAnalog")
fun <T> Array<T>.subArray(
        from: Int = 0,
        size: Int = this.size - from
): Array<T> {
        if (from == 0) {
                checkRangeTill(this.size, from)
                return Arrays.copyOf(this, size)
        } else {
                val till = from + size
                checkRangeFromTill(this.size, from, till)
                return Arrays.copyOfRange(this, from, till)
        }
}