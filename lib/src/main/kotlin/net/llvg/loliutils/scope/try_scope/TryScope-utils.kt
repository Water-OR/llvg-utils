/*
 * Copyright (C) 2025-2025 Water-OR
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

@file:[JvmName("TryScopeUtils") Suppress("UNUSED", "NOTHING_TO_INLINE")]

package net.llvg.loliutils.scope.try_scope

import net.llvg.loliutils.scope.EmptyLScope
import net.llvg.loliutils.scope.LScopeBreak
import net.llvg.loliutils.scope.get
import net.llvg.loliutils.scope.prfLScope
import net.llvg.loliutils.scope.runLScope

inline fun <R> tryRun(
    scope: TryScope<R> = ListTryScope(ArrayList()),
    action: TryScopeContext<R>.() -> R
): TryResult<R> =
    scope.use {
        try {
            TryResult.Success(it runLScope action)
        } catch (e: LScopeBreak) {
            throw e
        } catch (e: Throwable) {
            TryResult.Failure(e)
        }
    }

inline fun <T, R> T.tryLet(
    scope: TryScope<R> = ListTryScope(ArrayList()),
    action: TryScopeContext<R>.(T) -> R
): TryResult<R> =
    scope.use {
        try {
            TryResult.Success(it runLScope { action(this@tryLet) })
        } catch (e: LScopeBreak) {
            throw e
        } catch (e: Throwable) {
            TryResult.Failure(e)
        }
    }

inline fun tryPrf(
    scope: TryScope<Unit> = ListTryScope(ArrayList()),
    action: TryScopeContext<Unit>.() -> Unit
): TryResult<Unit> =
    scope.use {
        try {
            TryResult.Success(it prfLScope action)
        } catch (e: LScopeBreak) {
            throw e
        } catch (e: Throwable) {
            TryResult.Failure(e)
        }
    }

inline fun <T> T.tryAct(
    scope: TryScope<Unit> = ListTryScope(ArrayList()),
    action: TryScopeContext<Unit>.(T) -> Unit
): TryResult<Unit> =
    scope.use {
        try {
            TryResult.Success(it prfLScope { action(this@tryAct) })
        } catch (e: LScopeBreak) {
            throw e
        } catch (e: Throwable) {
            TryResult.Failure(e)
        }
    }

inline val <R> TryResult<R>.isSuccess: Boolean
    get() = this is TryResult.Success

inline val <R> TryResult<R>.isFailure: Boolean
    get() = this is TryResult.Failure

inline infix fun <R, reified E : Throwable> TryResult<R>.runExcept(
    action: TryFailureScopeContext<R>.(E) -> Unit
): TryResult<R> {
    if (this is TryResult.Failure && e is E) EmptyLScope<R>().run {
        try {
            TryFailureScopeContext.Impl(context).action(e)
        } catch (e: LScopeBreak) {
            return TryResult.Success(e[this])
        }
    }
    
    return this
}

inline infix fun <reified E : Throwable> TryResult<Unit>.prfExcept(
    action: TryFailureScopeContext<Unit>.(E) -> Unit
): TryResult<Unit> {
    if (this is TryResult.Failure && e is E) EmptyLScope<Unit>().run {
        try {
            TryFailureScopeContext.Impl(context).action(e)
        } catch (e: LScopeBreak) {
            return TryResult.Success(e[this])
        }
    }
    
    return this
}

inline fun <R> TryResult<R>.orElse(
    fallback: R
): R =
    if (this is TryResult.Success) r else fallback

inline val <R> TryResult<R>.orNull: R?
    @JvmName("orNull")
    get() = if (this is TryResult.Success) r else null

inline val <R> TryResult<R>.orThrow: R
    @JvmName("orThrow")
    get() = when (this) {
        is TryResult.Success -> r
        is TryResult.Failure -> throw e
    }