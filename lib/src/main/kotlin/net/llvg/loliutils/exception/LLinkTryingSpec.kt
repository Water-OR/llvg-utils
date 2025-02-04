package net.llvg.loliutils.exception

import net.llvg.loliutils.iterating.letEachReverse
import net.llvg.loliutils.iterating.link.LLink
import net.llvg.loliutils.iterating.link.LNormalLink
import java.lang.AutoCloseable

class LLinkTryingSpec : LTryingSpec {
        private val storage: LLink<AutoCloseable> = LNormalLink()
        
        override fun <C : AutoCloseable> includeResource(autoCloseable: C): C {
                storage.tail().insertPrev(autoCloseable)
                return autoCloseable
        }
        
        override fun close() {
                storage.letEachReverse(AutoCloseable::close)
                storage.clear()
        }
}