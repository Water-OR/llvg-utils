package kotlin.internal

import net.llvg.utilities.KotlinInternal

/**
 * Specifies that the corresponding type should be ignored during type inference.
 */
@KotlinInternal
@Target(AnnotationTarget.TYPE)
@Retention(AnnotationRetention.BINARY)
public annotation class NoInfer