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

import java.util.concurrent.locks.ReadWriteLock
import java.util.concurrent.locks.ReentrantReadWriteLock
import kotlin.internal.InlineOnly
import net.llvg.loliutils.concurrent.withReadLock
import net.llvg.loliutils.concurrent.withWriteLock
import net.llvg.loliutils.type.cast

public class InitOnceRef<T> : VarRef<T> {
    public var initialized: Boolean = false
        private set
    
    private val lock: ReadWriteLock = ReentrantReadWriteLock()
    private var value: Any? = null
    
    override fun get(): T {
        lock.withReadLock {
            if (!initialized) throwUninitialize()
        }
        
        return cast(value)
    }
    
    
    override fun set(
        value: T
    ) {
        lock.withReadLock {
            if (initialized) throwReinitialize()
        }
        
        lock.withWriteLock {
            if (initialized) throwReinitialize()
            initialized = true
            this.value = value
        }
    }
    
    @InlineOnly
    private inline fun throwUninitialize(): Nothing =
        throw IllegalStateException("Reference haven't been initialized yet")
    
    @InlineOnly
    private inline fun throwReinitialize(): Nothing =
        throw IllegalStateException("Reference has already been initialized")
}