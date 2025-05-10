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

package net.llvg.loliutils.scope;

import java.util.Objects;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings ("unused")
public class IdentifiedReturn
  extends Throwable
{
    @NotNull
    public final Object ident;
    public final Object value;
    
    public IdentifiedReturn(
      @NotNull
      Object ident,
      Object value
    ) {
        Objects.requireNonNull(ident, "[ident] must not be null");
        
        this.ident = ident;
        this.value = value;
    }
    
    @SuppressWarnings ("unchecked")
    final public <T> T value() {
        return (T) value;
    }
    
    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
