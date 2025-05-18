package net.llvg.llvg_utils.scope

import net.llvg.llvg_utils.array.asList
import net.llvg.llvg_utils.others.act

/**
 * An implementation of [TryWithResourcesDispatcher] that uses a [list] to store [AutoCloseable] objects
 *
 * @see TryWithResourcesDispatcher
 */
public class TryWithResourcesDispatcherListImpl(
    private val list: MutableList<AutoCloseable>,
    private val logger: (Int, AutoCloseable, Throwable) -> Unit
) : TryWithResourcesDispatcher {
    public constructor(
        list: MutableList<AutoCloseable>
    ) : this(
        list,
        { id, it, e -> RuntimeException("Failed to close #$id entry, its class is ${it.javaClass}", e).printStackTrace() }
    )
    
    @Volatile
    private var closed: Boolean = false
    
    @Synchronized
    override fun include(
        resource: AutoCloseable
    ) {
        if (closed) throw UnsupportedOperationException("dispatcher already closed")
        
        list += resource
    }
    
    @Synchronized
    @Throws(TryWithResourcesCloseFailedException::class)
    override fun close() {
        if (closed) return
        closed = true
        
        list.toTypedArray().asList
          .run { listIterator(size) }
          .run {
              buildList {
                  while (hasPrevious()) {
                      val id = previousIndex()
                      val i = previous()
                      
                      try {
                          i.close()
                      } catch (e: Throwable) {
                          logger(id, i, e)
                          Triple(id, i, e).act(::add)
                      }
                  }
              }
          }
          .run {
              if (isNotEmpty()) {
                  throw TryWithResourcesCloseFailedException(this)
              }
          }
    }
}