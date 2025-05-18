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

@file:JvmName("ScopeUtils")

package net.llvg.loliutils.scope

import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import kotlin.internal.InlineOnly
import kotlin.internal.PureReifiable
import net.llvg.loliutils.others.prf

/**
 * Calls the [action] with [IdentifierProvider] as its receiver
 *
 * @param action The action to be called
 */
@InlineOnly
public inline fun prfIdentified(
    action: IdentifierProvider.() -> Unit
) {
    contract {
        callsInPlace(action, InvocationKind.AT_MOST_ONCE)
    }
    
    IdentifierProvider.Impl().prf {
        try {
            action()
        } catch (e: IdentifiedReturn) {
            e check ident
        }
    }
}

/**
 * Calls the [action] with [IdentifierProvider] as its receiver and returns its result
 *
 * @param type The return type class
 * @param action The action to be called
 */
@InlineOnly
public inline fun <R> runIdentified(
    type: Class<out R>,
    action: IdentifierProvider.() -> R
): R {
    contract {
        callsInPlace(action, InvocationKind.AT_MOST_ONCE)
    }
    
    IdentifierProvider.Impl().prf {
        try {
            return action()
        } catch (e: IdentifiedReturn) {
            e check ident
            return e.value(type)
        }
    }
}

/**
 * Calls the [action] with [IdentifierProvider] as its receiver and returns its result
 *
 * @param action The action to be called
 * @param R The return type
 */
@InlineOnly
public inline fun <@PureReifiable reified R> runIdentified(
    action: IdentifierProvider.() -> R
): R {
    contract {
        callsInPlace(action, InvocationKind.AT_MOST_ONCE)
    }
    
    return runIdentified(R::class.java, action)
}