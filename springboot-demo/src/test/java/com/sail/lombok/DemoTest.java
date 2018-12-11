package com.sail.lombok;

import org.junit.Test;

public class DemoTest {
    @Test
    public void outTest(){
        System.out.println(new Demo());
        System.out.println(new Demo(1,"s"));
//        System.out.println(Demo.test(1,"s"));
        System.out.println(new Demo(1,"ss","2"));
    }
}
