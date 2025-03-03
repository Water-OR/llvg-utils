package net.llvg.loliutils.exception

interface TryScopeContainer {
        val scope: TryScope
        
        fun close()
}