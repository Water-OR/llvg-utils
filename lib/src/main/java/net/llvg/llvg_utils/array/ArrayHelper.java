package net.llvg.llvg_utils.array;

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
