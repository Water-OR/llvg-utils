package net.llvg.llvg_utils.scope

import kotlin.internal.InlineOnly
import kotlin.internal.NoInfer

/**
 * Context of [tryWithResources], witch provides methods to include [AutoCloseable] into [dispatcher]
 *
 * @see tryWithResources
 * @see TryWithResourcesDispatcher
 */
public class TryWithResourcesContext(
    private val dispatcher: TryWithResourcesDispatcher
) {
    /**
     * Adds [resource] to [dispatcher]
     *
     * @param resource The [AutoCloseable] to be included
     * @param T The type of [resource]
     *
     * @return The [resource]
     *
     * @see TryWithResourcesDispatcher.include
     */
    public fun <T : AutoCloseable> include(
        resource: T
    ): @NoInfer T {
        dispatcher include resource
        return resource
    }
    
    /**
     * Adds the receiver [AutoCloseable] to [dispatcher]
     *
     * @return The receiver
     *
     * @see TryWithResourcesDispatcher.include
     */
    @InlineOnly
    public inline val <T : AutoCloseable> T.include: @NoInfer T
        get() = include(this)
    
    /**
     * Adds the receiver [AutoCloseable] to [dispatcher]
     *
     * @return The receiver
     *
     * @see TryWithResourcesDispatcher.include
     */
    @InlineOnly
    public inline operator fun <T : AutoCloseable> T.unaryPlus(): @NoInfer T =
        include(this)
}