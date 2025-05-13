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

@file:JvmName("CollectionUtils")

package net.llvg.loliutils.iterator

import kotlin.internal.InlineOnly

@InlineOnly
public inline infix fun <T> T.addInto(
    collection: MutableCollection<T>
): Boolean =
    collection.add(this)

@InlineOnly
public inline infix fun <T> T.remFrom(
    collection: MutableCollection<T>
): Boolean =
    collection.remove(this)

@InlineOnly
public inline infix fun <T> Array<T>.addInto(
    collection: MutableCollection<T>
): Boolean =
    collection.addAll(this)

@InlineOnly
public inline infix fun <T> Array<T>.remFrom(
    collection: MutableCollection<T>
): Boolean =
    collection.removeAll(this)

@InlineOnly
public inline infix fun <T> Iterable<T>.addInto(
    collection: MutableCollection<T>
): Boolean =
    collection.addAll(this)

@InlineOnly
public inline infix fun <T> Iterable<T>.remFrom(
    collection: MutableCollection<T>
): Boolean =
    collection.removeAll(this)

@InlineOnly
public inline infix fun <T> Sequence<T>.addInto(
    collection: MutableCollection<T>
): Boolean =
    collection.addAll(this)

@InlineOnly
public inline infix fun <T> Sequence<T>.remFrom(
    collection: MutableCollection<T>
): Boolean =
    collection.removeAll(this)