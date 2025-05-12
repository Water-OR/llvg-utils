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
public inline fun <@PureReifiable T> Array<out T>.copyTo(
    dest: Array<@Exact T>,
    destOffset: Int = 0,
    from: Int = 0,
    length: Int = size - from
): Array<@Exact T> {
    System.arraycopy(this, from, dest, destOffset, length)
    return dest
}

@PublishedApi
internal fun subArrayBeginIndexCheck(
    beginIndex: Int,
    sourceSize: Int
) {
    require(beginIndex >= 0) {
        "beginIndex($beginIndex) must be greater than or equals to 0"
    }
    require(beginIndex < sourceSize) {
        "beginIndex($beginIndex) must be less than sourceSize($sourceSize)"
    }
}

@PublishedApi
internal fun subArrayEndIndexCheck(
    endIndex: Int,
    sourceSize: Int
) {
    require(endIndex <= sourceSize) {
        "beginIndex+length=$endIndex must be less than or equal to sourceSize=$sourceSize"
    }
}

@InlineOnly
public inline fun ByteArray.subArray(
    beginIndex: Int = 0,
    length: Int = size - beginIndex
): ByteArray {
    subArrayBeginIndexCheck(beginIndex, size)
    
    if (length == 0) return ByteArray(0)
    subArrayEndIndexCheck(beginIndex + length, size)
    
    return copyTo(ByteArray(length), 0, beginIndex, length)
}

@InlineOnly
public inline fun ShortArray.subArray(
    beginIndex: Int = 0,
    length: Int = size - beginIndex
): ShortArray {
    subArrayBeginIndexCheck(beginIndex, size)
    
    if (length == 0) return ShortArray(0)
    subArrayEndIndexCheck(beginIndex + length, size)
    
    return copyTo(ShortArray(length), 0, beginIndex, length)
}

@InlineOnly
public inline fun IntArray.subArray(
    beginIndex: Int = 0,
    length: Int = size - beginIndex
): IntArray {
    subArrayBeginIndexCheck(beginIndex, size)
    
    if (length == 0) return IntArray(0)
    subArrayEndIndexCheck(beginIndex + length, size)
    
    return copyTo(IntArray(length), 0, beginIndex, length)
}

@InlineOnly
public inline fun LongArray.subArray(
    beginIndex: Int = 0,
    length: Int = size - beginIndex
): LongArray {
    subArrayBeginIndexCheck(beginIndex, size)
    
    if (length == 0) return LongArray(0)
    subArrayEndIndexCheck(beginIndex + length, size)
    
    return copyTo(LongArray(length), 0, beginIndex, length)
}

@InlineOnly
public inline fun CharArray.subArray(
    beginIndex: Int = 0,
    length: Int = size - beginIndex
): CharArray {
    subArrayBeginIndexCheck(beginIndex, size)
    
    if (length == 0) return CharArray(0)
    subArrayEndIndexCheck(beginIndex + length, size)
    
    return copyTo(CharArray(length), 0, beginIndex, length)
}

@InlineOnly
public inline fun FloatArray.subArray(
    beginIndex: Int = 0,
    length: Int = size - beginIndex
): FloatArray {
    subArrayBeginIndexCheck(beginIndex, size)
    
    if (length == 0) return FloatArray(0)
    subArrayEndIndexCheck(beginIndex + length, size)
    
    return copyTo(FloatArray(length), 0, beginIndex, length)
}

@InlineOnly
public inline fun DoubleArray.subArray(
    beginIndex: Int = 0,
    length: Int = size - beginIndex
): DoubleArray {
    subArrayBeginIndexCheck(beginIndex, size)
    
    if (length == 0) return DoubleArray(0)
    subArrayEndIndexCheck(beginIndex + length, size)
    
    return copyTo(DoubleArray(length), 0, beginIndex, length)
}

@InlineOnly
public inline fun BooleanArray.subArray(
    beginIndex: Int = 0,
    length: Int = size - beginIndex
): BooleanArray {
    subArrayBeginIndexCheck(beginIndex, size)
    
    if (length == 0) return BooleanArray(0)
    subArrayEndIndexCheck(beginIndex + length, size)
    
    return copyTo(BooleanArray(length), 0, beginIndex, length)
}

@InlineOnly
public inline fun <@PureReifiable reified T> Array<out T>.subArray(
    beginIndex: Int = 0,
    length: Int = size - beginIndex
): Array<@Exact T> {
    subArrayBeginIndexCheck(beginIndex, size)
    
    if (length == 0) return newTypedArray(0)
    subArrayEndIndexCheck(beginIndex + length, size)
    
    return copyTo(newTypedArray<@Exact T>(length), 0, beginIndex, length)
}

@InlineOnly
public inline fun <T> Array<out T>.subArray(
    targetType: Class<T>,
    beginIndex: Int = 0,
    length: Int = size - beginIndex
): Array<T> {
    subArrayBeginIndexCheck(beginIndex, size)
    
    if (length == 0) return newTypedArray(targetType, 0)
    subArrayEndIndexCheck(beginIndex + length, size)
    
    return copyTo(newTypedArray(targetType, length), 0, beginIndex, length)
}

@InlineOnly
public inline fun <T> Array<T>.subArrayUnsafe(
    targetFrom: Int = 0,
    length: Int = size - targetFrom
): Array<T> =
    subArray(cast<Class<T>>(javaClass.componentType), targetFrom, length)