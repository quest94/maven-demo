package org.quest94.demo.junit5.concurrent;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

/**
 * 默认情况下，JUnit Jupiter 测试是在单个线程中按顺序运行的。自 5.3 版起，作为可选功能，可以并发执行测试。
 * <p>
 * 并发测试前提条件：测试用例之间没有依赖关系，容错性好。
 * <p>
 * Junit5 的并发测试是在 junit-platform.properties 文件中进行配置的，只要在 src/main/resources/ 目录下新建该文件，那么 Junit5 在执行测试方法时就会自动读取配置文件中的配置。
 */
public class ConcurrentTest {

    @RepeatedTest(10)
    // 允许并发执行
    @Execution(ExecutionMode.CONCURRENT)
    void testConcurrent() {
        System.out.println("当前线程id：" + Thread.currentThread().threadId());
    }

}
