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

@file:[JvmName("LScopeUtils") Suppress("UNUSED", "NOTHING_TO_INLINE")]

package net.llvg.loliutils.scope

inline operator fun <R> LScopeBreak.get(
    scope: LScope<R, *>
): R =
    if (scope.check(ident)) value() else throw this

inline operator fun LScopeBreak.get(
    scope: LScope<Unit, *>
) =
    if (scope.check(ident)) Unit else throw this

inline infix fun <R, C : LScopeContext<R>> LScope<R, C>.runLScope(
    action: C.() -> R
): R =
    try {
        context.action()
    } catch (e: LScopeBreak) {
        e[this]
    }

inline fun <R> runLScope(
    action: EmptyLScopeContext<R>.() -> R
): R = EmptyLScope<R>().run {
    try {
        context.action()
    } catch (e: LScopeBreak) {
        e[this]
    }
}

inline infix fun <T, R> T.letLScope(
    action: EmptyLScopeContext<R>.(T) -> R
): R = EmptyLScope<R>().run {
    try {
        context.action(this@letLScope)
    } catch (e: LScopeBreak) {
        e[this]
    }
}

inline infix fun <C : LScopeContext<Unit>> LScope<Unit, C>.prfLScope(
    action: C.() -> Unit
) =
    try {
        context.action()
    } catch (e: LScopeBreak) {
        e[this]
    }

inline fun prfLScope(
    action: EmptyLScopeContext<Unit>.() -> Unit
) = EmptyLScope<Unit>().run {
    try {
        context.action()
    } catch (e: LScopeBreak) {
        e[this]
    }
}

inline infix fun <T> T.actLScope(
    action: EmptyLScopeContext<Unit>.(T) -> Unit
) = EmptyLScope<Unit>().run {
    try {
        context.action(this@actLScope)
    } catch (e: LScopeBreak) {
        e[this]
    }
}

inline infix fun <R> LScopeContext<R>.broke(
    value: R
): Nothing =
    throw LScopeBreak(ident, value)

inline val LScopeContext<Unit>.broke: Nothing
    @JvmName("broke")
    get() = throw LScopeBreak(ident, Unit)