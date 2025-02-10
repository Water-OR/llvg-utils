@file:JvmName("LExceptionUtils")

package net.llvg.loliutils.exception

@Suppress("unused", "unchecked_cast")
fun <T, R> T.uncheckedCast() = this as R

@Suppress("unused", "unchecked_cast")
@get:JvmName("asNotNull")
inline val <T> T?.asNotNull: T get() = this as T

fun <R> throwTyped(e: Throwable): R = throw e

fun <R> unknownType(type: Class<*>): R = throw UnknownTypeException("Type $type is unknown")

fun <R> Any.typeUnknown(): R = unknownType(javaClass)