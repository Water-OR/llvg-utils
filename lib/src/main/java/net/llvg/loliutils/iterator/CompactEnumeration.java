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

package net.llvg.loliutils.iterator;

import java.util.Enumeration;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/**
 * An {@link Enumeration} combines multiple {@link Enumeration}s
 *
 * @param <T> Type of the {@link Enumeration}s
 *
 * @see Enumeration
 */
@SuppressWarnings ("unused")
public final class CompactEnumeration<T>
  implements Enumeration<T>
{
    @NotNull
    private final Enumeration<T>[] enums;
    private int index = 0;
    
    /**
     * <p>
     * Constructs with the given {@code enums}
     * <br>
     * Note: the {@code enums} array should not be null but the components in is nullable
     * </p>
     *
     * @param enums The given enums to be combined
     */
    public CompactEnumeration(
      @NotNull
      Enumeration<T>[] enums
    ) {
        Objects.requireNonNull(enums, "enums must not be null");
        
        this.enums = enums;
        while (enums[index] == null) {
            ++index;
        }
    }
    
    /**
     * @return The next element of the first enum with elements remains
     * @throws NoSuchElementException If no enum has elements remains
     */
    @Override
    public T nextElement() {
        if (hasMoreElements()) {
            return enums[index].nextElement();
        }
        
        throw new NoSuchElementException();
    }
    
    /**
     * Returns if any enum has elements remains
     * 
     * @return {@code true} if enum has elements remains, otherwise {@code false}
     */
    @Override
    public boolean hasMoreElements() {
        while (index < enums.length) {
            if (enums[index].hasMoreElements()) {
                return true;
            }
            
            do {
                ++index;
                if (index >= enums.length) {
                    return false;
                }
            } while (enums[index] == null);
        }
        
        return false;
    }
}
