@file:JvmName("IdentifiedReturnUtils")

package net.llvg.llvg_utils.scope

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