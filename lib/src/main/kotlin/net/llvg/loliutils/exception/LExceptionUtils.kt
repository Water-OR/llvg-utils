@file:JvmName("LExceptionUtils")

package net.llvg.loliutils.exception

import kotlin.reflect.KClass

@Suppress("unused")
inline fun <reified T> Any?.castTo() = this as T

@Suppress("unused")
inline fun <R> trying(
        spec: LTryingSpec = LLinkTryingSpec(),
        crossinline action: LTryingSpec.() -> R
): LTryingResult<R> {
        var result: R? = null
        var exception: Exception? = null
        try {
                result = action(spec)
        } catch (e: Exception) {
                exception = e
        } finally {
                spec.close()
        }
        return LTryingResult(LResultSpec(result), exception)
}

@Suppress("unused", "unused_parameter")
inline fun <R, reified E: Throwable> LTryingResult<R>.catching(
        type: KClass<E>,
        action: LResultSpec<R>.(E) -> Unit
): LTryingResult<R> = catching(action)

inline fun <R, reified E: Throwable> LTryingResult<R>.catching(
        action: LResultSpec<R>.(E) -> Unit
): LTryingResult<R> {
        if (!triggered && e as? E != null) {
                action(r, e)
                triggered()
        }
        return this
}