package com.company.array;

/**
 * @author zycstart
 * @create 2020-05-23 15:48
 */
public class Main {
    //    List list =  new ArrayList();
    public static void main(String[] args) {
        //new 是向堆空间申请内存
        ArrayList<Integer> list = new ArrayList<>();
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
        list.add(3, 33);
        System.out.println(list.get(2));
        System.out.println(list.remove(6));
        System.out.println("动态数组容量：" + list.size());
        System.out.println("1索引位置：" + list.indexOf(1));
        System.out.println("集合是否包含2：" + list.contains(2));
        System.out.println("集合是否包含1：" + list.contains(1));
        System.out.println("获取索引为0的元素：" + list.get(0));
        System.out.println("获取索引为1的元素：" + list.get(1));
        System.out.println(list);
        for (int i = 0; i < 50; i++) {
            list.add(i);
        }

        //注意集合中存放的是对象时，7代表的时7个内存地址（节省空间），而非字节，和int（基本数据类型）不同
        ArrayList<Person> persons = new ArrayList<>(7);
        persons.add(new Person(10, "小明"));
        persons.add(new Person(11, "小刚"));
        persons.add(null);
        System.out.println(persons);
        System.out.println(persons.indexOf(null));
        persons.clear();

        //提醒垃圾回收，垃圾回收机制是不定时的，觉得内存不够才检测
        System.gc();

        //ArrayList可以同时存放不同类型，只要泛型时Object，或者不适用泛型
        ArrayList<Object> anyObjectList = new ArrayList<>();
        anyObjectList.add(1);
        anyObjectList.add(1.1);
    }
}
