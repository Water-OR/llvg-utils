@file:JvmName("ElvisUtils")

package net.llvg.llvg_utils.others

import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import kotlin.internal.InlineOnly

/**
 * @return `null` if the receiver is false, otherwise the receiver
 */
@InlineOnly
public inline fun Boolean.takeTrue(): Boolean? {
    contract {
        returns(null) implies !this@takeTrue
        returnsNotNull() implies this@takeTrue
    }
    
    return if (this) true else null
}

/**
 * An alias of the function having the same name
 *
 * @return `null` if the receiver is false, otherwise the receiver
 */
@InlineOnly
public inline val Boolean.takeTrue: Boolean?
    get() = takeTrue()

/**
 * @return `null` if the receiver is true, otherwise the receiver
 */
@InlineOnly
public inline fun Boolean.takeFalse(): Boolean? {
    contract {
        returns(null) implies this@takeFalse
        returnsNotNull() implies !this@takeFalse
    }
    
    return if (this) null else false
}

/**
 * An alias of the function having the same name
 *
 * @return `null` if the receiver is true, otherwise the receiver
 */
@InlineOnly
public inline val Boolean.takeFalse: Boolean?
    get() = takeFalse()

/**
 * @return `null` if the receiver is not `null`, otherwise [Unit]
 */
@InlineOnly
public inline fun Any?.invertElvis(): Unit? {
    contract {
        returns(null) implies (this@invertElvis !== null)
        returnsNotNull() implies (this@invertElvis === null)
    }
    
    return if (this === null) Unit else null
}

/**
 * An alias of the function having the same name
 *
 * @return `null` if the receiver is not `null`, otherwise [Unit]
 */
@InlineOnly
public inline val Any?.invertElvis: Unit?
    get() = invertElvis()

/**
 * Calls the [action]
 *
 * Similar to [run] but no return
 *
 * @param action The action to be called
 *
 * @see run
 */
@InlineOnly
public inline fun prf(
    action: () -> Unit
) {
    contract {
        callsInPlace(action, InvocationKind.EXACTLY_ONCE)
    }
    
    action()
}

/**
 * Calls the [action] with the receiver value as its receiver
 *
 * Similar to [Any.run] but no return
 *
 * @param action The action to be called
 *
 * @see Any.run
 */
@InlineOnly
public inline fun <T> T.prf(
    action: T.() -> Unit
) {
    contract {
        callsInPlace(action, InvocationKind.EXACTLY_ONCE)
    }
    
    action()
}

/**
 * Calls the [action] with the receiver value as its argument
 *
 * Similar to [Any.let] but no return
 *
 * @param action The action to be called
 *
 * @see Any.let
 */
@InlineOnly
public inline fun <T> T.act(
    action: (T) -> Unit
) {
    contract {
        callsInPlace(action, InvocationKind.EXACTLY_ONCE)
    }
    
    action(this)
}