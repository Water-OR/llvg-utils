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

import kotlin.internal.InlineOnly
import kotlin.internal.NoInfer

/**
 * Context of [tryWithResources], witch provides methods to include [AutoCloseable] into [dispatcher]
 *
 * @see tryWithResources
 * @see TryWithResourcesDispatcher
 */
public class TryWithResourcesContext(
    private val dispatcher: TryWithResourcesDispatcher
) {
    /**
     * Adds [resource] to [dispatcher]
     *
     * @param resource The [AutoCloseable] to be included
     * @param T The type of [resource]
     *
     * @return The [resource]
     *
     * @see TryWithResourcesDispatcher.include
     */
    public fun <T : AutoCloseable> include(
        resource: T
    ): @NoInfer T {
        dispatcher include resource
        return resource
    }
    
    /**
     * Adds the receiver [AutoCloseable] to [dispatcher]
     *
     * @return The receiver
     *
     * @see TryWithResourcesDispatcher.include
     */
    @InlineOnly
    public inline val <T : AutoCloseable> T.include: @NoInfer T
        get() = include(this)
    
    /**
     * Adds the receiver [AutoCloseable] to [dispatcher]
     *
     * @return The receiver
     *
     * @see TryWithResourcesDispatcher.include
     */
    @InlineOnly
    public inline operator fun <T : AutoCloseable> T.unaryPlus(): @NoInfer T =
        include(this)
}