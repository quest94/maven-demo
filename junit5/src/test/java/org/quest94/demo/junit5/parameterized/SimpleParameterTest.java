package org.quest94.demo.junit5.parameterized;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimpleParameterTest {

    @DisplayName("Parameter Count : 1")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testValue(int num1) {
        assertTrue(num1 < 4);
    }

}
