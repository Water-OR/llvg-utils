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

/**
 * Interface for managing resources that need to be closed
 *
 * This interface defines the contract for a dispatcher that handles [AutoCloseable] objects within a [tryWithResources] block
 *
 * Implementation should make sure that [AutoCloseable] objects are first-include-last-close
 *
 * @see tryWithResources
 * @see TryWithResourcesContext
 */
public interface TryWithResourcesDispatcher {
    /**
     * Includes [resource] which will be closed in the [close] function
     *
     * @param resource The [AutoCloseable] object to be included
     *
     * @see close
     * @see tryWithResources
     * @see TryWithResourcesContext
     */
    public infix fun include(resource: AutoCloseable)
    
    /**
     * Closes all the [AutoCloseable] objects witch are included
     *
     * @throws TryWithResourcesCloseFailedException If more than 1 resource throws exception while closing
     *
     * @see include
     * @see tryWithResources
     */
    @Throws(TryWithResourcesCloseFailedException::class)
    public fun close()
}