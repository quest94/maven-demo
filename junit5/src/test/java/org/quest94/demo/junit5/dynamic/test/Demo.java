package org.quest94.demo.junit5.dynamic.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.DynamicTest.dynamicTest;


public class Demo {

    // 批量读取测试文件数据，动态生成并执行测试用例
    @TestFactory
    Collection<DynamicTest> runShellResult() throws IOException {
        List<DynamicTest> dynamicTestList = new ArrayList<>();
        ObjectMapper objectMApper = new ObjectMapper(new YAMLFactory());
        // 反序列化yaml数据到对象列表中
        ResultList resultList = objectMApper.readValue(Demo.class.getResourceAsStream("/shell_test_result.yaml"), ResultList.class);
        System.out.println("Done!");
        // 动态遍历生成测试方法
        for (ResultList.ShellResult shellResult : resultList.resultList()) {
            // 动态生成测试方法代码
            DynamicTest dynamicTest = dynamicTest(
                    shellResult.caseName(),
                    () -> {
                        Assertions.assertTrue(shellResult.result());
                    }
            );
            // 收集操作
            dynamicTestList.add(dynamicTest);
        }
        return dynamicTestList;
    }

}
