/*
 * Copyright (C) 2025 Water-OR
 *
 * This file is part of llvg-utils
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

/**
 * A {@link Throwable} witch carries an ident object and a value object
 *
 * @see Throwable
 */
@SuppressWarnings ("unused")
public final class IdentifiedReturn
  extends Throwable
{
    @NotNull
    public final Object ident;
    public final Object value;
    
    /**
     * Constructs with a given {@code ident} and {@code value}
     *
     * @param ident The given ident witch can not be null
     * @param value The given value witch is nullable
     */
    public IdentifiedReturn(
      @NotNull
      Object ident,
      Object value
    ) {
        super(null, null, false, false);
        Objects.requireNonNull(ident, "[ident] must not be null");
        
        this.ident = ident;
        this.value = value;
    }
    
    /**
     * Returns the value cast into the given {@link Class type}
     *
     * @param type The class of the returning type
     * @param <T> The returning type
     *
     * @return The value in type {@link T}
     *
     * @throws ClassCastException If the value can not be cast into the given {@link Class type}
     */
    public <T> T value(Class<T> type) {
        return type.cast(value);
    }
    
    /**
     * Disable the {@link Throwable#fillInStackTrace() fillInStackTrace} action to make it efficiency
     *
     * @return The instance itself
     */
    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
