package net.llvg.loliutils.exception

@TryMark
interface TryScope {
        val <T : AutoCloseable> T.use: T
}