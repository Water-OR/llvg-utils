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

package net.llvg.loliutils.iterator

import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

@JvmInline
public value class CollectionExtender<T, out C : MutableCollection<T>>(
    public val collection: C
)

public inline infix fun <T, C : MutableCollection<T>> CollectionExtender<T, C>.extend(
    action: CollectionExtender<T, C>.() -> Unit
): C {
    contract {
        callsInPlace(action, InvocationKind.EXACTLY_ONCE)
    }
    
    action()
    return collection
}

public inline val <T, C : MutableCollection<T>> C.extender: CollectionExtender<T, C>
    get() = CollectionExtender(this)

public inline infix fun <T, C : MutableCollection<T>> C.extend(
    configure: CollectionExtender<T, C>.() -> Unit
): C {
    contract {
        callsInPlace(configure, InvocationKind.EXACTLY_ONCE)
    }
    
    return extender extend configure
}

context(extender: CollectionExtender<T, C>)
public inline operator fun <T, C : MutableCollection<T>> T.unaryPlus() {
    extender.collection += this
}

context(extender: CollectionExtender<T, C>)
public inline operator fun <T, C : MutableCollection<T>> T.unaryMinus() {
    extender.collection -= this
}

context(extender: CollectionExtender<T, C>)
public inline operator fun <T, C : MutableCollection<T>> Array<T>.unaryPlus() {
    extender.collection += this
}

context(extender: CollectionExtender<T, C>)
public inline operator fun <T, C : MutableCollection<T>> Array<T>.unaryMinus() {
    extender.collection -= this
}

context(extender: CollectionExtender<T, C>)
public inline operator fun <T, C : MutableCollection<T>> Iterable<T>.unaryPlus() {
    extender.collection += this
}

context(extender: CollectionExtender<T, C>)
public inline operator fun <T, C : MutableCollection<T>> Iterable<T>.unaryMinus() {
    extender.collection -= this
}

context(extender: CollectionExtender<T, C>)
public inline operator fun <T, C : MutableCollection<T>> Sequence<T>.unaryPlus() {
    extender.collection += this
}

context(extender: CollectionExtender<T, C>)
public inline operator fun <T, C : MutableCollection<T>> Sequence<T>.unaryMinus() {
    extender.collection -= this
}