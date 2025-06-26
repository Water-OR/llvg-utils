@file:JvmName("TimeUtils")

package net.llvg.llvg_utils.time

import kotlin.internal.InlineOnly

@Deprecated("")
public const val nanoSecondToMicroSecond: Double = 1_000.0

@Deprecated("")
public const val nanoSecondToMilliSecond: Double = 1_000_000.0

@Deprecated("")
public const val nanoSecondToSecond: Double = 1_000_000_000.0

/**
 * @see System.nanoTime
 */
@InlineOnly
@Deprecated("")
public inline val systemNanoTime: Long
    get() = System.nanoTime()

/**
 * @see System.nanoTime
 */
@InlineOnly
@Deprecated("")
@Suppress("DEPRECATION")
public inline val systemMicroTime: Double
    get() = System.nanoTime() / nanoSecondToMicroSecond

/**
 * @see System.nanoTime
 */
@InlineOnly
@Deprecated("")
@Suppress("DEPRECATION")
public inline val systemMilliTime: Double
    get() = System.nanoTime() / nanoSecondToMilliSecond

/**
 * @see System.nanoTime
 */
@InlineOnly
@Deprecated("")
@Suppress("DEPRECATION")
public inline val systemTime: Double
    get() = System.nanoTime() / nanoSecondToSecond