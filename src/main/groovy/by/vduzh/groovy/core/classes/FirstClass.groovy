package by.vduzh.groovy.core.classes

class FirstClass {
    static Integer privateValue

    int foo() {
       return 10
    }

    static void main(String[] args) {
        println "First Class is working..."

        print privateValue
    }
}
