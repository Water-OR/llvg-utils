package kotlin.internal

import net.llvg.llvg_utils.KotlinInternal

/**
 * Specifies that the corresponding type parameter is not used for unsafe operations such as casts or 'is' checks
 * That means it's completely safe to use generic types as argument for such parameter.
 *
 * @see KotlinInternal
 */
@KotlinInternal
@Target(AnnotationTarget.TYPE_PARAMETER)
@Retention(AnnotationRetention.BINARY)
public annotation class PureReifiable