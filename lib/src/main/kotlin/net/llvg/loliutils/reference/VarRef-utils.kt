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

@file:JvmName("VarRefUtils")

package net.llvg.loliutils.reference

import kotlin.internal.InlineOnly
import kotlin.reflect.KMutableProperty0
import kotlin.reflect.KProperty

/**
 * @return A [VarRef] that warps the receiver [KMutableProperty0]
 */
@InlineOnly
public inline val <T> KMutableProperty0<T>.asVarRef: KPropertyAsVarRef<T>
    get() = KPropertyAsVarRef(this)

/**
 * @return A [kotlin.properties.ReadWriteProperty] that warps the receiver [VarRef]
 */
@InlineOnly
public inline val <T> VarRef<T>.asProperty: VarRefAsProperty<T>
    get() = VarRefAsProperty(this)

@InlineOnly
public inline operator fun <T> VarRef<T>.setValue(
    thisRef: Any?,
    property: KProperty<*>,
    value: T
) {
    set(value)
}