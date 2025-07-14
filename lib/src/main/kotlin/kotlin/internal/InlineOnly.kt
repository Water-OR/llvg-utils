package kotlin.internal

import net.llvg.utilities.KotlinInternal

/**
 * Specifies that this function should not be called directly without inlining
 */
@KotlinInternal
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@Retention(AnnotationRetention.BINARY)
public annotation class InlineOnly