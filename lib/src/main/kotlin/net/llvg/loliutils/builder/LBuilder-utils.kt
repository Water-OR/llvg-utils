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

@file:JvmName("LBuilderUtils")

package net.llvg.loliutils.builder

import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import kotlin.internal.InlineOnly

@InlineOnly
public inline infix fun <R, B : LBuilder<R>> LBuilderProvider<R, B>.building(
    configure: B.() -> Unit
): R {
    contract {
        callsInPlace(configure, InvocationKind.EXACTLY_ONCE)
    }
    
    return builder().apply(configure).build()
}

@InlineOnly
public inline fun <P, R, B : LBuilder<R>> LBuilderProducer<P, R, B>.building(
    parameter: P,
    configure: B.() -> Unit
): R {
    contract {
        callsInPlace(configure, InvocationKind.EXACTLY_ONCE)
    }
    
    return builder(parameter).apply(configure).build()
}

@InlineOnly
public inline infix fun <R, B : LBuilder<R>> B.build(
    configure: B.() -> Unit
): R =
    apply(configure).build()