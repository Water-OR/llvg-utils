package net.llvg.loliutils.exception

class LTryingResult<R>(val r: LResultSpec<R>, val e: Exception?) {
        var triggered: Boolean = e == null
                private set
        
        fun triggered() {
                triggered = true
        }
        
        @Suppress("unused")
        fun orElse(fallback: R): R? = if (!triggered) fallback else r.result
        
        @Suppress("unused")
        fun orNull(): R? = if (!triggered) null else r.result
        
        @Suppress("unused")
        fun orThrow(): R? = if (!triggered) throw RuntimeException(e) else r.result
}