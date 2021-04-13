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
        [true, true, true] as boolean[]    || true
        [true, true, false] as boolean[]   || false
        [true, false, false] as boolean[]  || false
        [false, false, false] as boolean[] || false
    }

    def "noneFalse"() {
        when:
        def actual = BooleanChecker.noneFalse(values)
        then:
        actual == expected

        where:
        values                             || expected
        [true, true, true] as boolean[]    || true
        [true, true, false] as boolean[]   || false
        [true, false, false] as boolean[]  || false
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
        [true, true, null] as List<Boolean>    || true
        [true, true, false] as List<Boolean>   || false
        [true, false, false] as List<Boolean>  || false
        [false, false, false] as List<Boolean> || false
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
        [true, true, true] as boolean[]    || false
        [true, true, false] as boolean[]   || false
        [true, false, false] as boolean[]  || false
        [false, false, false] as boolean[] || true
    }

    def "noneTrue"() {
        when:
        def actual = BooleanChecker.noneTrue(values)
        then:
        actual == expected

        where:
        values                             || expected
        [true, true, true] as boolean[]    || false
        [true, true, false] as boolean[]   || false
        [true, false, false] as boolean[]  || false
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
        values                                || expected
        [true, true, true] as List<Boolean>   || false
        [true, true, false] as List<Boolean>  || false
        [true, false, false] as List<Boolean> || false
        [false, false, null] as List<Boolean> || true
        [] as List<Boolean>                   || true
        null                                  || true
    }

    // -------------------------------------------------------

    def "anyTrue"() {
        when:
        def actual = BooleanChecker.anyTrue(values)
        then:
        actual == expected

        where:
        values                             || expected
        [true, true, true] as boolean[]    || true
        [true, true, false] as boolean[]   || true
        [true, false, false] as boolean[]  || true
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
        [true, true, null] as List<Boolean>    || true
        [true, true, false] as List<Boolean>   || true
        [true, false, false] as List<Boolean>  || true
        [false, false, false] as List<Boolean> || false
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
        [true, true, true] as boolean[]    || false
        [true, true, false] as boolean[]   || true
        [true, false, false] as boolean[]  || true
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
        [true, true, true] as List<Boolean>    || false
        [true, true, false] as List<Boolean>   || true
        [true, false, null] as List<Boolean>   || true
        [false, false, false] as List<Boolean> || true
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
        "car"    | ["car", "car", "home"] as String[]   || false
        "car"    | ["car", null, null] as String[]      || false
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
        null     | [null] as String[]                   || false
        null     | 6L                                   || true
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
