package net.llvg.loliutils.exception

sealed interface TryResult<R> {
        class Success<R> @PublishedApi internal constructor(val r: R) : TryResult<R>
        
        class Failure<R> @PublishedApi internal constructor(val e: Throwable) : TryResult<R> {
                @PublishedApi
                internal var executed: Boolean = false
                        private set
                
                @PublishedApi
                internal fun executed() {
                        executed = true
                }
        }
}