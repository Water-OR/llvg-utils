@file:JvmName("TypeUtils")

package net.llvg.llvg_utils.type

import kotlin.internal.InlineOnly

/**
 * Unchecked cast the receiver object to type [R]
 *
 * @receiver The object to attempt casting on
 * @param R The target type to cast to
 *
 * @return The receiver object being cast to type [R]
 */
@InlineOnly
@Suppress("UNCHECKED_CAST")
@Deprecated("", ReplaceWith("cast<R>()", "net.llvg.llvg_utils.type.cast"))
public inline fun <R> Any?.castTo(): R =
    this as R

/**
 * Unchecked cast the receiver object to type [R]
 *
 * @receiver The object to attempt casting on
 * @param R The target type to cast to
 *
 * @return The receiver object being cast to type [R]
 */
@InlineOnly
@Suppress("UNCHECKED_CAST")
@JvmName("castReceiver")
public inline fun <R> Any?.cast(): R =
    this as R

/**
 * Unchecked cast the [value] to type [R]
 *
 * @param value The object to attempt casting on
 * @param R The target type to cast to
 *
 * @return The [value] being cast to type [R]
 */
@InlineOnly
@Suppress("UNCHECKED_CAST")
public inline fun <R> cast(
    value: Any?
): R =
    value as R

/**
 * Unchecked cast the receiver object to non-null type
 *
 * @receiver The object to attempt casting on
 * @param T The non-null target type to cast to
 *
 * @return The receiver object being cast to non-null type
 */
@InlineOnly
@Suppress("UNCHECKED_CAST")
public inline val <T : Any> T?.asNotNull: T
    get() = this as T