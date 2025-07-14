@file:JvmName("ExceptionUtil")

package net.llvg.utilities

import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import kotlin.internal.InlineOnly

@InlineOnly
public inline fun <R> noExcept(onExcept: (Throwable) -> R, action: () -> R): R {
    contract {
        callsInPlace(onExcept, InvocationKind.AT_MOST_ONCE)
        callsInPlace(action, InvocationKind.AT_MOST_ONCE)
    }
    
    return try {
        action()
    } catch (e: Throwable) {
        onExcept(e)
    }
}

@InlineOnly
public inline fun noExcept(onExcept: (Throwable) -> Unit = {}, action: () -> Unit) {
    contract {
        callsInPlace(onExcept, InvocationKind.AT_MOST_ONCE)
        callsInPlace(action, InvocationKind.AT_MOST_ONCE)
    }
    
    try {
        action()
    } catch (e: Throwable) {
        onExcept(e)
    }
}