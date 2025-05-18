package kotlin.internal

import net.llvg.llvg_utils.KotlinInternal

/**
 * Specifies that the corresponding built-in method exists depending on platform.
 * Current implementation for JVM looks whether method with same JVM descriptor exists in the module JDK.
 * For example MutableMap.remove(K, V) available only if corresponding
 * method 'java/util/Map.remove(Ljava/lang/Object;Ljava/lang/Object;)Z' is defined in JDK (i.e. for major versions >= 8)
 *
 * @see KotlinInternal
 */
@KotlinInternal
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.BINARY)
public annotation class PlatformDependent