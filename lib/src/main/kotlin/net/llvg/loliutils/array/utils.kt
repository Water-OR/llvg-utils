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

package net.llvg.loliutils.array

import java.util.Arrays
import kotlin.internal.Exact
import kotlin.internal.InlineOnly
import kotlin.internal.PureReifiable
import net.llvg.loliutils.type.cast

@InlineOnly
public inline fun <T> newTypedArray(
    type: Class<T>,
    size: Int
): Array<T> =
    ArrayHelper.newArray(
        type,
        size
    )

@InlineOnly
public inline fun <@PureReifiable reified T> newTypedArray(
    size: Int
): Array<@Exact T> =
    newTypedArray(
        T::class.java,
        size
    )

@InlineOnly
@Suppress("ReplaceJavaStaticMethodWithKotlinAnalog")
public inline val <T> Array<T>.asList: MutableList<T>
    get() = Arrays.asList(*this)

@InlineOnly
public inline fun ByteArray.copyTo(
    dest: ByteArray,
    destOffset: Int = 0,
    from: Int = 0,
    length: Int = size - from
): ByteArray {
    System.arraycopy(this, from, dest, destOffset, length)
    return dest
}

@InlineOnly
public inline fun ShortArray.copyTo(
    dest: ShortArray,
    destOffset: Int = 0,
    from: Int = 0,
    length: Int = size - from
): ShortArray {
    System.arraycopy(this, from, dest, destOffset, length)
    return dest
}

@InlineOnly
public inline fun IntArray.copyTo(
    dest: IntArray,
    destOffset: Int = 0,
    from: Int = 0,
    length: Int = size - from
): IntArray {
    System.arraycopy(this, from, dest, destOffset, length)
    return dest
}

@InlineOnly
public inline fun LongArray.copyTo(
    dest: LongArray,
    destOffset: Int = 0,
    from: Int = 0,
    length: Int = size - from
): LongArray {
    System.arraycopy(this, from, dest, destOffset, length)
    return dest
}

@InlineOnly
public inline fun CharArray.copyTo(
    dest: CharArray,
    destOffset: Int = 0,
    from: Int = 0,
    length: Int = size - from
): CharArray {
    System.arraycopy(this, from, dest, destOffset, length)
    return dest
}

@InlineOnly
public inline fun FloatArray.copyTo(
    dest: FloatArray,
    destOffset: Int = 0,
    from: Int = 0,
    length: Int = size - from
): FloatArray {
    System.arraycopy(this, from, dest, destOffset, length)
    return dest
}

@InlineOnly
public inline fun DoubleArray.copyTo(
    dest: DoubleArray,
    destOffset: Int = 0,
    from: Int = 0,
    length: Int = size - from
): DoubleArray {
    System.arraycopy(this, from, dest, destOffset, length)
    return dest
}

@InlineOnly
public inline fun BooleanArray.copyTo(
    dest: BooleanArray,
    destOffset: Int = 0,
    from: Int = 0,
    length: Int = size - from
): BooleanArray {
    System.arraycopy(this, from, dest, destOffset, length)
    return dest
}

@InlineOnly
public inline fun <T> Array<out T>.copyTo(
    dest: Array<T>,
    destOffset: Int = 0,
    from: Int = 0,
    length: Int = size - from
): Array<T> {
    System.arraycopy(this, from, dest, destOffset, length)
    return dest
}

@PublishedApi
internal fun <T : Any> subArray(
    source: Any,
    sourceSize: Int,
    beginIndex: Int,
    length: Int,
    arrayGenerator: (Int) -> T
): T {
    if (beginIndex < 0) {
        throw IllegalArgumentException("beginIndex=$beginIndex must not be negative")
    } else if (length == 0) {
        if (beginIndex >= sourceSize) {
            throw IllegalArgumentException("beginIndex=$beginIndex must be less than sourceSize=$sourceSize")
        }
        return arrayGenerator(0)
    } else if (length > 0) {
        if (beginIndex + length > sourceSize) {
            throw IllegalArgumentException("beginIndex+length=${beginIndex + length} must not be greater sourceSize")
        }
        val result = arrayGenerator(length)
        System.arraycopy(source, beginIndex, result, 0, length)
        return result
    } else {
        throw IllegalArgumentException("length=$length must not be negative")
    }
}

@InlineOnly
public inline fun ByteArray.subArray(
    beginIndex: Int = 0,
    length: Int = size - beginIndex
): ByteArray =
    subArray(this, size, beginIndex, length, ::ByteArray)

@InlineOnly
public inline fun ShortArray.subArray(
    beginIndex: Int = 0,
    length: Int = size - beginIndex
): ShortArray =
    subArray(this, size, beginIndex, length, ::ShortArray)

@InlineOnly
public inline fun IntArray.subArray(
    beginIndex: Int = 0,
    length: Int = size - beginIndex
): IntArray =
    subArray(this, size, beginIndex, length, ::IntArray)

@InlineOnly
public inline fun LongArray.subArray(
    beginIndex: Int = 0,
    length: Int = size - beginIndex
): LongArray =
    subArray(this, size, beginIndex, length, ::LongArray)

@InlineOnly
public inline fun CharArray.subArray(
    beginIndex: Int = 0,
    length: Int = size - beginIndex
): CharArray =
    subArray(this, size, beginIndex, length, ::CharArray)

@InlineOnly
public inline fun FloatArray.subArray(
    beginIndex: Int = 0,
    length: Int = size - beginIndex
): FloatArray =
    subArray(this, size, beginIndex, length, ::FloatArray)

@InlineOnly
public inline fun DoubleArray.subArray(
    beginIndex: Int = 0,
    length: Int = size - beginIndex
): DoubleArray =
    subArray(this, size, beginIndex, length, ::DoubleArray)

@InlineOnly
public inline fun BooleanArray.subArray(
    beginIndex: Int = 0,
    length: Int = size - beginIndex
): BooleanArray =
    subArray(this, size, beginIndex, length, ::BooleanArray)

@InlineOnly
public inline fun <T> Array<out T>.subArray(
    targetType: Class<T>,
    beginIndex: Int = 0,
    length: Int = size - beginIndex
): Array<T> =
    subArray(this, size, beginIndex, length) { newTypedArray(targetType, it) }

@InlineOnly
public inline fun <@PureReifiable reified T> Array<out T>.subArray(
    beginIndex: Int = 0,
    length: Int = size - beginIndex
): Array<@Exact T> =
    subArray(T::class.java, beginIndex, length)

@InlineOnly
public inline fun <T> Array<out T>.subArrayUnsafe(
    targetFrom: Int = 0,
    length: Int = size - targetFrom
): Array<out T> =
    subArray(cast<Class<T>>(javaClass.componentType), targetFrom, length)