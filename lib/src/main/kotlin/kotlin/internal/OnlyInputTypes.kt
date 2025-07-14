package kotlin.internal

import net.llvg.utilities.KotlinInternal

/**
 * The value of this type parameter should be mentioned in input types (argument types, receiver type or expected type).
 */
@KotlinInternal
@Target(AnnotationTarget.TYPE_PARAMETER)
@Retention(AnnotationRetention.BINARY)
public annotation class OnlyInputTypes