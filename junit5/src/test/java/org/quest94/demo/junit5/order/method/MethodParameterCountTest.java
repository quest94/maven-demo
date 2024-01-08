package org.quest94.demo.junit5.order.method;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodParameterCountTest.ParameterCountOrder.class)
public class MethodParameterCountTest {

    @DisplayName("Parameter Count : 2")
    @ParameterizedTest(name = "{index} ==> fruit=''{0}'', qty={1}")
    @CsvSource({
            "apple, 1",
            "banana, 2"
    })
    void test2(String fruit, int qty) {
        assertTrue(true);
    }

    @DisplayName("Parameter Count : 1")
    @ParameterizedTest(name = "{index} ==> ints={0}")
    @ValueSource(ints = {1, 2, 3})
    void test1(int num1) {
        assertTrue(num1 < 4);
    }

    @DisplayName("Parameter Count : 3")
    @ParameterizedTest(name = "{index} ==> fruit=''{0}'', qty={1}, price={2}")
    @CsvSource({
            "apple, 1, 1.99",
            "banana, 2, 2.99"
    })
    void test3(String fruit, int qty, BigDecimal price) {
        assertTrue(true);
    }


    /**
     * 自定义排序顺序，根据方法入参个数的顺序执行
     */
    static class ParameterCountOrder implements MethodOrderer {

        private final Comparator<MethodDescriptor> comparator =
                Comparator.comparingInt(md1 -> md1.getMethod().getParameterCount());

        @Override
        public void orderMethods(MethodOrdererContext context) {
            context.getMethodDescriptors().sort(comparator.reversed());
        }

    }

}

