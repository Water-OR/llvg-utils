@file:JvmName("JavaClassUtil")

package net.llvg.utilities

import kotlin.internal.InlineOnly
import kotlin.internal.NoInfer
import kotlin.internal.PureReifiable

@InlineOnly
public inline fun <@PureReifiable reified T> jClass(): Class<T> =
    T::class.java

@InlineOnly
@Suppress("UNCHECKED_CAST")
public inline val <T> T.jClass: Class<out T>
    get() = (this as Object).`class` as Class<T>

@InlineOnly
public inline fun <T> Class<*>.isExtending(type: Class<out T>): Boolean =
    type.isAssignableFrom(this)

@InlineOnly
public inline fun <T> Class<*>.toExtending(type: Class<out T>): Class<out @NoInfer T> =
    asSubclass(type)

@InlineOnly
public inline fun <T> Class<*>.asExtending(type: Class<out T>): Class<out @NoInfer T>? =
    if (type.isAssignableFrom(this)) asSubclass(type) else null

@InlineOnly
public inline fun <T> Any.isInType(type: Class<out T>): Boolean =
    type.isInstance(this)

@InlineOnly
public inline fun <T> Any.toTyped(type: Class<out T>): @NoInfer T =
    type.cast(this)

@InlineOnly
public inline fun <T> Any.asTyped(type: Class<out T>): @NoInfer T? =
    if (type.isInstance(this)) type.cast(this) else null