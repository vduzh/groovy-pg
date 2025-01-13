package by.vduzh.groovy.core.example

import spock.lang.Specification

class CalculatorSpec extends Specification {

    def "addition should return the sum of two numbers"() {
        given: "a calculator instance"
        def calculator = new Calculator()

        when: "adding two numbers"
        def result = calculator.add(3, 5)

        then: "the result is their sum"
        result == 8
    }

    def "subtraction should return the difference of two numbers"() {
        given: "a calculator instance"
        def calculator = new Calculator()

        when: "subtracting two numbers"
        def result = calculator.subtract(10, 4)

        then: "the result is their difference"
        result == 6
    }
}