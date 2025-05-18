package kotlin.internal

import net.llvg.llvg_utils.KotlinInternal

/**
 * Specifies that a corresponding member has the lowest priority in overload resolution.
 *
 * @see KotlinInternal
 */
@KotlinInternal
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY, AnnotationTarget.CONSTRUCTOR)
@Retention(AnnotationRetention.BINARY)
public annotation class LowPriorityInOverloadResolution