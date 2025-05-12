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

@file:JvmName("TryScopeUtils")

package net.llvg.loliutils.scope.try_scope

import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import kotlin.internal.InlineOnly

@InlineOnly
public inline fun tryPrf(
    scope: TryScope = ListTryScope(ArrayList()),
    action: TryScope.Context.() -> Unit
): VoidTryResult {
    contract {
        callsInPlace(action, InvocationKind.AT_MOST_ONCE)
    }
    
    return try {
        TryScope.Context(scope).action()
        VoidTryResult.Success
    } catch (e: Throwable) {
        VoidTryResult.Failure(e)
    } finally {
        scope.close()
    }
}

@InlineOnly
public inline fun <R> tryRun(
    scope: TryScope = ListTryScope(ArrayList()),
    action: TryScope.Context.() -> R
): TypeTryResult<R> {
    contract {
        callsInPlace(action, InvocationKind.AT_MOST_ONCE)
    }
    
    return try {
        TypeTryResult.Success(TryScope.Context(scope).action())
    } catch (e: Throwable) {
        TypeTryResult.Failure(e)
    } finally {
        scope.close()
    }
}