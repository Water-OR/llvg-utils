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

public inline infix fun <T> IdentifierProvider.broke(
    value: T
): Nothing =
    throw IdentifiedReturn(ident, value)

public inline val IdentifierProvider.broke: Nothing
    get() = throw IdentifiedReturn(ident, null)

public inline fun prfWrapBlock(
    block: IdentifierProvider.() -> Unit
) {
    contract {
        callsInPlace(block, InvocationKind.AT_MOST_ONCE)
    }
    
    val identifier: IdentifierProvider = IdentifierProvider.Impl()
    
    try {
        identifier.block()
    } catch (e: IdentifiedReturn) {
        if (identifier.ident === e.ident) {
            return
        } else {
            throw e
        }
    }
}

public inline fun <R> runWrapBlock(
    clazz: Class<out R>,
    block: IdentifierProvider.() -> R
): R {
    contract {
        callsInPlace(block, InvocationKind.AT_MOST_ONCE)
    }
    
    val identifier: IdentifierProvider = IdentifierProvider.Impl()
    
    @Suppress("LiftReturnOrAssignment")
    try {
        return identifier.block()
    } catch (e: IdentifiedReturn) {
        if (identifier.ident === e.ident) {
            return clazz.cast(e.value)
        } else {
            throw e
        }
    }
}

public inline fun <reified R> runWrapBlock(
    block: IdentifierProvider.() -> R
): R {
    contract {
        callsInPlace(block, InvocationKind.AT_MOST_ONCE)
    }
    
    return runWrapBlock(R::class.java, block)
}