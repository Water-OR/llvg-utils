@file:JvmName("IteratorUtils")

package net.llvg.llvg_utils.iterator

import kotlin.internal.InlineOnly

/**
 * @return The [EmptyIterator] safely cast to [Iterator] with type argument [T]
 */
@InlineOnly
public inline fun <T> emptyIterator(): Iterator<T> =
    EmptyIterator

/**
 * @return The [EmptyIterator] safely cast to [MutableIterator] with type argument [T]
 */
@InlineOnly
public inline fun <T> emptyMutableIterator(): MutableIterator<T> =
    EmptyIterator

/**
 * @return The [EmptyIterator] safely cast to [ListIterator] with type argument [T]
 */
@InlineOnly
public inline fun <T> emptyListIterator(): ListIterator<T> =
    EmptyIterator

/**
 * @return The [EmptyIterable] safely cast to [Iterable] with type argument [T]
 */
@InlineOnly
public inline fun <T> emptyIterable(): Iterable<T> =
    EmptyIterable

/**
 * @return The [EmptyIterable] safely cast to [MutableIterable] with type argument [T]
 */
@InlineOnly
public inline fun <T> emptyMutableIterable(): MutableIterable<T> =
    EmptyIterable