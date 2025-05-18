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

@file:JvmName("ClassUtils")

package net.llvg.loliutils.type

import kotlin.internal.InlineOnly
import kotlin.internal.NoInfer
import kotlin.internal.PureReifiable

/**
 * Check if the receiver [Class] is extended from class [T]
 *
 * @receiver The [Class] being checked
 * @param T The type to check against
 *
 * @return `true` if the receiver [Class] is extended from type [T], otherwise `false`
 *
 * @see asExtend
 */
@InlineOnly
public inline fun <@PureReifiable reified T> Class<*>.isExtend(): Boolean =
    T::class.java.isAssignableFrom(this)

/**
 * Casts the receiver [Class] as extending [T] if possible, otherwise returns `null`
 *
 * @receiver The [Class] to attempt casting on
 * @param T The target type to cast to
 *
 * @return The receiver [Class] being cast as extending [T] if possible, otherwise `null`
 *
 * @see isExtend
 */
@InlineOnly
public inline fun <@PureReifiable reified T> Class<*>.asExtend(): Class<out @NoInfer T>? =
    if (isExtend<T>()) asSubclass(T::class.java) else null

/**
 * Casts the receiver [Class] to subclass of [T] if possible, otherwise returns `null`
 *
 * @receiver The [Class] to attempt casting on
 * @param T The target type to cast to
 *
 * @return The receiver [Class] being cast to subclass of [T] if possible, otherwise `null`
 *
 * @see isExtend
 */
@InlineOnly
@Deprecated("", ReplaceWith("asExtend<T>()", "net.llvg.loliutils.type.asExtend"))
public inline fun <@PureReifiable reified T> Class<*>.tryExtend(): Class<out @NoInfer T>? =
    if (isExtend<T>()) asSubclass(T::class.java) else null