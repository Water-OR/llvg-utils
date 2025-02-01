@file:JvmName("LExceptionUtils")

package net.llvg.loliutils.exception

import kotlin.reflect.KClass

inline fun <reified T> Any?.castTo() = this as T

inline fun <R> trying(
        spec: LTryingSpec = LLinkTryingSpec(),
        crossinline action: LTryingSpec.() -> R
): LTryingResult<R> {
        var result: R? = null
        var expcetion: Exception? = null
        try {
                result = action(spec)
        } catch (e: Exception) {
                expcetion = e
        } finally {
                spec.close()
        }
        return LTryingResult(LResultSpec(result), expcetion)
}

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