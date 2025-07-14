package net.llvg.utilities

import kotlin.annotation.AnnotationRetention.*
import kotlin.annotation.AnnotationTarget.*

/**
 * Marks the kotlin internal annotations (currently)
 */
@RequiresOptIn(message = "Unsing kotlin internal api is unsafe")
@Retention(BINARY)
@Target(CLASS, PROPERTY, LOCAL_VARIABLE, VALUE_PARAMETER, CONSTRUCTOR, FUNCTION, PROPERTY_GETTER, PROPERTY_SETTER, TYPEALIAS)
public annotation class KotlinInternal