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

@file:[JvmName("TypeUtils") Suppress("UNUSED", "NOTHING_TO_INLINE")]

package net.llvg.loliutils.type

@Suppress("UNCHECKED_CAST")
inline fun <R> Any?.castTo(): R =
    this as R

@Suppress("UNCHECKED_CAST")
inline fun <R> cast(
    value: Any?
): R =
    value as R

@Suppress("UNCHECKED_CAST")
@get:JvmName("asNotNull")
inline val <T> T?.asNotNull: T
    get() = this as T