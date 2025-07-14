package net.llvg.utilities

import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import kotlin.internal.InlineOnly

@InlineOnly
public inline fun loop(action: () -> Unit): Nothing {
    while (true) action()
}

@InlineOnly
public inline fun Any?.isNull(): Boolean {
    contract {
        returns(true) implies (this@isNull === null)
        returns(false) implies (this@isNull !== null)
    }
    
    return this === null
}

@InlineOnly
public inline fun <R> Any?.onNull(action: () -> R): R? {
    contract {
        callsInPlace(action, InvocationKind.AT_MOST_ONCE)
    }
    
    return if (isNull()) action() else null
}

@InlineOnly
public inline fun Any?.notNull(): Boolean {
    contract {
        returns(true) implies (this@notNull !== null)
        returns(false) implies (this@notNull === null)
    }
    
    return !isNull()
}

@InlineOnly
public inline fun Any?.invNull(): Unit? {
    contract {
        returnsNotNull() implies (this@invNull === null)
        returns(null) implies (this@invNull !== null)
    }
    
    return if (isNull()) Unit else null
}

@InlineOnly
public inline fun <T : Any> T?.mapNull(action: () -> T): T {
    contract {
        callsInPlace(action, InvocationKind.AT_MOST_ONCE)
    }
    
    return if (isNull()) action() else this
}

@InlineOnly
@Suppress("UnusedReceiverParameter")
public inline fun <R> Any?.then(action: () -> R): R {
    contract {
        callsInPlace(action, InvocationKind.EXACTLY_ONCE)
    }
    
    return action()
}

@InlineOnly
public inline fun Boolean.takeT(): Boolean? {
    contract {
        returnsNotNull() implies this@takeT
        returns(null) implies !this@takeT
    }
    
    return if (this) true else null
}

@InlineOnly
public inline fun Boolean.takeF(): Boolean? {
    contract {
        returnsNotNull() implies !this@takeF
        returns(null) implies this@takeF
    }
    
    return if (this) null else false
}