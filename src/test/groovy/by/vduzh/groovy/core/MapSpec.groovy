package by.vduzh.groovy.core

import spock.lang.Specification

class MapSpec extends Specification {

    def "create a map"() {
        given:
        def map = ["one": 1, "two": 2]
        def map2 = [one: 1, two: 2]

        expect:
        map.getClass() == LinkedHashMap
        map2.getClass() == LinkedHashMap
    }

    def "create an empty map"() {
        given:
        def map = [:]

        expect:
        map.isEmpty()
    }

    def "get value"() {
        given:
        def map = ["one": 1, "two": 2]

        expect:
        map.get("one") == 1
        map["one"] == 1
        map."one" == 1
        map.one == 1
    }

    def "get default value"() {
        given:
        def map = ["one": 1]

        expect:
        map.get("two", 2) == 2
    }

    def "set value"() {
        given:
        def map = [:]

        when:
        map.one = 1

        then:
        map.get("one") == 1
    }

    def "sub map"() {
        given:
        def map = ["one": 1, "two": 2, "three": 3, "four": 4]

        expect:
        map.subMap("two", "three") == ["two": 2, "three": 3]
    }

    def "spread"() {
        given:
        def map = ["three": 3, "four": 4]

        when:
        def newMap = ["one": 1, "two": 2, *: map]

        then:
        newMap == ["one": 1, "two": 2, "three": 3, "four": 4]
    }
}