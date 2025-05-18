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

@file:JvmName("TypeUtils")

package net.llvg.loliutils.type

import kotlin.internal.InlineOnly

/**
 * Unchecked cast the receiver object to type [R]
 *
 * @receiver The object to attempt casting on
 * @param R The target type to cast to
 *
 * @return The receiver object being cast to type [R]
 */
@InlineOnly
@Suppress("UNCHECKED_CAST")
@Deprecated("", ReplaceWith("cast<R>()", "net.llvg.loliutils.type.cast"))
public inline fun <R> Any?.castTo(): R =
    this as R

/**
 * Unchecked cast the receiver object to type [R]
 *
 * @receiver The object to attempt casting on
 * @param R The target type to cast to
 *
 * @return The receiver object being cast to type [R]
 */
@InlineOnly
@Suppress("UNCHECKED_CAST")
@JvmName("castReceiver")
public inline fun <R> Any?.cast(): R =
    this as R

/**
 * Unchecked cast the [value] to type [R]
 *
 * @param value The object to attempt casting on
 * @param R The target type to cast to
 *
 * @return The [value] being cast to type [R]
 */
@InlineOnly
@Suppress("UNCHECKED_CAST")
public inline fun <R> cast(
    value: Any?
): R =
    value as R

/**
 * Unchecked cast the receiver object to non-null type
 *
 * @receiver The object to attempt casting on
 * @param T The non-null target type to cast to
 *
 * @return The receiver object being cast to non-null type
 */
@InlineOnly
@Suppress("UNCHECKED_CAST")
public inline val <T : Any> T?.asNotNull: T
    get() = this as T