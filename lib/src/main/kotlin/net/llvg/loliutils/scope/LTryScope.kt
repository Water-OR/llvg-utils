@file:JvmName("LTryScope")

package net.llvg.loliutils.scope

import net.llvg.loliutils.exception.*
import java.lang.AutoCloseable
import java.util.*
import kotlin.Boolean
import kotlin.OptIn
import kotlin.PublishedApi
import kotlin.Suppress
import kotlin.Throwable
import kotlin.Unit
import kotlin.contracts.*

interface TryScope {
        fun <T : AutoCloseable> T.use(): T
}

interface TryScopeManager {
        fun scope(): TryScope
        
        fun close()
}

@PublishedApi
internal class TryScopeManagerImpl : TryScopeManager, TryScope {
        private val autoCloseableQueue: Deque<AutoCloseable> = LinkedList()
        
        override fun <T : AutoCloseable> T.use(): T {
                autoCloseableQueue.offerFirst(this@use)
                return this
        }
        
        override fun scope(): TryScope = this
        
        override fun close() {
                autoCloseableQueue.forEach(AutoCloseable::close)
                autoCloseableQueue.clear()
        }
        
}

@PublishedApi
internal class FailureScopeImpl<T>(
        failure: Failure<T>
) : FailureScope<T> {
        init {
                failure.executed()
        }
        
        override var result: TryResult<T> = failure
                private set
        
        override fun result(v: T) {
                result = Success(v)
        }
}

@Suppress("unused")
@OptIn(ExperimentalContracts::class)
inline fun tryAct(
        manager: TryScopeManager = TryScopeManagerImpl(),
        crossinline action: TryScope.() -> Unit
): TryResult<Unit> {
        contract { callsInPlace(action, InvocationKind.EXACTLY_ONCE) }
        
        return try {
                TryResult.Success(manager.scope().action())
        } catch (throwable: Throwable) {
                TryResult.Failure(throwable)
        } finally {
                manager.close()
        }
}

@Suppress("unused")
@OptIn(ExperimentalContracts::class)
inline fun <R> tryRun(
        manager: TryScopeManager = TryScopeManagerImpl(),
        crossinline action: TryScope.() -> R
): TryResult<R> {
        contract { callsInPlace(action, InvocationKind.EXACTLY_ONCE) }
        
        return try {
                TryResult.Success(manager.scope().action())
        } catch (throwable: Throwable) {
                TryResult.Failure(throwable)
        } finally {
                manager.close()
        }
}

sealed interface TryResult<T> {
        class Success<T> @PublishedApi internal constructor(val v: T) : TryResult<T>
        
        class Failure<T> @PublishedApi internal constructor(val e: Throwable) : TryResult<T> {
                @PublishedApi
                internal var executed: Boolean = false
                        private set
                
                internal fun executed() {
                        executed = true
                }
        }
}

private typealias Success<T> = TryResult.Success<T>
private typealias Failure<T> = TryResult.Failure<T>

interface FailureScope<T> {
        val result: TryResult<T>
        
        fun result(v: T)
}

@Suppress("unused")
@OptIn(ExperimentalContracts::class)
inline fun <R, reified E : Throwable> TryResult<R>.onExcept(crossinline action: FailureScope<R>.(E) -> Unit): TryResult<R> {
        contract { callsInPlace(action, InvocationKind.AT_MOST_ONCE) }
        if (this is Failure && !executed && e is E) {
                val scope = FailureScopeImpl(this)
                scope.action(e)
                return scope.result
        }
        
        return this
}

@Suppress("unused")
fun <R> TryResult<R>.orElse(fallback: R): R =
        if (this is Success) v else fallback

@Suppress("unused")
@get:JvmName("orNull")
inline val <R> TryResult<R>.orNull: R?
        get() = if (this is Success) v else null

@Suppress("unused")
@get:JvmName("orThrow")
inline val <R> TryResult<R>.orThrow: R
        get() = if (this is Success) v else if (this is Failure) throwTyped(e) else typeUnknown()

@Suppress("unused")
inline fun <R> TryResult<R>.orRun(crossinline action: (Failure<R>) -> R): R =
        if (this is Success) v else if (this is Failure) action(this) else typeUnknown()