package org.quest94.demo.junit5.dynamic.test;

import java.util.List;

record ResultList(List<ShellResult> resultList) {
    record ShellResult(String caseName, boolean result) {
    }
}

