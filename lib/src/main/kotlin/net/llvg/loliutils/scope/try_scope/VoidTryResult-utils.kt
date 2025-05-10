/*
 * Copyright (C) 2025 Water-OR
 *
 * This file is part of LLVG Utils
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

@file:JvmName("VoidTryResultUtils")

package net.llvg.loliutils.scope.try_scope

import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import net.llvg.loliutils.scope.IdentifiedReturn

public inline fun VoidTryResult.isSuccess(): Boolean {
    contract {
        returns(true) implies (this@isSuccess is VoidTryResult.Success)
        returns(false) implies (this@isSuccess is VoidTryResult.Failure)
    }
    
    return this is VoidTryResult.Success
}

public inline fun VoidTryResult.isFailure(): Boolean {
    contract {
        returns(true) implies (this@isFailure is VoidTryResult.Failure)
        returns(false) implies (this@isFailure is VoidTryResult.Success)
    }
    
    return this is VoidTryResult.Failure
}

public inline fun <E> VoidTryResult.onExcept(
    clazz: Class<out E>,
    action: VoidFailureContext.(E) -> Unit
): VoidTryResult {
    contract {
        callsInPlace(action, InvocationKind.AT_MOST_ONCE)
    }
    
    if (isFailure() && clazz.isInstance(e)) {
        val context = VoidFailureContext.Impl()
        try {
            context.action(clazz.cast(e))
        } catch (fallback: IdentifiedReturn) {
            if (fallback.ident === context) {
                return VoidTryResult.Success
            } else {
                throw fallback
            }
        }
    }
    
    return this
}

public inline infix fun <reified E> VoidTryResult.onExcept(
    action: VoidFailureContext.(E) -> Unit
): VoidTryResult {
    contract {
        callsInPlace(action, InvocationKind.AT_MOST_ONCE)
    }
    
    return onExcept(E::class.java, action)
}

@Suppress("UnusedReceiverParameter")
public inline fun VoidTryResult.orIgnore() = Unit

public inline infix fun VoidTryResult.orGet(provider: (Throwable) -> Unit) {
    contract {
        callsInPlace(provider, InvocationKind.AT_MOST_ONCE)
    }
    
    if (isFailure()) provider(e)
}

public inline fun VoidTryResult.orNull(): Unit? {
    contract {
        returns(null) implies (this@orNull is VoidTryResult.Failure)
        returnsNotNull() implies (this@orNull is VoidTryResult.Success)
    }
    
    return if (isSuccess()) Unit else null
}

public inline fun VoidTryResult.orThrow() {
    contract {
        returns() implies (this@orThrow is VoidTryResult.Success)
    }
    
    return if (isSuccess()) Unit else throw e
}