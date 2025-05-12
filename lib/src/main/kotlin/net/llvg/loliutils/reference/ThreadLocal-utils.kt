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

@file:JvmName("ThreadLocalUtils")

package net.llvg.loliutils.reference

import kotlin.internal.InlineOnly
import kotlin.reflect.KProperty

@InlineOnly
public inline val <T> ThreadLocal<T>.asRef: ThreadLocalAsRef<T>
    get() = ThreadLocalAsRef(this)

@InlineOnly
@JvmSynthetic
public inline fun <T> ThreadLocal(
    crossinline initializer: () -> T
): ThreadLocal<T> =
    ThreadLocal.withInitial { initializer() }

@InlineOnly
@JvmSynthetic
public inline operator fun <T> ThreadLocal<T>.provideDelegate(
    self: Any?,
    property: KProperty<*>
): ThreadLocalAsRef<T> =
    ThreadLocalAsRef(this)