@file:JvmName("TryUtils")

package net.llvg.loliutils.exception

@Suppress("UNUSED")
inline fun <R> tryRun(
        container: TryScopeContainer = LinkedListTryScope(),
        action: TryScope.() -> R
): TryResult<R> = try {
        TryResult.Success(container.scope.action())
} catch (e: Throwable) {
        TryResult.Failure(e)
} finally {
        container.close()
}

@Suppress("UNUSED")
inline fun tryAct(
        container: TryScopeContainer = LinkedListTryScope(),
        action: TryScope.() -> Unit
): TryResult<Unit> = try {
        TryResult.Success(container.scope.action())
} catch (e: Throwable) {
        TryResult.Failure(e)
} finally {
        container.close()
}

@Suppress("UNUSED")
inline val <R> TryResult<R>.isSuccess: Boolean get() = this is TryResult.Success

@Suppress("UNUSED")
inline val <R> TryResult<R>.isFailure: Boolean get() = this is TryResult.Failure

@Suppress("UNUSED")
inline fun <R, reified E : Throwable> TryResult<R>.onExcept(
        action: TryFailureScope<R>.(E) -> Unit
): TryResult<R> {
        if (this is TryResult.Failure && !executed && e is E) {
                executed()
                val scope = TryFailureScope(this)
                scope.action(e)
                return scope.result
        }
        
        return this
}

@Suppress("UNUSED")
fun <R> TryResult<R>.orElse(fallback: R): R =
if (this is TryResult.Success) r else fallback

@Suppress("UNUSED")
fun <R> TryResult<R>.orNull(): R? =
if (this is TryResult.Success) r else null

@Suppress("UNUSED")
fun <R> TryResult<R>.orThrow(): R =
if (this is TryResult.Success) r else if (this is TryResult.Failure) throwTyped(e) else typeUnknown()