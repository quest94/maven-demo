package org.quest94.demo.junit5.nested;

import org.junit.jupiter.api.*;

/**
 * JUnit5 提供了嵌套测试用于更好表示各个单元测试类之间的关系。
 * <p>
 * 平时我们写单元测试时一般都是一个类对应一个单元测试类，不过有些互相之间有业务关系的类，他们的单元测试完全是可以写在一起。
 * 因此，使用内嵌的方式表示，能够减少测试类的数量，防止类爆炸。
 * <p>
 * JUnit5 提供了 @Nested 注解，能够以静态成员内部类的形式对测试用例类进行逻辑分组。
 */
class NestedTest {

    @BeforeAll
    static void initAll() {
        System.out.println("BeforeAll");
    }

    @BeforeEach
    void init() {
        System.out.println("init");
    }

    @Test
    void test() {
        System.out.println("test");
    }

    @AfterEach
    void tearDown() {
        System.out.println("AfterEach");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("AfterAll");
    }

    @Nested
    @DisplayName("Nested2")
    class Nested2 {

        @BeforeAll
        static void initAll() {
            System.out.println("Nested2_initAll");
        }

        @BeforeEach
        void Nested2_init() {
            System.out.println("Nested2_init");
        }

        @Test
        void Nested2_test1() {
            System.out.println("Nested2_test1");
        }

        @Test
        void Nested2_test2() {
            System.out.println("Nested2_test2");
        }

        @AfterEach
        void tearDown() {
            System.out.println("Nested2_AfterEach");
        }

        @AfterAll
        static void tearDownAll() {
            System.out.println("Nested2_AfterAll");
        }

        @Nested
        @DisplayName("Nested3")
        class Nested3 {

            @BeforeEach
            void Nested3_init() {
                System.out.println("Nested3_init");
            }

            @Test
            void Nested3_test1() {
                System.out.println("Nested3_test1");
            }

            @Test
            void Nested3_test2() {
                System.out.println("Nested3_test2");
            }


            @AfterEach
            void tearDown() {
                System.out.println("Nested3_AfterEach");
            }

            @AfterAll
            static void tearDownAll() {
                System.out.println("Nested3_AfterAll");
            }

        }
    }

}
