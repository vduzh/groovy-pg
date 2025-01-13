package by.vduzh.groovy.core.classes;

import by.vduzh.groovy.core.FirstClass;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FirstClassTest {
    @Test
    void foo() {
        FirstClass fc = new FirstClass();
        assertEquals(10, fc.foo());
    }
}
