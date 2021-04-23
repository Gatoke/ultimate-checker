//file:noinspection GroovyPointlessBoolean
package io.github.gatoke.ultimatechecker

import spock.lang.Specification
import spock.lang.Unroll

import java.lang.reflect.InvocationTargetException

@Unroll
class CheckTest extends Specification {

    def "should throw exception when try to create instance of Check"() {
        given:
        def constructor = Check.class.getDeclaredConstructor()
        constructor.setAccessible(true)

        when:
        constructor.newInstance()

        then:
        InvocationTargetException result = thrown()
        and:
        result.targetException instanceof UnsupportedOperationException
    }

    def "allTrue"() {
        when:
        def actual = Check.allTrue(values)
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
        Check.allTrue(values)
        then:
        thrown(expected)

        where:
        values            || expected
        [] as boolean[]   || IllegalArgumentException
        null as boolean[] || IllegalArgumentException
    }

    def "noneFalse"() {
        when:
        def actual = Check.noneFalse(values)
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
    }

    def "noneFalse with null passed"() {
        when:
        def result = Check.noneFalse(null as boolean[])
        then:
        result == true
    }

    def "noneFalse_as_collection"() {
        when:
        def actual = Check.noneFalse(values)
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
        null as List<Boolean>                  || true
    }

    def "allFalse"() {
        when:
        def actual = Check.allFalse(values)
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
        Check.allFalse(values)
        then:
        thrown(expected)

        where:
        values            || expected
        [] as boolean[]   || IllegalArgumentException
        null as boolean[] || IllegalArgumentException
    }

    def "noneTrue"() {
        when:
        def actual = Check.noneTrue(values)
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
    }

    def "noneTrue with null passed"() {
        when:
        def result = Check.noneTrue(null as boolean[])
        then:
        result == true
    }

    def "noneTrue_as_collection"() {
        when:
        def actual = Check.noneTrue(values)
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
        def actual = Check.anyTrue(values)
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
    }

    def "anyTrue with null passed"() {
        when:
        def result = Check.anyTrue(null as boolean[])

        then:
        result == false
    }

    def "anyTrue_as_collection"() {
        when:
        def actual = Check.anyTrue(values)
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
        null as List<Boolean>                  || false
    }

    // ------------------------------------------------------

    def "anyFalse"() {
        when:
        def actual = Check.anyFalse(values)
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
    }

    def "anyFalse with null passed"() {
        when:
        def result = Check.anyFalse(null as boolean[])

        then:
        result == false
    }

    def "anyFalse_as_collection"() {
        when:
        def actual = Check.anyFalse(values)
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
        null as List<Boolean>                  || false
    }

    // -------------------------------------------------------

    def "allEqual"() {
        when:
        def actual = Check.allEqual(compared, values)
        then:
        actual == expected

        where:
        compared | values                                  || expected
        "true"   | ["true"] as String[]                    || true
        "true"   | ["false"] as String[]                   || false
        "true"   | ["true", "true", "true"] as String[]    || true
        "true"   | ["true", "false", "false"] as String[]  || false
        "true"   | ["true", "false", "true"] as String[]   || false
        "true"   | ["false", "true", "false"] as String[]  || false
        "true"   | ["false", "false", "false"] as String[] || false
        "true"   | [null] as String[]                      || false
        "true"   | ["true", null, null] as String[]        || false
        "true"   | ["false", null, null] as String[]       || false
        null     | [null, null] as String[]                || true
        null     | [null, "true"] as String[]              || false
        null     | ["false", "false"] as String[]          || false
    }

    def "should throw exception on allEqual when no arguments are passed"() {
        when:
        Check.allEqual(compared, values)
        then:
        thrown(expected)

        where:
        compared | values           || expected
        "car"    | null as String[] || IllegalArgumentException
        "car"    | [] as String[]   || IllegalArgumentException
    }

    def "allNotEqual"() {
        when:
        def actual = Check.allNotEqual(compared, values)
        then:
        actual == expected

        where:
        compared | values                                  || expected
        "true"   | ["true"] as String[]                    || false
        "true"   | ["false"] as String[]                   || true
        "true"   | ["true", "true", "true"] as String[]    || false
        "true"   | ["true", "false", "false"] as String[]  || false
        "true"   | ["true", "false", "true"] as String[]   || false
        "true"   | ["false", "true", "false"] as String[]  || false
        "true"   | ["false", "false", "false"] as String[] || true
        "true"   | [null] as String[]                      || true
        "true"   | ["true", null, null] as String[]        || false
        "true"   | ["false", null, null] as String[]       || true
        null     | [null, null] as String[]                || false
        null     | [null, "true"] as String[]              || false
        null     | ["false", "false"] as String[]          || true
    }

    def "should throw exception on allNotEqual when no arguments are passed"() {
        when:
        Check.allNotEqual(compared, values)
        then:
        thrown(expected)

        where:
        compared | values           || expected
        "car"    | [] as String[]   || IllegalArgumentException
        "car"    | null as String[] || IllegalArgumentException
    }

    def "anyEqual"() {
        when:
        def actual = Check.anyEqual(compared, values)
        then:
        actual == expected

        where:
        compared | values                                  || expected
        "true"   | ["true"] as String[]                    || true
        "true"   | ["false"] as String[]                   || false
        "true"   | ["true", "true", "true"] as String[]    || true
        "true"   | ["true", "false", "false"] as String[]  || true
        "true"   | ["true", "false", "true"] as String[]   || true
        "true"   | ["false", "true", "false"] as String[]  || true
        "true"   | ["false", "false", "false"] as String[] || false
        "true"   | [null] as String[]                      || false
        "true"   | ["true", null, null] as String[]        || true
        "true"   | ["false", null, null] as String[]       || false
        "true"   | [] as String[]                          || false
        "true"   | null                                    || false
        null     | [null, null] as String[]                || true
        null     | [null, "true"] as String[]              || true
        null     | ["false", "false"] as String[]          || false
        null     | null as String[]                        || false
    }

    def "anyNotEqual"() {
        when:
        def actual = Check.anyNotEqual(compared, values)
        then:
        actual == expected

        where:
        compared | values                                  || expected
        "true"   | ["true"] as String[]                    || false
        "true"   | ["false"] as String[]                   || true
        "true"   | ["true", "true", "true"] as String[]    || false
        "true"   | ["true", "false", "false"] as String[]  || true
        "true"   | ["true", "false", "true"] as String[]   || true
        "true"   | ["false", "true", "false"] as String[]  || true
        "true"   | ["false", "false", "false"] as String[] || true
        "true"   | [null] as String[]                      || true
        "true"   | ["true", null, null] as String[]        || true
        "true"   | ["false", null, null] as String[]       || true
        "true"   | [] as String[]                          || false
        "true"   | null                                    || false
        null     | [null, null] as String[]                || false
        null     | [null, "true"] as String[]              || true
        null     | ["false", "false"] as String[]          || true
        null     | null as String[]                        || false
    }

    def "anyNull"() {
        when:
        def actual = Check.anyNull(values)
        then:
        actual == expected

        where:
        values                                  || expected
        ["true"] as String[]                    || false
        ["false"] as String[]                   || false
        ["true", "true", "true"] as String[]    || false
        ["true", "false", "false"] as String[]  || false
        ["true", "false", "true"] as String[]   || false
        ["false", "true", "false"] as String[]  || false
        ["false", "false", "false"] as String[] || false
        [null] as String[]                      || true
        ["true", null, null] as String[]        || true
        ["false", null, null] as String[]       || true
        [] as String[]                          || false
        [null, null] as String[]                || true
        [null, "true"] as String[]              || true
    }

    def "anyNull with null passed"() {
        when:
        def actual = Check.anyNull(null as String[])
        then:
        actual == false
    }

    def "anyNull as collection"() {
        when:
        def actual = Check.anyNull(values)
        then:
        actual == expected

        where:
        values                                      || expected
        ["true"] as List<String>                    || false
        ["false"] as List<String>                   || false
        ["true", "true", "true"] as List<String>    || false
        ["true", "false", "false"] as List<String>  || false
        ["true", "false", "true"] as List<String>   || false
        ["false", "true", "false"] as List<String>  || false
        ["false", "false", "false"] as List<String> || false
        [null] as List<String>                      || true
        ["true", null, null] as List<String>        || true
        ["false", null, null] as List<String>       || true
        [] as List<String>                          || false
        [null, null] as List<String>                || true
        [null, "true"] as List<String>              || true
        null as List<String>                        || false
    }

    def "anyNotNull"() {
        when:
        def actual = Check.anyNotNull(values)
        then:
        actual == expected

        where:
        values                                  || expected
        ["true"] as String[]                    || true
        ["false"] as String[]                   || true
        ["true", "true", "true"] as String[]    || true
        ["true", "false", "false"] as String[]  || true
        ["true", "false", "true"] as String[]   || true
        ["false", "true", "false"] as String[]  || true
        ["false", "false", "false"] as String[] || true
        [null] as String[]                      || false
        ["true", null, null] as String[]        || true
        ["false", null, null] as String[]       || true
        [] as String[]                          || false
        [null, null] as String[]                || false
        [null, "true"] as String[]              || true
    }

    def "anyNotNull with null passed"() {
        when:
        def actual = Check.anyNotNull(null as String[])
        then:
        actual == false
    }

    def "anyNotNull as collection"() {
        when:
        def actual = Check.anyNotNull(values)
        then:
        actual == expected

        where:
        values                                      || expected
        ["true"] as List<String>                    || true
        ["false"] as List<String>                   || true
        ["true", "true", "true"] as List<String>    || true
        ["true", "false", "false"] as List<String>  || true
        ["true", "false", "true"] as List<String>   || true
        ["false", "true", "false"] as List<String>  || true
        ["false", "false", "false"] as List<String> || true
        [null] as List<String>                      || false
        ["true", null, null] as List<String>        || true
        ["false", null, null] as List<String>       || true
        [] as List<String>                          || false
        [null, null] as List<String>                || false
        [null, "true"] as List<String>              || true
        null as List<String>                        || false
    }
}
