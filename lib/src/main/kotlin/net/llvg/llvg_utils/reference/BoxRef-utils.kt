@file:JvmName("BoxRefUtils")

package net.llvg.llvg_utils.reference

import kotlin.internal.InlineOnly

/**
 * @return A [BoxRef] that warps the receiver object
 */
@InlineOnly
public inline val <T> T.boxed: BoxRef<T>
    get() = BoxRef(this)