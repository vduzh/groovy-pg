package by.vduzh.groovy.core

import spock.lang.Specification

class RangeSpec extends Specification {

    def "create range"() {
        given:
        def range = 2..8

        expect:
        range.getClass() == IntRange
        range instanceof List<Integer>
        range.get(3) == 5
        range.contains(8)
    }

    def "get data"() {
        given:
        def range = 2..8

        expect:
        range.get(3) == 5
        range.contains(8)
    }

    def "iterate elements"() {
        given:
        def range = 2..8

        expect:
        range.forEach { println it }
    }
}