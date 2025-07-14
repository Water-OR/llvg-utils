package net.llvg.utilities.collection

public class UnmodifiableIterator<out T>(private val delegatee: Iterator<T>) : Iterator<T> by delegatee