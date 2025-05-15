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

@InlineOnly
@Throws(TryWithResourcesCloseFailedException::class)
public inline fun <R> tryWithResources(
    dispatcher: TryWithResourcesDispatcher = TryWithResourcesDispatcherListImpl(ArrayList(), Throwable::printStackTrace),
    action: TryWithResourcesContext.() -> R
): R {
    contract {
        callsInPlace(action, InvocationKind.EXACTLY_ONCE)
    }
    
    val context = TryWithResourcesContext(dispatcher)
    
    return try {
        context.action()
    } finally {
        dispatcher.close()
    }
}