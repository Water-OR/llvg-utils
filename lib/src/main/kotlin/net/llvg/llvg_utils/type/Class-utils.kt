@file:JvmName("ClassUtils")

package net.llvg.llvg_utils.type

import kotlin.internal.InlineOnly
import kotlin.internal.NoInfer
import kotlin.internal.PureReifiable

/**
 * @param T The type provided the java class
 *
 * @return The java [Class] object of type [T]
 */
@InlineOnly
public inline fun <@PureReifiable reified T> jClass(): Class<T> =
    T::class.java

/**
 * @receiver The object provided it's class
 *
 * @return The java [Class] object of the receiver object
 */
@InlineOnly
public inline val <T : Any> T.jClass: Class<out T>
    get() = cast(cast<Object>().`class`)

/**
 * Check if the receiver [Class] is extended from type [T]
 *
 * @receiver The [Class] being checked
 * @param T The type to check against
 *
 * @return `true` if the receiver [Class] is extended from type [T], otherwise `false`
 *
 * @see asExtend
 */
@InlineOnly
public inline fun <@PureReifiable reified T> Class<*>.isExtend(): Boolean =
    T::class.java.isAssignableFrom(this)

/**
 * Casts the receiver [Class] to subclass of type [T] if possible, otherwise returns `null`
 *
 * @receiver The [Class] to attempt casting on
 * @param T The target type to cast to
 *
 * @return The receiver [Class] being cast to subclass of type [T] if possible, otherwise `null`
 *
 * @see isExtend
 */
@InlineOnly
public inline fun <@PureReifiable reified T> Class<*>.asExtend(): Class<out @NoInfer T>? =
    if (isExtend<T>()) asSubclass(T::class.java) else null

/**
 * Casts the receiver [Class] to subclass of type [T]
 *
 * @receiver The [Class] to attempt casting on
 * @param T the target type to cast to
 *
 * @return The receiver [Class] being cast to subclass of type [T]
 * @throws ClassCastException If the receiver [Class] can not be cast to subclass of type [T]
 */
@InlineOnly
public inline fun <@PureReifiable reified T> Class<*>.toExtend(): Class<out @NoInfer T> =
    asSubclass(T::class.java)

/**
 * Casts the receiver [Class] to subclass of type [T] if possible, otherwise returns `null`
 *
 * @receiver The [Class] to attempt casting on
 * @param T The target type to cast to
 *
 * @return The receiver [Class] being cast to subclass of type [T] if possible, otherwise `null`
 *
 * @see isExtend
 */
@InlineOnly
@Deprecated("", ReplaceWith("asExtend<T>()", "net.llvg.llvg_utils.asExtend"))
public inline fun <@PureReifiable reified T> Class<*>.tryExtend(): Class<out @NoInfer T>? =
    if (isExtend<T>()) asSubclass(T::class.java) else null