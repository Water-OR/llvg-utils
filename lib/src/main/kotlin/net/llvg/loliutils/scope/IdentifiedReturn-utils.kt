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

@file:JvmName("IdentifiedReturnUtils")

package net.llvg.loliutils.scope

import kotlin.internal.InlineOnly

/**
 * Checks if [IdentifiedReturn.ident] of the receiver is referentially equals to [ident]
 *
 * If they are not equals, propagate the receiver
 *
 * @receiver The [IdentifiedReturn] being checked. Will be propagated if the check failed
 * @param ident The object to compare against the [IdentifiedReturn.ident] property of the receiver
 *
 * @throws IdentifiedReturn If [IdentifiedReturn.ident] of the receiver is not referentially equals to [ident]
 */
@InlineOnly
public inline infix fun IdentifiedReturn.check(
    ident: Any?
) {
    if (this.ident !== ident) throw this
}