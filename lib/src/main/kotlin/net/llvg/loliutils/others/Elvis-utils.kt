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

@file:JvmName("ElvisUtils")

package net.llvg.loliutils.others

import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import kotlin.internal.InlineOnly

@InlineOnly
public inline val Boolean.takeTrue: Boolean?
    @JvmSynthetic
    get() = takeTrue()

@InlineOnly
@JvmSynthetic
public inline fun Boolean.takeTrue(): Boolean? {
    contract {
        returns(null) implies !this@takeTrue
        returnsNotNull() implies this@takeTrue
    }
    
    return if (this) true else null
}

@InlineOnly
public inline val Boolean.takeFalse: Boolean?
    @JvmSynthetic
    get() = takeFalse()

@InlineOnly
@JvmSynthetic
public inline fun Boolean.takeFalse(): Boolean? {
    contract {
        returns(null) implies this@takeFalse
        returnsNotNull() implies !this@takeFalse
    }
    
    return if (this) null else false
}

@InlineOnly
public inline val Any?.invertElvis: Unit?
    @JvmSynthetic
    get() = invertElvis()

@InlineOnly
@JvmSynthetic
public inline fun Any?.invertElvis(): Unit? {
    contract {
        returns(null) implies (this@invertElvis !== null)
        returnsNotNull() implies (this@invertElvis === null)
    }
    
    return if (this === null) Unit else null
}

@InlineOnly
@JvmSynthetic
public inline fun <T> T.prf(
    action: T.() -> Unit
) {
    contract {
        callsInPlace(action, InvocationKind.EXACTLY_ONCE)
    }
    
    action()
}

@InlineOnly
@JvmSynthetic
public inline fun <T> T.act(
    action: (T) -> Unit
) {
    contract {
        callsInPlace(action, InvocationKind.EXACTLY_ONCE)
    }
    
    action(this)
}

@InlineOnly
@JvmSynthetic
public inline fun prf(
    action: () -> Unit
) {
    contract {
        callsInPlace(action, InvocationKind.EXACTLY_ONCE)
    }
    
    action()
}

@InlineOnly
@JvmSynthetic
@Suppress("UnusedReceiverParameter")
public inline fun Any?.exec(
    action: () -> Unit
) {
    contract {
        callsInPlace(action, InvocationKind.EXACTLY_ONCE)
    }
    
    action()
}

@InlineOnly
@JvmSynthetic
@Suppress("UnusedReceiverParameter")
public inline fun <R> Any?.eval(
    action: () -> R
): R {
    contract {
        callsInPlace(action, InvocationKind.EXACTLY_ONCE)
    }
    
    return action()
}