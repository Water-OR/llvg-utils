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

package net.llvg.loliutils.time

const val nanoSecondToMicroSecond = 1_000.0

const val nanoSecondToMilliSecond = 1_000_000.0

const val nanoSecondToSecond = 1_000_000_000.0

val systemNanoTime: Long get() = System.nanoTime()

@Suppress("UNUSED")
val systemMicroTime: Double get() = systemNanoTime / nanoSecondToMicroSecond

@Suppress("UNUSED")
val systemMilliTime: Double get() = systemNanoTime / nanoSecondToMilliSecond

@Suppress("UNUSED")
val systemTime: Double get() = systemNanoTime / nanoSecondToSecond

@Suppress("UNUSED")
inline fun runWithTime(
        action: TimeScope.() -> Unit
) = TimeScope().apply(action)