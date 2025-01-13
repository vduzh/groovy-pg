package by.vduzh.groovy.core.example.mail

class DslBuilder {
    static Mail mail(@DelegatesTo(Mail) Closure closure) {
        def mail = new Mail();
        mail.with closure
        return mail
    }
}
