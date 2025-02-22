package net.llvg.loliutils.delegate

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class LateVal<T> : ReadWriteProperty<Any?, T> {
        private var wrapper: Wrapper<T>? = null
        
        override fun getValue(thisRef: Any?, property: KProperty<*>): T {
                return wrapper?.value ?: throw IllegalStateException("Field hasn't been initialized yet!")
        }
        
        override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
                if (wrapper !== null) throw IllegalStateException("Field has already been initialized!")
                this.wrapper = Wrapper(value)
        }
        
        private class Wrapper<T>(@JvmField val value: T)
}