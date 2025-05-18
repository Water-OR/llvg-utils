@file:JvmName("ScopeUtils")

package net.llvg.llvg_utils.scope

import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import kotlin.internal.InlineOnly
import kotlin.internal.PureReifiable
import net.llvg.llvg_utils.others.prf

/**
 * Calls the [action] with [IdentifierProvider] as its receiver
 *
 * @param action The action to be called
 */
@InlineOnly
public inline fun prfIdentified(
    action: IdentifierProvider.() -> Unit
) {
    contract {
        callsInPlace(action, InvocationKind.AT_MOST_ONCE)
    }
    
    IdentifierProvider.Impl().prf {
        try {
            action()
        } catch (e: IdentifiedReturn) {
            e check ident
        }
    }
}

/**
 * Calls the [action] with [IdentifierProvider] as its receiver and returns its result
 *
 * @param type The return type class
 * @param action The action to be called
 */
@InlineOnly
public inline fun <R> runIdentified(
    type: Class<out R>,
    action: IdentifierProvider.() -> R
): R {
    contract {
        callsInPlace(action, InvocationKind.AT_MOST_ONCE)
    }
    
    IdentifierProvider.Impl().prf {
        try {
            return action()
        } catch (e: IdentifiedReturn) {
            e check ident
            return e.value(type)
        }
    }
}

/**
 * Calls the [action] with [IdentifierProvider] as its receiver and returns its result
 *
 * @param action The action to be called
 * @param R The return type
 */
@InlineOnly
public inline fun <@PureReifiable reified R> runIdentified(
    action: IdentifierProvider.() -> R
): R {
    contract {
        callsInPlace(action, InvocationKind.AT_MOST_ONCE)
    }
    
    return runIdentified(R::class.java, action)
}