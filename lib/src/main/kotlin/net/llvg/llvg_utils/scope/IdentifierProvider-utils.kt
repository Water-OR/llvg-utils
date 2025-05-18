@file:JvmName("IdentifierProviderUtils")

package net.llvg.llvg_utils.scope

import kotlin.internal.InlineOnly

/**
 * @receiver The [IdentifierProvider] provides the ident carried by the throwing exception
 * @param value The value carried by the throwing exception
 *
 * @throws IdentifiedReturn Always with [IdentifierProvider.ident] of the receiver and [value]
 */
@InlineOnly
public inline infix fun IdentifierProvider.broke(
    value: Any?
): Nothing =
    throw IdentifiedReturn(ident, value)

/**
 * @receiver The [IdentifierProvider] provides the ident carried by the throwing exception
 *
 * @throws IdentifiedReturn Always with [IdentifierProvider.ident] of the receiver and no value
 */
@InlineOnly
public inline fun IdentifierProvider.broke(): Nothing =
    throw IdentifiedReturn(ident, null)