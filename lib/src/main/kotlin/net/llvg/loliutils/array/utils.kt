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
import kotlin.internal.NoInfer
import kotlin.internal.PureReifiable

/**
 * @param type The class of component type of the returning array
 * @param size The size of the returning array
 *
 * @return A new array in [type] class with [size]
 */
@InlineOnly
public inline fun <T> newTypedArray(
    type: Class<@Exact T>,
    size: Int
): Array<@NoInfer T> =
    ArrayHelper.newArray(
        type,
        size
    )

/**
 * @param size The size of the returning array
 * @param T The component type of the returning array
 *
 * @return A new array in type [T] with [size]
 */
@InlineOnly
public inline fun <@PureReifiable reified T> newTypedArray(
    size: Int
): Array<@Exact T> =
    newTypedArray(
        T::class.java,
        size
    )


/**
 * @return A fixed-size [MutableList] that warps the receiver [Array]
 *
 * @see Arrays.asList
 */
@InlineOnly
@Suppress("ReplaceJavaStaticMethodWithKotlinAnalog")
public inline val <T> Array<T>.asList: MutableList<T>
    get() = Arrays.asList(*this)

/**
 * Copies a subsequence of the receiver [ByteArray] components to [dest]
 *
 * @receiver The [ByteArray] to be copied
 * @param dest The destination [ByteArray]
 * @param destOffset The beginning index (Inclusive) of the [dest] to copy into
 * @param from The beginning index (Inclusive) of the subsequence to copy, default is 0
 * @param length The length of the subsequence to copy, default is [size][ByteArray.size] - [from]
 *
 * @return [dest]
 * @throws IndexOutOfBoundsException If copying would cause access of data outside array bounds.
 *
 * @see System.arraycopy
 */
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

/**
 * Copies a subsequence of the receiver [ShortArray] components to [dest]
 *
 * @receiver The [ShortArray] to be copied
 * @param dest The destination [ShortArray]
 * @param destOffset The beginning index (Inclusive) of the [dest] to copy into
 * @param from The beginning index (Inclusive) of the subsequence to copy, default is 0
 * @param length The length of the subsequence to copy, default is [size][ShortArray.size] - [from]
 *
 * @return [dest]
 * @throws IndexOutOfBoundsException If copying would cause access of data outside array bounds.
 *
 * @see System.arraycopy
 */
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

/**
 * Copies a subsequence of the receiver [IntArray] components to [dest]
 *
 * @receiver The [IntArray] to be copied
 * @param dest The destination [IntArray]
 * @param destOffset The beginning index (Inclusive) of the [dest] to copy into
 * @param from The beginning index (Inclusive) of the subsequence to copy, default is 0
 * @param length The length of the subsequence to copy, default is [size][IntArray.size] - [from]
 *
 * @return [dest]
 * @throws IndexOutOfBoundsException If copying would cause access of data outside array bounds.
 *
 * @see System.arraycopy
 */
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

/**
 * Copies a subsequence of the receiver [LongArray] components to [dest]
 *
 * @receiver The [LongArray] to be copied
 * @param dest The destination [LongArray]
 * @param destOffset The beginning index (Inclusive) of the [dest] to copy into
 * @param from The beginning index (Inclusive) of the subsequence to copy, default is 0
 * @param length The length of the subsequence to copy, default is [size][LongArray.size] - [from]
 *
 * @return [dest]
 * @throws IndexOutOfBoundsException If copying would cause access of data outside array bounds.
 *
 * @see System.arraycopy
 */
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

/**
 * Copies a subsequence of the receiver [CharArray] components to [dest]
 *
 * @receiver The [CharArray] to be copied
 * @param dest The destination [CharArray]
 * @param destOffset The beginning index (Inclusive) of the [dest] to copy into
 * @param from The beginning index (Inclusive) of the subsequence to copy, default is 0
 * @param length The length of the subsequence to copy, default is [size][CharArray.size] - [from]
 *
 * @return [dest]
 * @throws IndexOutOfBoundsException If copying would cause access of data outside array bounds.
 *
 * @see System.arraycopy
 */
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

/**
 * Copies a subsequence of the receiver [FloatArray] components to [dest]
 *
 * @receiver The [FloatArray] to be copied
 * @param dest The destination [FloatArray]
 * @param destOffset The beginning index (Inclusive) of the [dest] to copy into
 * @param from The beginning index (Inclusive) of the subsequence to copy, default is 0
 * @param length The length of the subsequence to copy, default is [size][FloatArray.size] - [from]
 *
 * @return [dest]
 * @throws IndexOutOfBoundsException If copying would cause access of data outside array bounds.
 *
 * @see System.arraycopy
 */
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

/**
 * Copies a subsequence of the receiver [DoubleArray] components to [dest]
 *
 * @receiver The [DoubleArray] to be copied
 * @param dest The destination [DoubleArray]
 * @param destOffset The beginning index (Inclusive) of the [dest] to copy into
 * @param from The beginning index (Inclusive) of the subsequence to copy, default is 0
 * @param length The length of the subsequence to copy, default is [size][DoubleArray.size] - [from]
 *
 * @return [dest]
 * @throws IndexOutOfBoundsException If copying would cause access of data outside array bounds.
 *
 * @see System.arraycopy
 */
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

/**
 * Copies a subsequence of the receiver [BooleanArray] components to [dest]
 *
 * @receiver The [BooleanArray] to be copied
 * @param dest The destination [BooleanArray]
 * @param destOffset The beginning index (Inclusive) of the [dest] to copy into
 * @param from The beginning index (Inclusive) of the subsequence to copy, default is 0
 * @param length The length of the subsequence to copy, default is [size][BooleanArray.size] - [from]
 *
 * @return [dest]
 * @throws IndexOutOfBoundsException If copying would cause access of data outside array bounds.
 *
 * @see System.arraycopy
 */
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

/**
 * Copies a subsequence of the receiver [Array] components to [dest]
 *
 * @receiver The [Array] to be copied
 * @param dest The destination [Array]
 * @param destOffset The beginning index (Inclusive) of the [dest] to copy into
 * @param from The beginning index (Inclusive) of the subsequence to copy, default is 0
 * @param length The length of the subsequence to copy, default is [size][Array.size] - [from]
 *
 * @return [dest]
 * @throws IndexOutOfBoundsException If copying would cause access of data outside array bounds.
 *
 * @see System.arraycopy
 */
@InlineOnly
public inline fun <T> Array<out T>.copyTo(
    dest: Array<@Exact T>,
    destOffset: Int = 0,
    from: Int = 0,
    length: Int = size - from
): Array<@NoInfer T> {
    System.arraycopy(this, from, dest, destOffset, length)
    return dest
}