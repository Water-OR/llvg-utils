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

@file:JvmName("TryUtils")

package net.llvg.loliutils.exception

@Suppress("UNUSED")
inline fun <R> tryRun(
        container: TryScopeContainer = LinkedListTryScope(),
        action: TryScope.() -> R
) = try {
        TryResult.Success(container.scope.run(action))
} catch (e: Throwable) {
        TryResult.Failure(e)
} finally {
        container.close()
}

@Suppress("UNUSED")
inline fun tryAct(
        container: TryScopeContainer = LinkedListTryScope(),
        action: TryScope.() -> Unit
) = try {
        TryResult.Success(container.scope.run(action))
} catch (e: Throwable) {
        TryResult.Failure(e)
} finally {
        container.close()
}

@Suppress("UNUSED")
inline val <R> TryResult<R>.isSuccess: Boolean
        get() = this is TryResult.Success

@Suppress("UNUSED")
inline val <R> TryResult<R>.isFailure: Boolean
        get() = this is TryResult.Failure

@Suppress("UNUSED")
inline infix fun <R, reified E : Throwable> TryResult<R>.onExcept(
        action: TryFailureScope<R>.(E) -> Unit
): TryResult<R> {
        if (this is TryResult.Failure && !executed && e is E) {
                executed()
                return TryFailureScope(this).apply { action(e) }.result
        }
        
        return this
}

@Suppress("UNUSED")
fun <R> TryResult<R>.orElse(
        fallback: R
) = if (this is TryResult.Success) r else fallback

@Suppress("UNUSED")
fun <R> TryResult<R>.orNull(
) = if (this is TryResult.Success) r else null

@Suppress("UNUSED")
fun <R> TryResult<R>.orThrow(
) = if (this is TryResult.Success) r else throw (this as TryResult.Failure).e