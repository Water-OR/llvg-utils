package net.llvg.loliutils.exception

class TryFailureScope<R>(result: TryResult<R>) {
        @PublishedApi
        internal var result: TryResult<R> = result
                private set
        
        @Suppress("UNUSED")
        fun fallback(value: R) {
                if (result is TryResult.Success) throw UnsupportedOperationException("Fallback has already been set!")
                result = TryResult.Success(value)
        }
}