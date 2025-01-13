package by.vduzh.groovy.core.example

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import groovy.transform.TupleConstructor
import groovy.transform.builder.Builder

@TupleConstructor
@Builder
@EqualsAndHashCode
@ToString
class Student {
    String firstName
    String lastName
    Integer age
}
