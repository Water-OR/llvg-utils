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

@file:[JvmName("GettableUtils") Suppress("UNUSED", "NOTHING_TO_INLINE")]

package net.llvg.loliutils.function

import net.llvg.loliutils.type.castTo

inline operator fun <T> Gettable<T>.invoke(): T =
    get()

inline val <T> Gettable<T>.asLambda: () -> T
    get() = ::get

inline fun <T> makeGettable(
    crossinline action: () -> T
): Gettable<T> =
    Gettable { action() }

inline fun <R> Gettable<*>.cast(): R =
    get().castTo()