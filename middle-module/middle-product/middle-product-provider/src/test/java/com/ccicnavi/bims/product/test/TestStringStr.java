package com.ccicnavi.bims.product.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: bims-backend
 * @description: 该类的作用描述
 * @author: LiJie
 * @create: 2018-11-29 09:07
 */
public class TestStringStr {

    public static void main(String[] args) {
        String str="-";
        List<String> aaa=new ArrayList<String>();
        aaa.add("aaaaaaaa");
        aaa.add("bbbbbbbb");
        aaa.add("cccccccc");
        for (int i = 0; i <aaa.size() ; i++) {
            str+=aaa.get(i)+"-";
        }
        System.out.println(str);
    }
}
