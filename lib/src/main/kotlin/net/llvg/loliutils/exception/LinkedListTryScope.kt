package net.llvg.loliutils.exception

import java.util.Deque
import java.util.LinkedList

class LinkedListTryScope : TryScope, TryScopeContainer {
        private val storage: Deque<AutoCloseable> = LinkedList()
        
        override val <T : AutoCloseable> T.use: T get() = apply(storage::offerFirst)
        
        override val scope: TryScope get() = this
        
        override fun close() = storage.forEach(AutoCloseable::close)
}