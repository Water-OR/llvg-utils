/*
 * Copyright (C) 2025-2025 Water-OR
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

package net.llvg.loliutils.array;

import java.lang.reflect.Array;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/**
 * A utility class of array
 */
@SuppressWarnings ("unused")
public final class ArrayHelper {
    private ArrayHelper() {
        throw new IllegalStateException("");
    }
    
    /**
     * Creates a new array with the given {@link Class type} and {@code size}
     *
     * @param type The component type class of the returned array
     * @param size The size of the returned array
     * @param <T> The type of component type class
     *
     * @return A new array with the given {@link Class type} and {@code size}
     * @throws IllegalArgumentException   If the given {@link Class type} is {@link Void#TYPE}
     * @throws NegativeArraySizeException If the given {@code size} is negative
     * 
     * @see Array#newInstance(Class, int)
     */
    @SuppressWarnings ("unchecked")
    public static <T> T[] newArray(
      @NotNull
      Class<T> type,
      int size
    ) {
        Objects.requireNonNull(type, "type must not be null");
        
        return (T[]) Array.newInstance(type, size);
    }
}
