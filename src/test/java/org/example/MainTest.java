package org.example;

import org.junit.Test;

import static org.junit.Assert.*;
public class MainTest {
    @Test
    public void test() {
//		fail("Not yet implemented");
        Main obj = new Main();
        assertEquals(true,obj.OddOrEven(5));
        assertEquals(4,obj.leftShift(2));
    }
}