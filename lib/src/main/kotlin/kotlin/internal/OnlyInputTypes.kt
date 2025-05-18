package kotlin.internal

import net.llvg.llvg_utils.KotlinInternal

/**
 * The value of this type parameter should be mentioned in input types (argument types, receiver type or expected type).
 *
 * @see KotlinInternal
 */
@KotlinInternal
@Target(AnnotationTarget.TYPE_PARAMETER)
@Retention(AnnotationRetention.BINARY)
public annotation class OnlyInputTypes