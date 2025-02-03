package net.llvg.loliutils.exception

import java.lang.AutoCloseable

interface LTryingSpec {
        fun <C : AutoCloseable> includeResource(autoCloseable: C): C
        
        @Suppress("unused")
        fun <C : AutoCloseable> C.using() = includeResource(this)
        
        fun close()
}