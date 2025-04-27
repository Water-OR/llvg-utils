/*
 * Copyright (C) 2025 Water-OR
 *
 * This file is part of LolI Utils
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */

package net.llvg.loliutils.function

@FunctionalInterface
@Suppress("UNUSED")
fun interface VoidPredicate {
    fun test(): Boolean
    
    infix fun and(
        o: VoidPredicate
    ): VoidPredicate {
        if (o === True) return this
        if (o === False) return False
        
        return VoidPredicate { test() && o.test() }
    }
    
    infix fun or(
        o: VoidPredicate
    ): VoidPredicate {
        if (o === True) return True
        if (o === False) return this
        
        return VoidPredicate { test() || o.test() }
    }
    
    fun negate(): VoidPredicate =
        VoidPredicate { !test() }
    
    private data object True : VoidPredicate {
        override fun test() = true
        override fun and(o: VoidPredicate) = o
        override fun or(o: VoidPredicate) = this
        override fun negate(): VoidPredicate = False
    }
    
    private data object False : VoidPredicate {
        override fun test(): Boolean = false
        override fun and(o: VoidPredicate) = this
        override fun or(o: VoidPredicate) = o
        override fun negate(): VoidPredicate = True
    }
    
    companion object {
        @JvmField
        val FALSE: VoidPredicate = False
        
        @JvmField
        val TRUE: VoidPredicate = True
    }
}