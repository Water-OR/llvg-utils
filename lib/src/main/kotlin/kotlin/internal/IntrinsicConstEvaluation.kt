package kotlin.internal

import net.llvg.llvg_utils.KotlinInternal

/**
 * When applied to a function or property, enables a compiler optimization that evaluates that function or property
 * at compile-time and replaces calls to it with the computed result.
 *
 * @see KotlinInternal
 */
@KotlinInternal
@Target(AnnotationTarget.CONSTRUCTOR, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.BINARY)
@SinceKotlin("1.7")
public annotation class IntrinsicConstEvaluation