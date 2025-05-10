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

@file:JvmName("ValRefUtils")

package net.llvg.loliutils.reference

import kotlin.reflect.KProperty
import kotlin.reflect.KProperty0
import net.llvg.loliutils.function.Gettable

public inline val <T> KProperty0<T>.asValRef: PropertyAsValRef<T>
    get() = PropertyAsValRef(this)

public inline fun <T> makeRef(
    getter: Gettable<T>
): LambdaValRef<T> =
    LambdaValRef(getter)

public inline val <T> ValRef<T>.asProperty: ValRefAsProperty<T>
    get() = ValRefAsProperty(this)

public inline operator fun <T> ValRef<T>.provideDelegate(
    thisRef: Any?,
    property: KProperty<*>
): ValRefAsProperty<T> =
    asProperty