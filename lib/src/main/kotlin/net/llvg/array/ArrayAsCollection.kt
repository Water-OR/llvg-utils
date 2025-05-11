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

package net.llvg.array

public class ArrayAsCollection<out T>(
    public val array: Array<out T>
) : Collection<T> {
    override val size: Int
        get() = array.size
    
    override fun isEmpty(): Boolean =
        array.isEmpty()
    
    override fun iterator(): Iterator<T> =
        array.iterator()
    
    override fun contains(
        element: @UnsafeVariance T
    ): Boolean =
        array.contains(element)
    
    override fun containsAll(
        elements: Collection<@UnsafeVariance T>
    ): Boolean =
        elements.all(array::contains)
}