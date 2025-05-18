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

package net.llvg.loliutils.reference

/**
 * An implementation of [VarRef] that the [set] function can be called once at most once
 *
 * @see VarRef
 */
public class InitOnceRef<T> : VarRef<T> {
    @Volatile
    public var initialized: Boolean = false
        private set
    
    private var ref: ValRef<T>? = null
    
    override fun get(): T {
        return ref?.get() ?: throw IllegalStateException("Reference haven't been initialized yet")
    }
    
    @Synchronized
    override fun set(
        value: T
    ) {
        if (ref !== null) throw IllegalStateException("Reference has already been initialized")
        
        ref = value.boxed
    }
    
}