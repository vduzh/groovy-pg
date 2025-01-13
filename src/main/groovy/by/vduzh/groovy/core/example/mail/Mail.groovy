package by.vduzh.groovy.core.example.mail

class Mail {
    String from
    String to
    String title
    Body body

    def from(String from) {
        this.from = from
    }

    def to(String to) {
        this.to = to
    }

    def title(String title) {
        this.title = title
    }

    def body(@DelegatesTo(Body) Closure closure) {
        this.body = new Body();
        this.body.with closure
    }
}
