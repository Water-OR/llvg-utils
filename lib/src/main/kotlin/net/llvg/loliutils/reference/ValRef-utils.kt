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

@file:JvmName("ValRefUtils")

package net.llvg.loliutils.reference

import kotlin.internal.InlineOnly
import kotlin.reflect.KProperty
import kotlin.reflect.KProperty0

/**
 * @return A [ValRef] that warps the receiver [KProperty0]
 */
@InlineOnly
public inline val <T> KProperty0<T>.asValRef: KPropertyAsValRef<T>
    get() = KPropertyAsValRef(this)

/**
 * @return A [kotlin.properties.ReadOnlyProperty] that warps the receiver [ValRef]
 */
@InlineOnly
public inline val <T> ValRef<T>.asProperty: ValRefAsProperty<T>
    get() = ValRefAsProperty(this)

@InlineOnly
public inline operator fun <T> ValRef<T>.getValue(
    thisRef: Any?,
    property: KProperty<*>
): T =
    get()