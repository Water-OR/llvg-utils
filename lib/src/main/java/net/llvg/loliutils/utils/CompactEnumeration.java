package net.llvg.loliutils.utils;

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
