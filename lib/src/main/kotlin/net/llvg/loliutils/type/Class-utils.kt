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

@file:JvmName("ClassUtils")

package net.llvg.loliutils.type

public inline fun <reified T> Class<*>.isExtend(): Boolean =
    T::class.java.isAssignableFrom(this)

@Suppress("UNCHECKED_CAST")
public inline fun <reified T> Class<*>.tryExtend(): Class<out T>? =
    if (isExtend<T>()) this as Class<out T> else null

public inline fun <reified T> Class<*>.isSuper(): Boolean =
    isAssignableFrom(T::class.java)

@Suppress("UNCHECKED_CAST")
public inline fun <reified T> Class<*>.trySuper(): Class<in T>? =
    if (isSuper<T>()) this as Class<in T> else null