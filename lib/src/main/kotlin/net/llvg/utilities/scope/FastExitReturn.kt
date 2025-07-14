package net.llvg.utilities.scope

@ConsistentCopyVisibility
public data class FastExitReturn
@PublishedApi
internal constructor(
    private val depth: Long,
    private val value: Any?
) : Throwable() {
    override fun fillInStackTrace(): Throwable? = this
    
    @PublishedApi
    @Suppress("UNCHECKED_CAST")
    internal operator fun <R> get(d: Long): R {
        if (d < depth) throw IllegalStateException("Given depth is lower than except depth")
        if (d > depth) throw this
        return value as R
    }
}