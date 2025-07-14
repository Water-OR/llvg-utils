package net.llvg.utilities.scope

public interface TryWithResourcesScope {
    public fun <C : AutoCloseable> use(resource: C): C
}