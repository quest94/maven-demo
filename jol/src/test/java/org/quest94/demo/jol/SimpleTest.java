package org.quest94.demo.jol;

import org.junit.jupiter.api.Test;
import org.openjdk.jol.info.ClassLayout;

public class SimpleTest {

    @Test
    public void objectTest() {
        System.out.println(ClassLayout.parseInstance(new Object()).toPrintable());
    }

    @Test
    public void byteArrayTest() {
        System.out.println(ClassLayout.parseInstance(new byte[]{1}).toPrintable());
    }

    @Test
    public void threadATest() {
        int a = 1000;
        a++;
        System.out.println(ClassLayout.parseInstance(Thread.currentThread()).toPrintable());
    }

    @Test
    public void emptyClassATest() {
        System.out.println(ClassLayout.parseInstance(new ClassA()).toPrintable());
    }

    public static class ClassA {
        int anInt;
        byte aByte;
        String string;
        byte[] bytes;
        boolean aBoolean;
        Object object;
    }
}
