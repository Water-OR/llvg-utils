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

import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import kotlin.internal.InlineOnly

/**
 * Calls the [action] with [TryWithResourcesContext] as its receiver and returns its result
 *
 * [TryWithResourcesContext] provides methods to add [AutoCloseable] object to [dispatcher]
 *
 * All [AutoCloseable] objects in added to the [dispatcher] are closed after [action] called
 *
 * @param dispatcher The [TryWithResourcesDispatcher] to manage and close the resources. default is [TryWithResourcesDispatcherListImpl] with a [ArrayList]
 * @param action The action to be
 *
 * @see TryWithResourcesContext
 * @see TryWithResourcesDispatcher
 */
@InlineOnly
public inline fun <R> tryWithResources(
    dispatcher: TryWithResourcesDispatcher = TryWithResourcesDispatcherListImpl(ArrayList()),
    action: TryWithResourcesContext.() -> R
): R {
    contract {
        callsInPlace(action, InvocationKind.EXACTLY_ONCE)
    }
    
    val context = TryWithResourcesContext(dispatcher)
    var e1: Throwable? = null
    
    try {
        return context.action()
    } catch (e: Throwable) {
        e1 = e
        throw e
    } finally {
        dispatcher.closeResources(e1)
    }
}

/**
 * For stacktrace
 */
@PublishedApi
internal fun TryWithResourcesDispatcher.closeResources(
    e1: Throwable?
): Unit = when (e1) {
    null -> close()
    else -> try {
        close()
    } catch (e: Throwable) {
        e1.addSuppressed(e)
    }
}