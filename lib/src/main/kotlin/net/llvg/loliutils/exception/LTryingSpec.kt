package net.llvg.loliutils.exception

import java.lang.AutoCloseable

interface LTryingSpec {
        fun <C : AutoCloseable> use(autoCloseable: C): C
        
        val AutoCloseable.using get() = use(this)
        
        fun close()
}