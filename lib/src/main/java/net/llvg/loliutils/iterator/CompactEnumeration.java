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

package net.llvg.loliutils.iterator;

import java.util.*;

@SuppressWarnings ("unused")
public class CompactEnumeration<T> implements Enumeration<T> {
        private final Enumeration<T>[] enums;
        private int index = 0;
        
        public CompactEnumeration(Enumeration<T>[] enums) {
                this.enums = enums;
        }
        
        @Override public boolean hasMoreElements() {
                while (index < enums.length) {
                        if (enums[index].hasMoreElements()) {
                                return true;
                        }
                        ++index;
                }
                return false;
        }
        
        @Override public T nextElement() {
                if (hasMoreElements()) {
                        return enums[index].nextElement();
                }
                
                throw new NoSuchElementException();
        }
}
