package com.ccicnavi.bims.breeder.impl;

/**
 * @ClassName: test
 * @description: TODO
 * @author: zhaotao
 * @create: 2018-11-24 09:47
 **/
public class test {
    public static void main(String[] age) {
        PasswdServiceImpl pass = new PasswdServiceImpl();
        //String hash = pass.getHash("111111", "111111");
        String salt = "111111";
        String passHash = "ALsVyNVea1i5YhvNdVBSMFb4l4zLUd5SzPxFoIB6o0MYP/vKJk+b+qw1x8kknfnepxV68sIESZ0HSUxoj5Q12co=";
        boolean verify = pass.verify(passHash, "111111", salt);
        System.out.println(verify);
    }
}
