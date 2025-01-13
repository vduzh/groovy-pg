package by.vduzh.groovy.core

import by.vduzh.groovy.core.example.mail.Mail
import spock.lang.Specification

import static by.vduzh.groovy.core.example.mail.DslBuilder.mail

class DslSpec extends Specification {

    def "should build a Mail object with the DSL"() {
        given:
        Closure closure = {
            from "from@example.com"
            to "to@example.com"
            title "test"
            body {
                text "Lorem"
                images(["test.jpg", "test.png"])
            }
        }

        when:
        Mail result = mail closure

        then:
        result.title == "test"
    }

    def "should build a Mail object with the DSL in simplified way "() {
        when:
        def result = mail {
            from "from@example.com"
            to "to@example.com"
            title "test"
            body {
                text "Lorem"
                images(["test.jpg", "test.png"])
            }
        }

        then:
        result.title == "test"
        result.body.text == "Lorem"
    }
}