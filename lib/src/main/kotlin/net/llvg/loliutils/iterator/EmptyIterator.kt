/*
 * Copyright (C) 2025-2025 Water-OR
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

package net.llvg.loliutils.iterator

public object EmptyIterator :
  Iterator<Nothing>,
  MutableIterator<Nothing>,
  ListIterator<Nothing>,
  MutableListIterator<Nothing> {
    override fun hasNext(): Boolean =
        false
    
    override fun next(): Nothing =
        throw UnsupportedOperationException()
    
    override fun nextIndex(): Int =
        throw UnsupportedOperationException()
    
    override fun hasPrevious(): Boolean =
        false
    
    override fun previous(): Nothing =
        throw UnsupportedOperationException()
    
    override fun previousIndex(): Int =
        throw UnsupportedOperationException()
    
    override fun set(element: Nothing) {
        throw UnsupportedOperationException()
    }
    
    override fun add(element: Nothing) {
        throw UnsupportedOperationException()
    }
    
    override fun remove() {
        throw UnsupportedOperationException()
    }
}