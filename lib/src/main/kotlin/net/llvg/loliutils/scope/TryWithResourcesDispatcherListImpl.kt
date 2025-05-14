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

package net.llvg.loliutils.scope

import java.util.concurrent.locks.ReadWriteLock
import java.util.concurrent.locks.ReentrantReadWriteLock
import net.llvg.loliutils.concurrent.withReadLock
import net.llvg.loliutils.concurrent.withWriteLock

public class TryWithResourcesDispatcherListImpl(
    private val list: MutableList<AutoCloseable>,
    private val logger: (Throwable) -> Unit
) : TryWithResourcesDispatcher {
    
    @Volatile
    private var closed: Boolean = false
    private val closeLock: ReadWriteLock = ReentrantReadWriteLock()
    
    @Synchronized
    override fun include(
        resource: AutoCloseable
    ) {
        closeLock.withReadLock {
            if (closed) throw UnsupportedOperationException("dispatcher already closed")
        }
        
        list += resource
    }
    
    @Synchronized
    @Throws(TryWithResourcesCloseFailedException::class)
    override fun close() {
        closeLock.withReadLock {
            if (closed) return
        }
        
        closeLock.withWriteLock {
            if (closed) return
            closed = true
        }
        
        val failures = mutableListOf<Triple<Int, AutoCloseable, Throwable>>()
        list.asReversed().forEachIndexed { id, it ->
            try {
                it.close()
            } catch (e: Throwable) {
                logger(RuntimeException("Failed to close #$id entry, its class is ${it.javaClass}", e))
                failures += Triple(id, it, e)
            }
        }
        if (failures.isNotEmpty()) {
            throw TryWithResourcesCloseFailedException(failures)
        }
    }
}