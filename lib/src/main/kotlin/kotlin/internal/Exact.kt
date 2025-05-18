package kotlin.internal

import net.llvg.llvg_utils.KotlinInternal

/**
 * Specifies that the constraint built for the type during type inference should be an equality one.
 *
 * @see KotlinInternal
 */
@KotlinInternal
@Target(AnnotationTarget.TYPE)
@Retention(AnnotationRetention.BINARY)
public annotation class Exact