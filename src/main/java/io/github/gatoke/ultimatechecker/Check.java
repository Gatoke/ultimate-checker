package io.github.gatoke.ultimatechecker;

import java.util.Collection;
import java.util.Set;

/**
 * @author Karol Dominiak <gatoke2@gmail.com>
 * <p>
 * Provides methods for comparing values.
 */
public final class Check {

    private Check() {
        throw new UnsupportedOperationException("Creating instance is not allowed!");
    }

    /**
     * Checks if every element is TRUE.
     * <p>
     * Intended to be used as:
     * <pre>
     * var validationResult = Check.allTrue(
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
    public static boolean allTrue(final boolean... booleans) {
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
     * Null-Safe alternative to {@link #allTrue(boolean...)}. Checks if varargs do not contain FALSE.
     * <p>
     * Intended to be used as:
     * <pre>
     * boolean canPerformOperation = Check.noneFalse(
     *         userRepository.doesExist(userId),
     *         authorizationService.hasPrivileges(userId),
     * );
     * </pre>
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
     * Null-Safe alternative to {@link #allTrue(boolean...)}. Checks if collection does not contain FALSE.
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
     * Checks if every element is FALSE.
     * <p>
     * Intended to be used as:
     * <pre>
     * var validationResult = Check.allFalse(
     *     authorizationService.isBanned(userId),
     *     paymentService.didExceedMonthlyLimit(userId)
     * );
     * </pre>
     *
     * @param booleans - non-empty varargs of booleans
     * @return true if every argument is false
     * @throws IllegalArgumentException - when provided varargs are null or empty.
     */
    public static boolean allFalse(final boolean... booleans) {
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
     * Null-Safe alternative to {@link #allFalse(boolean...)}. Checks if varargs do not contain TRUE.
     * <p>
     * Intended to be used as:
     * <pre>
     * boolean hasPermission = Check.noneTrue(
     *         authorizationService.isBanned(userId),
     *         paymentService.didExceedMonthlyLimit(userId),
     * );
     * </pre>
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
     * Null-Safe alternative to {@link #allFalse(boolean...)}. Checks if collection does not contain TRUE.
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
     * <p>
     * Intended to be used as:
     * <pre>
     * boolean hasAccess = Check.anyTrue(
     *         authorizationService.isAdministrator(userId),
     *         authorizationService.isTester(userId)
     * );
     * </pre>
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
     * <p>
     * Intended to be used as:
     * <pre>
     * boolean shouldBlockAccess = Check.anyFalse(
     *         authorizationService.isTester(userId),
     *         authorizationService.hasPrivileges(userId)
     * );
     * </pre>
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
     * Checks if collection contains false.
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
     * <p>
     * Intended to be used as:
     * <pre>
     * boolean haveWonEverywhere = Check.allEqual(username,
     *         electionsService.getWinnerFrom("Śródmieście"),
     *         electionsService.getWinnerFrom("Żoliborz")
     * );
     * </pre>
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
     * <p>
     * Intended to be used as:
     * <pre>
     * boolean didNotWinAnywhere = Check.allNotEqual(username,
     *         electionsService.getWinnerFrom("Śródmieście"),
     *         electionsService.getWinnerFrom("Żoliborz")
     * );
     * </pre>
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
     * <p>
     * Intended to be used as:
     * <pre>
     * boolean haveWonSomewhere = Check.anyEqual(username,
     *         electionsService.getWinnerFrom("Śródmieście"),
     *         electionsService.getWinnerFrom("Żoliborz")
     * );
     * </pre>
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
     * <p>
     * Intended to be used as:
     * <pre>
     * boolean haveFailedSomewhere = Check.anyNotEqual(username,
     *         electionsService.getWinnerFrom("Śródmieście"),
     *         electionsService.getWinnerFrom("Żoliborz")
     * );
     * </pre>
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

    /**
     * Checks if given varargs contain null. Returns false if empty.
     *
     * @param elements - elements to check
     * @return true if any element is null
     */
    @SafeVarargs
    public static <T> boolean anyNull(final T... elements) {
        if (elements == null || elements.length < 1) {
            return false;
        }
        for (T value : elements) {
            if (value == null) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if given collection contains null. Returns false if the collection is null or empty.
     *
     * @param elements - elements to check
     * @return true if any element is null
     */
    public static <T> boolean anyNull(final Collection<T> elements) {
        if (elements == null) {
            return false;
        }
        return elements.contains(null);
    }

    /**
     * Checks if given varargs contain any initialized element. Returns false if empty.
     *
     * @param elements - elements to check
     * @return true if any element is null
     */
    @SafeVarargs
    public static <T> boolean anyNotNull(final T... elements) {
        if (elements == null || elements.length < 1) {
            return false;
        }
        for (T value : elements) {
            if (value != null) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if given collection contains any initialized element. Returns false if collection is null or empty.
     *
     * @param elements - elements to check
     * @return true if any element is null
     */
    public static <T> boolean anyNotNull(final Collection<T> elements) {
        if (elements == null || elements.isEmpty()) {
            return false;
        }
        for (T value : elements) {
            if (value != null) {
                return true;
            }
        }
        return false;
    }

    /**
     * Counts equal elements.
     *
     * @param compared - compared element
     * @param elements - elements to compare with compared
     * @return number of equal elements
     */
    public static <T> long numberOfEqualElements(final T compared, final Collection<T> elements) {
        if (elements == null || elements.size() < 1) {
            return 0;
        }
        if (elements instanceof Set) {
            if (elements.contains(compared)) {
                return 1;
            }
        }

        long count = 0;
        for (T value : elements) {
            if (compared == null) {
                if (value == null) {
                    count++;
                }
                continue;
            }
            if (compared.equals(value)) {
                count++;
            }
        }
        return count;
    }
}
