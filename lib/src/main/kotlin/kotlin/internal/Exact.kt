package kotlin.internal

import net.llvg.utilities.KotlinInternal

/**
 * Specifies that the constraint built for the type during type inference should be an equality one.
 */
@KotlinInternal
@Target(AnnotationTarget.TYPE)
@Retention(AnnotationRetention.BINARY)
public annotation class Exact