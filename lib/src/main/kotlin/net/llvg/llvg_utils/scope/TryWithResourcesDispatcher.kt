package net.llvg.llvg_utils.scope

/**
 * Interface for managing resources that need to be closed
 *
 * This interface defines the contract for a dispatcher that handles [AutoCloseable] objects within a [tryWithResources] block
 *
 * Implementation should make sure that [AutoCloseable] objects are first-include-last-close
 *
 * @see tryWithResources
 * @see TryWithResourcesContext
 */
public interface TryWithResourcesDispatcher {
    /**
     * Includes [resource] which will be closed in the [close] function
     *
     * @param resource The [AutoCloseable] object to be included
     *
     * @see close
     * @see tryWithResources
     * @see TryWithResourcesContext
     */
    public infix fun include(resource: AutoCloseable)
    
    /**
     * Closes all the [AutoCloseable] objects witch are included
     *
     * @throws TryWithResourcesCloseFailedException If more than 1 resource throws exception while closing
     *
     * @see include
     * @see tryWithResources
     */
    @Throws(TryWithResourcesCloseFailedException::class)
    public fun close()
}