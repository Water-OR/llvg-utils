package kotlin.internal

import net.llvg.utilities.KotlinInternal

/**
 * Specifies that a corresponding member has the lowest priority in overload resolution.
 */
@KotlinInternal
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY, AnnotationTarget.CONSTRUCTOR)
@Retention(AnnotationRetention.BINARY)
public annotation class LowPriorityInOverloadResolution