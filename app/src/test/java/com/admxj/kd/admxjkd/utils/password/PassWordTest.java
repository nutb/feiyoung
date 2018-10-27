package com.admxj.kd.admxjkd.utils.password;

import org.junit.Test;

import static org.junit.Assert.*;

public class PassWordTest {
    @Test
    public void a() {
        String a = PassWord.a(PassWordTime.a(), "062310");
        System.out.println(a);
    }
}