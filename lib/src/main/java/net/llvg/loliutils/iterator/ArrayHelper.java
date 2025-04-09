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

import net.llvg.loliutils.exception.TypeCast;

import java.lang.reflect.Array;

public final class ArrayHelper {
        private ArrayHelper() { }
        
        public static <T> T[] array(Class<? extends T> type, int size) {
                return TypeCast.cast(Array.newInstance(type, size));
        }
        
        public static void checkRangeTill(int size, int till) {
                if (till < 0) {
                        throw new IllegalArgumentException("till(" + till + ") < 0");
                }
                if (till > size) {
                        throw new IllegalArgumentException("till(" + till + ") > size(" + size + ")");
                }
        }
        
        public static void checkRangeFromTill(int size, int from, int till) {
                if (from < 0) {
                        throw new IllegalArgumentException("from(" + from + ") < 0");
                }
                if (till < from) {
                        throw new IllegalArgumentException("till(" + till + ") < from(" + from + ")");
                }
                if (till > size) {
                        throw new IllegalArgumentException("till(" + till + ") > size(" + size + ")");
                }
        }
}
