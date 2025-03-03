@file:JvmName("TypeException")

package net.llvg.loliutils.exception

fun <R> throwTyped(e: Throwable): R = throw e

fun <R> unknownType(type: Class<*>): R = throw UnknownTypeException("Type $type is unknown")

fun <R> Any.typeUnknown(): R = unknownType(javaClass)