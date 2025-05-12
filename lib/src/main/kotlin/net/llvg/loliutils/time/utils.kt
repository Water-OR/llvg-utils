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

@file:JvmName("TimeUtils")

package net.llvg.loliutils.time

import kotlin.internal.InlineOnly

public const val nanoSecondToMicroSecond: Double = 1_000.0

public const val nanoSecondToMilliSecond: Double = 1_000_000.0

public const val nanoSecondToSecond: Double = 1_000_000_000.0

@InlineOnly
public inline val systemNanoTime: Long
    get() = System.nanoTime()

@InlineOnly
public inline val systemMicroTime: Double
    get() = System.nanoTime() / nanoSecondToMicroSecond

@InlineOnly
public inline val systemMilliTime: Double
    get() = System.nanoTime() / nanoSecondToMilliSecond

@InlineOnly
public inline val systemTime: Double
    get() = System.nanoTime() / nanoSecondToSecond