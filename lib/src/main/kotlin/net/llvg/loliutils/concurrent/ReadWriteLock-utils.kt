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

@file:JvmName("ReadWriteLockUtils")

package net.llvg.loliutils.concurrent

import java.util.concurrent.locks.ReadWriteLock
import kotlin.concurrent.withLock
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

public inline fun <R> ReadWriteLock.withReadLock(
    action: () -> R
): R {
    contract {
        callsInPlace(action, InvocationKind.EXACTLY_ONCE)
    }
    
    return readLock().withLock(action)
}

public inline fun <R> ReadWriteLock.withWriteLock(
    action: () -> R
): R {
    contract {
        callsInPlace(action, InvocationKind.EXACTLY_ONCE)
    }
    
    return writeLock().withLock(action)
}