/*
 * Copyright (C) 2025-2025 Water-OR
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

@file:[JvmName("ElvisUtils") Suppress("UNUSED")]

package net.llvg.loliutils.others

inline val Boolean.takeTrue: Boolean?
    get() = if (this) true else null

inline val Boolean.takeFalse: Boolean?
    get() = if (this) null else false

inline val Any?.invertElvis: Unit?
    get() = if (this === null) Unit else null

inline fun <T> T.prf(
    action: T.() -> Unit
) =
    action()

inline fun <T> T.act(
    action: (T) -> Unit
) =
    action(this)

inline fun prf(
    action: () -> Unit
) =
    action()

@Suppress("UnusedReceiverParameter")
inline fun Any?.exec(
    action: () -> Unit
) =
    action()

@Suppress("UnusedReceiverParameter")
inline fun <R> Any?.eval(
    action: () -> R
): R =
    action()