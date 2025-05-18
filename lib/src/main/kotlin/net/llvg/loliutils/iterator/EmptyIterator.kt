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

package net.llvg.loliutils.iterator

/**
 * An implementation of [Iterator], [ListIterator] and [MutableIterator] which is always empty
 *
 * @see Iterator
 * @see ListIterator
 * @see MutableIterator
 */
public data object EmptyIterator :
  Iterator<Nothing>,
  ListIterator<Nothing>,
  MutableIterator<Nothing> {
    override fun hasNext(): Boolean =
        false
    
    override fun next(): Nothing =
        throw NoSuchElementException()
    
    override fun nextIndex(): Int =
        0
    
    override fun hasPrevious(): Boolean =
        false
    
    override fun previous(): Nothing =
        throw NoSuchElementException()
    
    override fun previousIndex(): Int =
        -1
    
    override fun remove(): Nothing =
        throw IllegalStateException()
}