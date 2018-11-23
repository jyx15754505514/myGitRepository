package com.ccicnavi.bims.product.test;

import java.util.ArrayList;

/**
 * @program: bims-backend
 * @description: 该类的作用描述
 * @author: LiJie
 * @create: 2018-11-22 20:30
 */
public class TestContains {

    public static void main(String[] args) {

        ArrayList<String> insertList=new ArrayList<String>();

        ArrayList<String> deleteList=new ArrayList<String>();

        //需要添加到中间表的ID
        insertList.add("1");
        insertList.add("2");
        insertList.add("3");
        insertList.add("4");
        insertList.add("5");

        //中间表已经存在的ID
        deleteList.add("4");
        deleteList.add("5");
        deleteList.add("6");
        deleteList.add("7");


        /**前者比较后者的差集*/
    /*    List<String> reduct1=insertList.stream().filter(item -> !deleteList.contains(item)).collect(Collectors.toList());
        System.out.println(reduct1);

        System.out.println("————————————————————————————————————————");

        *//**后者比较前者的差集*//*
        List<String> reduct2=deleteList.stream().filter(item -> !insertList.contains(item)).collect(Collectors.toList());
        System.out.println(reduct2);*/


        //前者比较后者的差集：
        //deleteList.removeAll(insertList);

        insertList.retainAll(deleteList);

        System.out.println(insertList);


    }
}
