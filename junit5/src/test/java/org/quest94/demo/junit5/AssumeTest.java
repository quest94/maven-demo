package org.quest94.demo.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class AssumeTest {

    private final String env = "dev1";

    @Test
    @DisplayName("assume simple")
    public void testSimpleAssume() {
        assumeTrue(Objects.equals(this.env, "dev1"));
        System.out.println("环境是 dev1");  // 执行输出
        assumeTrue(Objects.equals(this.env, "dev2"));  // org.opentest4j.TestAbortedException: Assumption failed: assumption is not true
        System.out.println("环境是 dev2");  // 不执行输出
    }

    @Test
    @DisplayName("assume then do")
    public void testAssumeThenDo() {
        // 只有条件满足时，Executable 对象才会被执行
        assumingThat(
                // 表示条件的布尔值
                Objects.equals(this.env, "dev2"),
                // Executable 接口的实现对象
                () -> System.out.println("In dev1")
        );
        // 即使上述不满足条件，也会继续执行剩下代码
        System.out.println("始终执行");
    }

}
