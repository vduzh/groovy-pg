package by.vduzh.groovy.core.classes

import spock.lang.Specification

class SimpleSpec extends Specification {
    def "должен вернуть true для простого примера"() {
        expect:
        true == true
    }
}
