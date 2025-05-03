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

package net.llvg.loliutils.reference

import java.util.concurrent.locks.ReadWriteLock
import java.util.concurrent.locks.ReentrantReadWriteLock
import net.llvg.loliutils.concurrent.withReadLock
import net.llvg.loliutils.concurrent.withWriteLock
import net.llvg.loliutils.others.eval
import net.llvg.loliutils.others.exec

@Suppress("UNUSED", "NOTHING_TO_INLINE")
class InitOnceRef<T> : VarRef<T> {
    val initialized: Boolean
        @JvmName("isInitialized")
        get() = lock.withReadLock {
            box?.eval { true } ?: false
        }
    
    private val lock: ReadWriteLock = ReentrantReadWriteLock()
    private var box: BoxRef<T>? = null
    
    override fun get(): T =
        lock.withReadLock {
            box?.get() ?: throwUninitialized()
        }
    
    
    override fun set(
        value: T
    ) {
        lock.withReadLock {
            box?.exec { throwReinitialized() }
        }
        
        lock.withWriteLock {
            box?.exec { throwReinitialized() }
            box = value.boxed
        }
    }
    
    private inline fun throwUninitialized(): Nothing =
        throw IllegalStateException("Reference haven't been initialized yet")
    
    private inline fun throwReinitialized(): Nothing =
        throw IllegalStateException("Reference has already been initialized")
}