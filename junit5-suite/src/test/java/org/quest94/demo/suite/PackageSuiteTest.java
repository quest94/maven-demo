package org.quest94.demo.suite;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages({"org.quest94.demo.demo1", "org.quest94.demo.demo2"})
public class PackageSuiteTest {

}