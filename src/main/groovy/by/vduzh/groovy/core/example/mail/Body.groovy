package by.vduzh.groovy.core.example.mail

class Body {
    String text
    List<String> images = []

    def text(String text) {
        this.text = text
    }

    def images(List<String> images) {
        this.images += images
    }

    def images(String image) {
        this.images << image
    }
}

