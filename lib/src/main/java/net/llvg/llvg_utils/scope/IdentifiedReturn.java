package net.llvg.llvg_utils.scope;

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
