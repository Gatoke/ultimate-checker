package io.github.gatoke.booleanchecker


import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class BooleanCheckerTest extends Specification {

    def "allTrue"() {
        when:
        def actual = BooleanChecker.allTrue(values)
        then:
        actual == expected

        where:
        values                             || expected
        [true] as boolean[]                || true
        [false] as boolean[]               || false
        [true, true, true] as boolean[]    || true
        [true, false, false] as boolean[]  || false
        [true, false, true] as boolean[]   || false
        [false, true, false] as boolean[]  || false
        [false, false, false] as boolean[] || false
    }

    def "should throw exception on allTrue when no arguments are passed"() {
        when:
        BooleanChecker.allTrue(values)
        then:
        thrown(expected)

        where:
        values            || expected
        [] as boolean[]   || IllegalArgumentException
        null as boolean[] || IllegalArgumentException
    }

    def "noneFalse"() {
        when:
        def actual = BooleanChecker.noneFalse(values)
        then:
        actual == expected

        where:
        values                             || expected
        [true] as boolean[]                || true
        [false] as boolean[]               || false
        [true, true, true] as boolean[]    || true
        [true, false, false] as boolean[]  || false
        [true, false, true] as boolean[]   || false
        [false, true, false] as boolean[]  || false
        [false, false, false] as boolean[] || false
        [] as boolean[]                    || true
        null                               || true
    }

    def "noneFalse_as_collection"() {
        when:
        def actual = BooleanChecker.noneFalse(values)
        then:
        actual == expected

        where:
        values                                 || expected
        [true] as List<Boolean>                || true
        [false] as List<Boolean>               || false
        [true, true, true] as List<Boolean>    || true
        [true, false, false] as List<Boolean>  || false
        [true, false, true] as List<Boolean>   || false
        [false, true, false] as List<Boolean>  || false
        [false, false, false] as List<Boolean> || false
        [null] as List<Boolean>                || true
        [true, null, null] as List<Boolean>    || true
        [false, null, null] as List<Boolean>   || false
        [] as List<Boolean>                    || true
        null                                   || true
    }

    def "allFalse"() {
        when:
        def actual = BooleanChecker.allFalse(values)
        then:
        actual == expected

        where:
        values                             || expected
        [true] as boolean[]                || false
        [false] as boolean[]               || true
        [true, true, true] as boolean[]    || false
        [true, false, false] as boolean[]  || false
        [true, false, true] as boolean[]   || false
        [false, true, false] as boolean[]  || false
        [false, false, false] as boolean[] || true
    }

    def "should throw exception on allFalse when no argument is passed"() {
        when:
        BooleanChecker.allFalse(values)
        then:
        thrown(expected)

        where:
        values            || expected
        [] as boolean[]   || IllegalArgumentException
        null as boolean[] || IllegalArgumentException
    }

    def "noneTrue"() {
        when:
        def actual = BooleanChecker.noneTrue(values)
        then:
        actual == expected

        where:
        values                             || expected
        [true] as boolean[]                || false
        [false] as boolean[]               || true
        [true, true, true] as boolean[]    || false
        [true, false, false] as boolean[]  || false
        [true, false, true] as boolean[]   || false
        [false, true, false] as boolean[]  || false
        [false, false, false] as boolean[] || true
        [] as boolean[]                    || true
        null                               || true
    }

    def "noneTrue_as_collection"() {
        when:
        def actual = BooleanChecker.noneTrue(values)
        then:
        actual == expected

        where:
        values                                 || expected
        [true] as List<Boolean>                || false
        [false] as List<Boolean>               || true
        [true, true, true] as List<Boolean>    || false
        [true, false, false] as List<Boolean>  || false
        [true, false, true] as List<Boolean>   || false
        [false, true, false] as List<Boolean>  || false
        [false, false, false] as List<Boolean> || true
        [null] as List<Boolean>                || true
        [true, null, null] as List<Boolean>    || false
        [false, null, null] as List<Boolean>   || true
        [] as List<Boolean>                    || true
        null                                   || true
    }

    // -------------------------------------------------------

    def "anyTrue"() {
        when:
        def actual = BooleanChecker.anyTrue(values)
        then:
        actual == expected

        where:
        values                             || expected
        [true] as boolean[]                || true
        [false] as boolean[]               || false
        [true, true, true] as boolean[]    || true
        [true, false, false] as boolean[]  || true
        [true, false, true] as boolean[]   || true
        [false, true, false] as boolean[]  || true
        [false, false, false] as boolean[] || false
        [] as boolean[]                    || false
        null                               || false
    }

    def "anyTrue_as_collection"() {
        when:
        def actual = BooleanChecker.anyTrue(values)
        then:
        actual == expected

        where:
        values                                 || expected
        [true] as List<Boolean>                || true
        [false] as List<Boolean>               || false
        [true, true, true] as List<Boolean>    || true
        [true, false, false] as List<Boolean>  || true
        [true, false, true] as List<Boolean>   || true
        [false, true, false] as List<Boolean>  || true
        [false, false, false] as List<Boolean> || false
        [null] as List<Boolean>                || false
        [true, null, null] as List<Boolean>    || true
        [false, null, null] as List<Boolean>   || false
        [] as List<Boolean>                    || false
        null                                   || false
    }

    // ------------------------------------------------------

    def "anyFalse"() {
        when:
        def actual = BooleanChecker.anyFalse(values)
        then:
        actual == expected

        where:
        values                             || expected
        [true] as boolean[]                || false
        [false] as boolean[]               || true
        [true, true, true] as boolean[]    || false
        [true, false, false] as boolean[]  || true
        [true, false, true] as boolean[]   || true
        [false, true, false] as boolean[]  || true
        [false, false, false] as boolean[] || true
        [] as boolean[]                    || false
        null                               || false
    }

    def "anyFalse_as_collection"() {
        when:
        def actual = BooleanChecker.anyFalse(values)
        then:
        actual == expected

        where:
        values                                 || expected
        [true] as List<Boolean>                || false
        [false] as List<Boolean>               || true
        [true, true, true] as List<Boolean>    || false
        [true, false, false] as List<Boolean>  || true
        [true, false, true] as List<Boolean>   || true
        [false, true, false] as List<Boolean>  || true
        [false, false, false] as List<Boolean> || true
        [null] as List<Boolean>                || false
        [true, null, null] as List<Boolean>    || false
        [false, null, null] as List<Boolean>   || true
        [] as List<Boolean>                    || false
        null                                   || false
    }

    // -------------------------------------------------------

    def "allEqual"() {
        when:
        def actual = BooleanChecker.allEqual(compared, values)
        then:
        actual == expected

        where:
        compared | values                               || expected
        "car"    | ["home", "home", "home"] as String[] || false
        "car"    | ["car", "car", "car"] as String[]    || true
        1L       | [1L, 1L, 1L] as long[]               || true
        null     | [null, null, null] as String[]       || true
        "car"    | ["car", "car", "home"] as String[]   || false
        "car"    | ["car", null, null] as String[]      || false
    }

    def "should throw exception on allEqual when no arguments are passed"() {
        when:
        BooleanChecker.allEqual(compared, values)
        then:
        thrown(expected)

        where:
        compared | values           || expected
        "car"    | null as String[] || IllegalArgumentException
        "car"    | [] as String[]   || IllegalArgumentException
    }

    def "allNotEqual"() {
        when:
        def actual = BooleanChecker.allNotEqual(compared, values)
        then:
        actual == expected

        where:
        compared | values                               || expected
        "car"    | ["home", "home", "home"] as String[] || true
        "car"    | ["car", "car", "car"] as String[]    || false
        1L       | [1L, 1L, 1L] as long[]               || false
        "car"    | ["car", "car", "home"] as String[]   || false
        "car"    | ["car", null, null] as String[]      || false
        null     | [null, null, null] as String[]       || false
        null     | 6L                                   || true
    }

    def "should throw exception on allNotEqual when no arguments are passed"() {
        when:
        def actual = BooleanChecker.allNotEqual(compared, values)
        then:
        thrown(expected)

        where:
        compared | values           || expected
        "car"    | [] as String[]   || IllegalArgumentException
        "car"    | null as String[] || IllegalArgumentException
    }

    def "anyEqual"() {
        when:
        def actual = BooleanChecker.anyEqual(compared, values)
        then:
        actual == expected

        where:
        compared | values                               || expected
        "car"    | ["car", "car", "car"] as String[]    || true
        "car"    | ["car", "home", null] as String[]    || true
        "car"    | ["home", "home", "home"] as String[] || false
        "car"    | [] as String[]                       || false
        null     | [null, "home"] as String[]           || true
        null     | ["car", "home"] as String[]          || false
    }

    def "anyNotEqual"() {
        when:
        def actual = BooleanChecker.anyNotEqual(compared, values)
        then:
        actual == expected

        where:
        compared | values                               || expected
        "car"    | ["car", "car", "car"] as String[]    || false
        "car"    | ["car", "home", null] as String[]    || true
        "car"    | ["home", "home", "home"] as String[] || true
        "car"    | [] as String[]                       || false
        null     | [null, "home"] as String[]           || true
        null     | ["car", "home"] as String[]          || true
    }
}
