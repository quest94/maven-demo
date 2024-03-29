package org.quest94.demo.junit5.parameterized;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CsvParameterTest {

    @DisplayName("Parameter Count : 1")
    @ParameterizedTest
    @CsvSource({
            "apple",
            "banana",
            "'lemon, lime'",
            "strawberry"
    })
    void testCsv(String fruit) {
        assertTrue(true);
    }

    @DisplayName("Parameter Count : 2")
    @ParameterizedTest(name = "{index} ==> fruit=''{0}'', qty={1}")
    @CsvSource({
            "apple,         1",
            "banana,        2",
            "'lemon, lime', 0xF1",
            "strawberry,    700_000"
    })
    void testCsv1(String fruit, int qty) {
        assertTrue(true);
    }

    @DisplayName("Parameter Count : 3")
    @ParameterizedTest(name = "{index} ==> fruit=''{0}'', qty={1}, price={2}")
    @CsvSource({
            "apple, 1, 1.99",
            "banana, 2, 2.99"
    })
    void testCsv2(String fruit, int qty, BigDecimal price) {
        assertTrue(true);
    }

    /**
     * csv文件内容:
     * name, age
     * shawn, 24
     */
    @DisplayName("参数化测试-从csv文件获取")
    @ParameterizedTest
    @CsvFileSource(resources = "/parameterized/test.csv", numLinesToSkip = 1)  // 指定csv文件位置，并忽略标题行
    public void parameterizedTestWithCsv(String name, Integer age) {
        System.out.println("name:" + name + ", age:" + age);
        Assertions.assertNotNull(name);
        Assertions.assertNotNull(age);
    }

}
