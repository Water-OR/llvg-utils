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

@file:JvmName("TypeTryResultUtils")

package net.llvg.loliutils.scope.try_scope

import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import kotlin.internal.InlineOnly
import net.llvg.loliutils.others.act
import net.llvg.loliutils.others.prf
import net.llvg.loliutils.scope.IdentifiedReturn

@InlineOnly
public inline fun <R> TypeTryResult<R>.isSuccess(): Boolean {
    contract {
        returns(true) implies (this@isSuccess is TypeTryResult.Success)
        returns(false) implies (this@isSuccess is TypeTryResult.Failure)
    }
    
    return this is TypeTryResult.Success
}

@InlineOnly
public inline fun <R> TypeTryResult<R>.isFailure(): Boolean {
    contract {
        returns(true) implies (this@isFailure is TypeTryResult.Failure)
        returns(false) implies (this@isFailure is TypeTryResult.Success)
    }
    
    return this is TypeTryResult.Failure
}

@InlineOnly
@JvmSynthetic
public inline fun <R, E : Throwable> TypeTryResult<R>.onExcept(
    clazz: Class<out E>,
    action: TypeFailureContext<R>.(E) -> Unit
): TypeTryResult<R> {
    contract {
        callsInPlace(action, InvocationKind.AT_MOST_ONCE)
    }
    
    if (isFailure() && clazz.isInstance(e)) TypeFailureContext.Impl<R>().prf {
        try {
            action(clazz.cast(e))
        } catch (fallback: IdentifiedReturn) {
            if (fallback.ident === this) {
                return TypeTryResult.Success(fallback.value())
            } else {
                throw e
            }
        }
    }
    
    return this
}

@InlineOnly
@JvmSynthetic
public inline infix fun <R, reified E : Throwable> TypeTryResult<R>.onExcept(
    action: TypeFailureContext<R>.(E) -> Unit
): TypeTryResult<R> {
    contract {
        callsInPlace(action, InvocationKind.AT_MOST_ONCE)
    }
    
    return onExcept(E::class.java, action)
}

@InlineOnly
public inline infix fun <R> TypeTryResult<R>.orElse(
    fallback: R
): R =
    if (isSuccess()) r else fallback

@InlineOnly
public inline infix fun <R> TypeTryResult<R>.orGet(
    provider: (Throwable) -> R
): R {
    contract {
        callsInPlace(provider, InvocationKind.AT_MOST_ONCE)
    }
    
    return if (isSuccess()) r else provider(e)
}

@InlineOnly
public inline fun <R> TypeTryResult<R>.orNull(): R? {
    contract {
        returns(null) implies (this@orNull is TypeTryResult.Failure)
        returnsNotNull() implies (this@orNull is TypeTryResult.Success)
    }
    
    return if (isSuccess()) r else null
}

@InlineOnly
public inline fun <R> TypeTryResult<R>.orThrow(): R {
    contract {
        returns() implies (this@orThrow is TypeTryResult.Success)
    }
    
    return if (isSuccess()) r else throw e
}