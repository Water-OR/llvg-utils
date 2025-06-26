@file:JvmName("ClassUtils")

package net.llvg.llvg_utils.type

import kotlin.contracts.contract
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
 * Check if the receiver [Class] is extended from class [T]
 *
 * @receiver The [Class] being checked
 * @param T The class to check against
 *
 * @return `true` if the receiver [Class] is extended from class [T], otherwise `false`
 *
 * @see asExtend
 */
@InlineOnly
public inline fun <@PureReifiable reified T> Class<*>.isExtend(): Boolean =
    jClass<T>().isAssignableFrom(this)

/**
 * Check if the receiver [Class] is extended from class [type]
 *
 * @receiver The [Class] being checked
 * @param type The class to check against
 *
 * @return `true` if the receiver [Class] is extended from class [type], otherwise `false`
 *
 * @see asExtend
 */
@InlineOnly
public inline fun <T> Class<*>.isExtend(
    type: Class<T>
): Boolean =
    type.isAssignableFrom(this)

/**
 * Casts the receiver [Class] to subclass of class [T] if possible, otherwise returns `null`
 *
 * @receiver The [Class] to attempt casting on
 * @param T The target class to cast to
 *
 * @return The receiver [Class] being cast to subclass of class [T] if possible, otherwise `null`
 *
 * @see isExtend
 */
@InlineOnly
public inline fun <@PureReifiable reified T> Class<*>.asExtend(): Class<out @NoInfer T>? =
    if (isExtend<T>()) asSubclass(jClass<T>()) else null

/**
 * Casts the receiver [Class] to subclass of class [type] if possible, otherwise returns `null`
 *
 * @receiver The [Class] to attempt casting on
 * @param type The target class to cast to
 *
 * @return The receiver [Class] being cast to subclass of class [type] if possible, otherwise `null`
 *
 * @see isExtend
 */
@InlineOnly
public inline fun <T> Class<*>.asExtend(
    type: Class<T>
): Class<out @NoInfer T>? =
    if (isExtend(type)) asSubclass(type) else null

/**
 * Casts the receiver [Class] to subclass of class [T]
 *
 * @receiver The [Class] to attempt casting on
 * @param T the target class to cast to
 *
 * @return The receiver [Class] being cast to subclass of class [T]
 * @throws ClassCastException If the receiver [Class] can not be cast to subclass of class [T]
 */
@InlineOnly
@Deprecated("", ReplaceWith("asSubclass(jClass<T>())", "net.llvg.llvg_utils.type.jClass"))
public inline fun <@PureReifiable reified T> Class<*>.toExtend(): Class<out @NoInfer T> =
    asSubclass(jClass<T>())

/**
 * Casts the receiver [Class] to subclass of class [type]
 *
 * @receiver The [Class] to attempt casting on
 * @param type the target class to cast to
 *
 * @return The receiver [Class] being cast to subclass of class [type]
 * @throws ClassCastException If the receiver [Class] can not be cast to subclass of class [type]
 */
@InlineOnly
@Deprecated("", ReplaceWith("asSubclass(type)"))
public inline fun <T> Class<*>.toExtend(
    type: Class<T>
): Class<out @NoInfer T> =
    asSubclass(type)

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
@Deprecated("", ReplaceWith("asExtend<T>()", "net.llvg.llvg_utils.type.asExtend"))
public inline fun <@PureReifiable reified T> Class<*>.tryExtend(): Class<out @NoInfer T>? =
    if (isExtend<T>()) asSubclass(T::class.java) else null

/**
 * Check if the receiver object is in class [T]
 *
 * @receiver The object being checked
 * @param T The type to check against
 *
 * @return `true` if the receiver object is in class [T], otherwise `false`
 *
 * @see asExtend
 */
@InlineOnly
public inline fun <@PureReifiable reified T> Any.isInType(): Boolean {
    contract {
        returns(true) implies (this@isInType is T)
    }
    
    return jClass<T>().isInstance(this)
}

/**
[ * Check if the receiver object is in class [type]
] *
 * @receiver The object being checked
 * @param T The type to check against
 *
 * @return `true` if the receiver object is in class [type], otherwise `false`
 *
 * @see asExtend
 */
@InlineOnly
public inline fun <T> Any.isInType(
    type: Class<T>
): Boolean {
    return type.isInstance(this)
}

/**
 * Casts the receiver object to instance of class [T] if possible, otherwise returns `null`
 *
 * @receiver The object to attempt casting on
 * @param T The target class to cast to
 *
 * @return The receiver object being cast to instance of class [T] if possible, otherwise `null`
 *
 * @see isExtend
 */
@InlineOnly
public inline fun <@PureReifiable reified T> Any.asTyped(): @NoInfer T? {
    contract {
        returnsNotNull() implies (this@asTyped is T)
    }
    
    return if (isInType<Int>()) jClass<T>().cast(this) else null
}

/**
 * Casts the receiver object to instance of class [type] if possible, otherwise returns `null`
 *
 * @receiver The object to attempt casting on
 * @param T The target class to cast to
 *
 * @return The receiver object being cast to instance of class [type] if possible, otherwise `null`
 *
 * @see isExtend
 */
@InlineOnly
public inline fun <T> Any.asTyped(
    type: Class<T>
): @NoInfer T? =
    if (isInType(type)) type.cast(this) else null

/**
 * Casts the receiver object to instance of class [T]
 *
 * @receiver The object to attempt casting on
 * @param T The target class to cast to
 *
 * @return The receiver object being cast to instance of class [T]
 *
 * @see isExtend
 */
@InlineOnly
public inline fun <@PureReifiable reified T> Any.toTyped(): @NoInfer T =
    jClass<T>().cast(this)

/**
 * Casts the receiver object to instance of class [type]
 *
 * @receiver The object to attempt casting on
 * @param T The target class to cast to
 *
 * @return The receiver object being cast to instance of class [type]
 *
 * @see isExtend
 */
@InlineOnly
public inline fun <T> Any.toTyped(
    type: Class<T>
): @NoInfer T =
    type.cast(this)