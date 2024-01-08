package org.quest94.demo.junit5.order.method;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class MethodNameTest {

    @Test
    void testZ() {
        assertEquals(2, 1 + 1);
    }

    @Test
    void testA() {
        assertEquals(2, 1 + 1);
    }

    @Test
    void testY() {
        assertEquals(2, 1 + 1);
    }

    @Test
    void testE() {
        assertEquals(2, 1 + 1);
    }

    @Test
    void testB() {
        assertEquals(2, 1 + 1);
    }

}
