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

import java.util.List;
import java.util.Objects;
import kotlin.Triple;
import org.jetbrains.annotations.NotNull;

/**
 * An {@link Exception} throws when the {@link TryWithResourcesDispatcher} catches failure
 * while {@linkplain TryWithResourcesDispatcher#close() closing}
 *
 * @see Exception
 * @see TryWithResourcesDispatcher
 * @see TryWithResourcesKt
 */
@SuppressWarnings ("unused")
public final class TryWithResourcesCloseFailedException
  extends Exception
{
    /**
     * The given failures
     */
    @NotNull
    public final List<Triple<Integer, AutoCloseable, Throwable>> failures;
    
    /**
     * Constructs with the given {@code failures}
     *
     * @param failures A list of bundle of failed index, failed resource and failure
     *
     * @see Exception#Exception()
     */
    public TryWithResourcesCloseFailedException(
      @NotNull
      List<Triple<Integer, AutoCloseable, Throwable>> failures
    ) {
        super();
        Objects.requireNonNull(failures, "failures must not be null");
        
        this.failures = failures;
    }
    
    /**
     * Constructs with the given {@code failures} and {@code message}
     *
     * @param failures A list of bundle of failed index, failed resource and failure
     * @param message The detail message which is saved for later retrieval by the {@link #getMessage()} method
     *
     * @see Exception#Exception(String)
     */
    public TryWithResourcesCloseFailedException(
      @NotNull
      List<Triple<Integer, AutoCloseable, Throwable>> failures,
      String message
    ) {
        super(message);
        Objects.requireNonNull(failures, "failures must not be null");
        
        this.failures = failures;
    }
    
    /**
     * Constructs with the given {@code failures}, {@code message} and {@code cause}
     *
     * @param failures A list of bundle of failed index, failed resource and failure
     * @param message The detail message which is saved for later retrieval by the {@link #getMessage()} method
     * @param cause The cause which is saved for later retrieval by the {@link #getCause()} method
     *
     * @see Exception#Exception(String, Throwable)
     */
    public TryWithResourcesCloseFailedException(
      @NotNull
      List<Triple<Integer, AutoCloseable, Throwable>> failures,
      String message,
      Throwable cause
    ) {
        super(message, cause);
        Objects.requireNonNull(failures, "failures must not be null");
        
        this.failures = failures;
    }
    
    /**
     * Constructs with the given {@code failures} and {@code cause}
     *
     * @param failures A list of bundle of failed index, failed resource and failure
     * @param cause The cause which is saved for later retrieval by the {@link #getCause()} method
     *
     * @see Exception#Exception(Throwable)
     */
    public TryWithResourcesCloseFailedException(
      @NotNull
      List<Triple<Integer, AutoCloseable, Throwable>> failures,
      Throwable cause
    ) {
        super(cause);
        Objects.requireNonNull(failures, "failures must not be null");
        
        this.failures = failures;
    }
}
