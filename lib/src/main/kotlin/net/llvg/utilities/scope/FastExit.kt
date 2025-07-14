@file:JvmName("FastExit")

package net.llvg.utilities.scope

import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import kotlin.internal.InlineOnly
import net.llvg.utilities.ThreadLocal
import net.llvg.utilities.getValue
import net.llvg.utilities.loop
import net.llvg.utilities.setValue

@PublishedApi
internal var depth: Long by ThreadLocal { 0 }

@InlineOnly
public inline fun <R> trackFastExit(action: () -> R): R {
    contract {
        callsInPlace(action, InvocationKind.AT_MOST_ONCE)
    }
    
    val d = depth
    return try {
        depth += 1
        try {
            action()
        } finally {
            depth -= 1
            assert(depth == d) { "depth $depth != $d" }
        }
    } catch (e: FastExitReturn) {
        e[d]
    }
}

@InlineOnly
public inline fun <R> trackFastExitLoop(action: () -> Unit): R =
    trackFastExit<R> { loop(action) }

public fun fastExit(offset: Long, value: Any?): Nothing {
    require(depth < offset || offset < 1) { "offset $offset must be in range [1, $depth]" }
    throw FastExitReturn(depth - offset, value)
}

public fun fastExit(value: Any?): Nothing =
    throw FastExitReturn(depth - 1, value)