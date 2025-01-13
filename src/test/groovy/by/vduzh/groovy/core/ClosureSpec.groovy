package by.vduzh.groovy.core

import by.vduzh.groovy.core.example.Student
import spock.lang.Specification

class ClosureSpec extends Specification {

    def "create a closure like a lambda"() {
        given: "a closure instance"
        Closure closure = value -> value * 2

        when: "calling call"
        def result = closure.call(5)

        then: "The result is a number multiplied by 2"
        result == 10
    }

    def "call closure without the call function"() {
        given: "a closure instance"
        Closure closure = value -> value * 2

        when: "calling call"
        def result = closure(5)

        then: "The result is a number multiplied by 2"
        result == 10
    }

    def "create a closure in a closure way"() {
        given: "a closure instance"
        Closure closure = { value -> value * 2 }

        expect: "The result is a number multiplied by 2"
        closure(5) == 10
    }

    def "create a closure with the only param and use it to access that param"() {
        given: "a closure instance"
        Closure closure = { it * 2 }

        expect: "The result is a number multiplied by 2"
        closure(5) == 10
    }

    def "create a closure without params"() {
        given: "a closure instance"
        Closure closure = { -> 2 }

        expect: "The result is 2"
        closure() == 2
    }

    def "create a closure with the default param"() {
        given: "a closure instance"
        Closure closure = { value = 15 -> value * 2 }

        expect: "The result is 30"
        closure() == 30
    }

    def "create a multiline closure returning value"() {
        given: "a closure instance"
        Closure closure = { value ->
            println value
            value * 2
        }

        expect: "The result is a number multiplied by 2"
        closure(5) == 10
    }

    static def higherOrderFunction(boolean condition, Closure closure) {
        println "Foo is working..."
        if (condition) {
            closure()
        }
    }

    def "create a closure that accesses variables"() {
        given: "a variable"
        int x = 10

        higherOrderFunction(x > 0, { println x })
        higherOrderFunction(x > 0, { println(++x) })
    }


    def "simplify call when a closure is the latest param"() {
        given: "a variable"
        int x = 10

        // looks like if
        higherOrderFunction(x > 0) { println x }
        higherOrderFunction(x > 0) {
            println x
        }
    }

    def "thisObject, owner and delegate of the closure return the test object"() {
        given: "a closure"
        Closure closure = {
            firstName = "John"
        }

        expect:
        closure.thisObject == this
        println closure.owner == this
        println closure.delegate == this

        def student = new Student("Andy", "Ness", 35)
    }

    def "thisObject, owner and delegate of the closure return the test object"() {
        given: "a student and a closure"
        def student = new Student("Andy", "Ness", 35)

        Closure closure = {
            firstName = "John"
        }
        closure.delegate = student

        when: "called the closure"
        closure()

        then: "the name of the student is John"
        student.firstName == "John"
    }
}