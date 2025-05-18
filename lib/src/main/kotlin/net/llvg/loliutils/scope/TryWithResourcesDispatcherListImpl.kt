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

import net.llvg.loliutils.array.asList
import net.llvg.loliutils.others.act

/**
 * An implementation of [TryWithResourcesDispatcher] that uses a [list] to store [AutoCloseable] objects
 *
 * @see TryWithResourcesDispatcher
 */
public class TryWithResourcesDispatcherListImpl(
    private val list: MutableList<AutoCloseable>,
    private val logger: (Int, AutoCloseable, Throwable) -> Unit
) : TryWithResourcesDispatcher {
    public constructor(
        list: MutableList<AutoCloseable>
    ) : this(
        list,
        { id, it, e -> RuntimeException("Failed to close #$id entry, its class is ${it.javaClass}", e).printStackTrace() }
    )
    
    @Volatile
    private var closed: Boolean = false
    
    @Synchronized
    override fun include(
        resource: AutoCloseable
    ) {
        if (closed) throw UnsupportedOperationException("dispatcher already closed")
        
        list += resource
    }
    
    @Synchronized
    @Throws(TryWithResourcesCloseFailedException::class)
    override fun close() {
        if (closed) return
        closed = true
        
        list.toTypedArray().asList
          .run { listIterator(size) }
          .run {
              buildList {
                  while (hasPrevious()) {
                      val id = previousIndex()
                      val i = previous()
                      
                      try {
                          i.close()
                      } catch (e: Throwable) {
                          logger(id, i, e)
                          Triple(id, i, e).act(::add)
                      }
                  }
              }
          }
          .run {
              if (isNotEmpty()) {
                  throw TryWithResourcesCloseFailedException(this)
              }
          }
    }
}