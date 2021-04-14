package io.github.gatoke.booleanchecker;

import java.util.Collection;

/**
 * @author Karol Dominiak <gatoke2@gmail.com>
 * <p>
 * Provides methods for comparing values.
 */
public final class BooleanChecker {

    private BooleanChecker() {
        throw new UnsupportedOperationException("Creating instance is not allowed!");
    }

    /**
     * Checks if every element is TRUE. Intended to be used as:
     *
     * <pre>
     * var validationResult = BooleanChecker.allTrue(
     *     userRepository.doesExist(userId),
     *     authorizationService.hasPrivileges(userId),
     *     operationType == SomeEnum.DEPOSIT
     * );
     * </pre>
     *
     * @param booleans - non-empty varargs of booleans
     * @return true if every argument is true
     * @throws IllegalArgumentException - when provided varargs are null or empty.
     */
    public static boolean allTrue(final boolean... booleans) throws IllegalArgumentException {
        if (booleans == null || booleans.length < 1) {
            throw new IllegalArgumentException("At least one argument is required.");
        }
        for (final boolean b : booleans) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    /**
     * Safe alternative to {@link #allTrue(boolean...)}. Checks if varargs do not contain FALSE.
     *
     * @param booleans - varargs of booleans
     * @return TRUE if varargs do not contain FALSE.
     */
    public static boolean noneFalse(final boolean... booleans) {
        if (booleans == null || booleans.length < 1) {
            return true;
        }
        for (final boolean b : booleans) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    /**
     * Safe alternative to {@link #allTrue(boolean...)}. Checks if collection does not contain FALSE.
     *
     * @param booleans - collection of booleans
     * @return TRUE if collection do not contain FALSE.
     */
    public static boolean noneFalse(final Collection<Boolean> booleans) {
        if (booleans == null || booleans.isEmpty()) {
            return true;
        }
        return !booleans.contains(false);
    }

    /**
     * Checks if every element is FALSE. Intended to be used as:
     *
     * <pre>
     * var validationResult = BooleanChecker.allFalse(
     *     authorizationService.isBanned(userId),
     *     paymentService.didExceedMonthlyLimit(userId)
     * );
     * </pre>
     *
     * @param booleans - non-empty varargs of booleans
     * @return true if every argument is false
     * @throws IllegalArgumentException - when provided varargs are null or empty.
     */
    public static boolean allFalse(final boolean... booleans) throws IllegalArgumentException {
        if (booleans == null || booleans.length < 1) {
            throw new IllegalArgumentException("At least one argument is required.");
        }
        for (final boolean b : booleans) {
            if (b) {
                return false;
            }
        }
        return true;
    }

    /**
     * Safe alternative to {@link #allFalse(boolean...)}. Checks if varargs do not contain TRUE.
     *
     * @param booleans - varargs of booleans
     * @return TRUE if varargs do not contain TRUE.
     */
    public static boolean noneTrue(final boolean... booleans) {
        if (booleans == null || booleans.length < 1) {
            return true;
        }
        for (final boolean b : booleans) {
            if (b) {
                return false;
            }
        }
        return true;
    }

    /**
     * Safe alternative to {@link #allFalse(boolean...)}. Checks if collection does not contain TRUE.
     *
     * @param booleans - collection of booleans
     * @return TRUE if collection do not contain TRUE.
     */
    public static boolean noneTrue(final Collection<Boolean> booleans) {
        if (booleans == null || booleans.isEmpty()) {
            return true;
        }
        return !booleans.contains(true);
    }

    /**
     * Checks if varargs contain true.
     *
     * @param booleans varargs of booleans
     * @return true if any element is true
     */
    public static boolean anyTrue(final boolean... booleans) {
        if (booleans == null || booleans.length < 1) {
            return false;
        }
        for (final boolean b : booleans) {
            if (b) return true;
        }
        return false;
    }

    /**
     * Checks if collection contain true.
     *
     * @param booleans varargs of booleans
     * @return true if any element is false
     */
    public static boolean anyTrue(final Collection<Boolean> booleans) {
        if (booleans == null || booleans.isEmpty()) {
            return false;
        }
        return booleans.contains(true);
    }

    /**
     * Checks if varargs contain false.
     *
     * @param booleans varargs of booleans
     * @return true if any element is false
     */
    public static boolean anyFalse(final boolean... booleans) {
        if (booleans == null || booleans.length < 1) {
            return false;
        }
        for (final boolean b : booleans) {
            if (!b) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if collection contain false.
     *
     * @param booleans varargs of booleans
     * @return true if any element is false
     */
    public static boolean anyFalse(final Collection<Boolean> booleans) {
        if (booleans == null || booleans.isEmpty()) {
            return false;
        }
        return booleans.contains(false);
    }

    /**
     * Checks if every vararg element (right) is equal compared element (left).
     *
     * @param compared - element to compare
     * @param values   - elements to compare with compared
     * @return true if every element is equal compared
     * @throws IllegalArgumentException - when provided varargs are null or empty.
     */
    @SafeVarargs
    public static <T> boolean allEqual(final T compared, final T... values) {
        if (values == null || values.length < 1) {
            throw new IllegalArgumentException("Second argument cannot be null or empty!");
        }
        for (final T value : values) {
            if (compared == null) {
                if (value == null) {
                    continue;
                }
                return false;
            }
            if (!compared.equals(value)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if all of vararg elements (right) is are different from compared element (left).
     *
     * @param compared - element to compare
     * @param values   - elements to compare with compared
     * @return true if every element is NOT equal compared
     * @throws IllegalArgumentException - when provided varargs are null or empty.
     */
    @SafeVarargs
    public static <T> boolean allNotEqual(final T compared, final T... values) {
        if (values == null || values.length < 1) {
            throw new IllegalArgumentException("Second argument cannot be null or empty!");
        }
        for (final T value : values) {
            if (compared == null) {
                if (value == null) {
                    return false;
                }
                continue;
            }
            if (compared.equals(value)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if any vararg element (right) is matching compared element (left).
     * Returns false if varargs are empty or null.
     *
     * @param compared - element to compare
     * @param values   - elements to compare with compared
     * @return true if any element is equal compared
     */
    @SafeVarargs
    public static <T> boolean anyEqual(final T compared, final T... values) {
        if (values == null || values.length < 1) {
            return false;
        }
        for (final T value : values) {
            if (compared == null) {
                if (value == null) {
                    return true;
                }
                continue;
            }
            if (compared.equals(value)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if any vararg element (right) is NOT matching compared element (left).
     * Returns false if varargs are empty or null.
     *
     * @param compared - element to compare
     * @param values   - elements to compare with compared
     * @return true if any element is NOT equal compared.
     */
    @SafeVarargs
    public static <T> boolean anyNotEqual(final T compared, final T... values) {
        if (values == null || values.length < 1) {
            return false;
        }
        for (final T value : values) {
            if (compared == null) {
                if (value != null) {
                    return true;
                }
                continue;
            }
            if (!compared.equals(value)) {
                return true;
            }
        }
        return false;
    }
}
