package org.quest94.demo.junit5.disabled;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class DisabledTest {

    @Disabled("忽略执行的描述")
    @Test
    void Demo() {
        System.out.println("忽略执行");
    }

}
