package net.llvg.utilities

import kotlin.internal.InlineOnly

@InlineOnly
public inline fun loop(action: () -> Unit): Nothing {
    while (true) action()
}