package kotlin.internal

import net.llvg.utilities.KotlinInternal

/**
 * Specifies that the corresponding member has the highest priority in overload resolution. Effectively this means that
 * an extension annotated with this annotation will win in overload resolution over a member with the same signature.
 */
@KotlinInternal
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.BINARY)
public annotation class HidesMembers