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

@file:JvmName("DelegateUtils")

package net.llvg.loliutils.delegate

import kotlin.reflect.KMutableProperty0
import kotlin.reflect.KProperty
import kotlin.reflect.KProperty0

@Suppress("UNUSED")
inline val <T> T.wrapBox: ValRef<T>
        get() = object : ValRef<T> {
                override fun get(
                ): T = this@wrapBox
        }

@Suppress("UNUSED")
inline val <T> KProperty0<T>.wrapVal: ValRef<T>
        get() = ValRef.Impl(this)

@Suppress("UNUSED")
inline val <T> KMutableProperty0<T>.wrapVar: VarRef<T>
        get() = VarRef.Impl(this) { set(it) }

@Suppress("UNUSED", "UNCHECKED_CAST")
fun <R> ValRef<*>.cast(
): R = get() as R

@Suppress("UNUSED")
operator fun <T> ValRef<T>.getValue(
        self: Any?,
        property: KProperty<*>
): T = get()

@Suppress("UNUSED")
operator fun <T> VarRef<T>.setValue(
        self: Any?,
        property: KProperty<*>,
        o: T
) {
        set(o)
}