package org.quest94.demo.suite;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;
import org.quest94.demo.demo2.CTest;

@RunWith(JUnitPlatform.class)
@SelectPackages({"org.quest94.demo.demo1.inner"})
@SelectClasses({CTest.class})
public class PackageAndClassSuiteTest {
    // 执行 @SelectPackages 和 @SelectClasses 并集后的测试方法
}
