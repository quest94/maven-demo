package org.quest94.demo.junit5.order.method;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * 随机顺序
 * <p>
 * 还可配置自定义种子 junit.jupiter.execution.order.random.seed 以创建可重复的测试版本：
 * <p>
 * 方式一：在 junit-platform.properties 属性文件中配置
 * junit.jupiter.execution.order.random.seed=99
 * <p>
 * 方式二：在 Maven 的 pom.xml 中配置参数
 * <plugin>
 * <groupId>org.apache.maven.plugins</groupId>
 * <artifactId>maven-surefire-plugin</artifactId>
 * <version>3.0.0-M3</version>
 * <configuration>
 * <properties>
 * <configurationParameters> junit.jupiter.execution.order.random.seed=99 </configurationParameters>
 * </properties>
 * </configuration>
 * </plugin>
 */
@TestMethodOrder(MethodOrderer.Random.class)
class RandomTest {

    @Test
    void aTest() {
    }

    @Test
    void bTest() {
    }

    @Test
    void cTest() {
    }

}
