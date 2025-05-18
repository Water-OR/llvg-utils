package net.llvg.llvg_utils.iterator;

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
