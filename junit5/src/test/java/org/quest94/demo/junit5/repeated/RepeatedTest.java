package org.quest94.demo.junit5.repeated;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class RepeatedTest {

    @org.junit.jupiter.api.RepeatedTest(10)  // 表示重复执行10次
    @DisplayName("重复测试")
    public void testRepeated() {
        Assertions.assertTrue(1 == 1);
    }

}
