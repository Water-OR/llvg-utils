/*
 * Copyright (C) 2025-2025 Water-OR
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

package net.llvg.loliutils.scope.try_scope

import net.llvg.loliutils.scope.AbstractLScopeContext
import net.llvg.loliutils.scope.LScopeContext

public sealed interface TryScopeContext<in R> :
  LScopeContext<R> {
    public infix fun <T : AutoCloseable> resource(resource: T): T
    
    public val <T : AutoCloseable> T.use: T
    
    public class Impl<in R>(
        private val owner: TryScope<R>,
        ident: Any
    ) :
      AbstractLScopeContext<R>(ident),
      TryScopeContext<R> {
        override fun <T : AutoCloseable> resource(resource: T): T {
            owner resource resource
            return resource
        }
        
        override val <T : AutoCloseable> T.use: T
            get() {
                owner resource this
                return this
            }
    }
}