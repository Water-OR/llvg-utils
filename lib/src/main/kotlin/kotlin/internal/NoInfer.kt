package kotlin.internal

import net.llvg.llvg_utils.KotlinInternal

/**
 * Specifies that the corresponding type should be ignored during type inference.
 *
 * @see KotlinInternal
 */
@KotlinInternal
@Target(AnnotationTarget.TYPE)
@Retention(AnnotationRetention.BINARY)
public annotation class NoInfer