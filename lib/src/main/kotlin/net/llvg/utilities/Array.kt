@file:JvmName("ArrayUtil")

package net.llvg.utilities

import java.util.Arrays
import kotlin.internal.InlineOnly
import kotlin.internal.PureReifiable

public typealias ArrayReflect = java.lang.reflect.Array

@InlineOnly
@Suppress("UNCHECKED_CAST")
public inline fun <@PureReifiable reified T> newArray(size: Int): Array<T> =
    ArrayReflect.newInstance(jClass<T>(), size) as Array<T>

@InlineOnly
@Suppress("ReplaceJavaStaticMethodWithKotlinAnalog")
public inline val <T> Array<T>.asList: MutableList<T>
    get() = Arrays.asList(*this)