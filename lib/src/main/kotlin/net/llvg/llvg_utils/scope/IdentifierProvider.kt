package net.llvg.llvg_utils.scope

/**
 * A marker interface that serves to identify and provide context for a specific scope
 *
 * The [ident] property acts as a unique key for a scope and can be used to
 * associate and retrieve contextual information relevant to that scope
 *
 * @see IdentifiedReturn.check
 */
public interface IdentifierProvider {
    /**
     * The unique identifier
     */
    public val ident: Any
    
    /**
     * A simple default implementation of [IdentifierProvider]
     */
    public class Impl() : IdentifierProvider {
        override val ident: Any = Any()
    }
}