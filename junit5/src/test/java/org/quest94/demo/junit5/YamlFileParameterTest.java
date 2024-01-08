package org.quest94.demo.junit5;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.List;

public class YamlFileParameterTest {

    /**
     * Yaml文件内容：
     * - name: apple
     *   age: 12
     * - name: banana
     *   age: 13
     */
    static List<User> testDDTFromYaml() throws IOException {
        return new ObjectMapper(new YAMLFactory()).readValue(
                ParameterTest.class.getResourceAsStream("/user.yaml"),
                // 本类名反射
                new TypeReference<>() {
                }
        );
    }

    @ParameterizedTest
    // @MethodSource("testDDTFromYaml")  // 指定获取数据源的方法名
    @MethodSource  // 若不指定方法名，则自动找同名方法
    @DisplayName("从方法获取测试数据")
    void testDDTFromYaml(User user) {
        System.out.println(user);
        Assertions.assertTrue(user.name.length() > 3);
    }

    record User(String name, String age) {
    }

}
