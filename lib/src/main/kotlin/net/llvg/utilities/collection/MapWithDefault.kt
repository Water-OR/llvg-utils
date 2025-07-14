package net.llvg.utilities.collection

public class MapWithDefault<K, V>(
    private val delegatee: MutableMap<K, V>,
    private val defaultValue: (K) -> V,
) : MutableMap<K, V> by delegatee {
    public constructor(defaultValue: (K) -> V) : this(mutableMapOf<K, V>(), defaultValue)
    
    override fun get(key: K): V =
        delegatee.computeIfAbsent(key, defaultValue)
    
    public fun synchronizedGet(key: K): V =
        delegatee[key] ?: synchronized(this) { delegatee.computeIfAbsent(key, defaultValue) }
}