@file:JvmName("UncheckedUtil")
@file:Suppress("UNCHECKED_CAST")

package net.llvg.utilities

import kotlin.internal.InlineOnly

@InlineOnly
@JvmName("castReceiver")
public inline fun <R> Any?.cast(): R =
    this as R

@InlineOnly
public inline fun <R> cast(value: Any?): R =
    value as R

@InlineOnly
public inline val <T : Any> T?.asNN: T
    get() = this as T