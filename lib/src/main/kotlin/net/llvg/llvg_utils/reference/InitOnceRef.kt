package net.llvg.llvg_utils.reference

/**
 * An implementation of [VarRef] that the [set] function can be called once at most once
 *
 * @see VarRef
 */
public class InitOnceRef<T> : VarRef<T> {
    @Volatile
    public var initialized: Boolean = false
        private set
    
    private var ref: ValRef<T>? = null
    
    override fun get(): T {
        return ref?.get() ?: throw IllegalStateException("Reference haven't been initialized yet")
    }
    
    @Synchronized
    override fun set(
        value: T
    ) {
        if (ref !== null) throw IllegalStateException("Reference has already been initialized")
        
        ref = value.boxed
    }
    
}