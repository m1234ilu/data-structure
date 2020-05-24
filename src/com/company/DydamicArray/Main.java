package com.company.DydamicArray;

import java.util.List;

/**
 * @author zycstart
 * @create 2020-05-23 15:48
 */
public class Main {
    //    List list =  new ArrayList();
    public static void main(String[] args) {
        //new 是向堆空间申请内存
        ArrayList list = new ArrayList();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(3,33);
        System.out.println(list.get(2));
        System.out.println(list.remove(6));
        System.out.println("动态数组容量："+list.size());
        System.out.println("1索引位置："+list.indexOf(1));
        System.out.println("集合是否包含2："+list.contains(2));
        System.out.println("集合是否包含1："+list.contains(1));
        System.out.println("获取索引为0的元素："+list.get(0));
        System.out.println("获取索引为1的元素："+list.get(1));
        System.out.println(list);
    }
}
