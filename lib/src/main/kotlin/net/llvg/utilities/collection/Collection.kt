@file:JvmName("CollectionUtil")

package net.llvg.utilities.collection

import java.util.Collections
import kotlin.internal.InlineOnly

@InlineOnly
public inline fun <K, V> MutableMap<K, V>.synchronizedGetOrPut(key: K, value: () -> V): V =
    this[key] ?: synchronized(this) { this[key] ?: value().let { putIfAbsent(key, it) ?: it } }

@InlineOnly
public inline val <T> Collection<T>.unmodifiable: Collection<T>
    get() = Collections.unmodifiableCollection(this)

@InlineOnly
public inline val <T> Set<T>.unmodifiable: Set<T>
    get() = Collections.unmodifiableSet(this)

@InlineOnly
public inline val <T> List<T>.unmodifiable: List<T>
    get() = Collections.unmodifiableList(this)

@InlineOnly
public inline val <K, V> Map<K, V>.unmodifiable: Map<K, V>
    get() = Collections.unmodifiableMap(this)

@InlineOnly
public inline val <T> Iterable<T>.unmodifiable: Iterable<T>
    get() = UnmodifiableIterable(this)

@InlineOnly
public inline val <T> Iterator<T>.unmodifiable: Iterator<T>
    get() = UnmodifiableIterator(this)