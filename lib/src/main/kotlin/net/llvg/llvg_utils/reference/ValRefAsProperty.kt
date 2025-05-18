package net.llvg.llvg_utils.reference

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * An implementation of [ReadOnlyProperty] that warps a [ValRef]
 *
 * @see ValRef
 * @see ReadOnlyProperty
 */
@JvmInline
@Suppress("OVERRIDE_BY_INLINE")
public value class ValRefAsProperty<out T>(
    public val ref: ValRef<T>
) : ReadOnlyProperty<Any?, T> {
    override inline fun getValue(
        thisRef: Any?,
        property: KProperty<*>
    ): T =
        ref.get()
}