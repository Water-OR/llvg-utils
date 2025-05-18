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

@file:JvmName("IteratorUtils")

package net.llvg.loliutils.iterator

import kotlin.internal.InlineOnly

/**
 * @return The [EmptyIterator] safely cast to [Iterator] with type argument [T]
 */
@InlineOnly
public inline fun <T> emptyIterator(): Iterator<T> =
    EmptyIterator

/**
 * @return The [EmptyIterator] safely cast to [MutableIterator] with type argument [T]
 */
@InlineOnly
public inline fun <T> emptyMutableIterator(): MutableIterator<T> =
    EmptyIterator

/**
 * @return The [EmptyIterator] safely cast to [ListIterator] with type argument [T]
 */
@InlineOnly
public inline fun <T> emptyListIterator(): ListIterator<T> =
    EmptyIterator

/**
 * @return The [EmptyIterable] safely cast to [Iterable] with type argument [T]
 */
@InlineOnly
public inline fun <T> emptyIterable(): Iterable<T> =
    EmptyIterable

/**
 * @return The [EmptyIterable] safely cast to [MutableIterable] with type argument [T]
 */
@InlineOnly
public inline fun <T> emptyMutableIterable(): MutableIterable<T> =
    EmptyIterable