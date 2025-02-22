@file:JvmName("DelegateUtils")

package net.llvg.loliutils.delegate

@Suppress("Unused")
fun <T> lateVal(): LateVal<T> {
        return LateVal()
}