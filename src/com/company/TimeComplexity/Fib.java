package com.company.TimeComplexity;

import com.company.utils.Times;

/**
 * 斐波那契数列
 *
 * @author zycstart
 * @create 2020-05-21 23:36
 */
public class Fib {

    public static void main(String[] args) {
        System.out.println(fib(0));
        System.out.println(fib(1));
        System.out.println(fib(2));
        System.out.println(fib(3));
        System.out.println(fib(4));
        System.out.println(fib(5));
        //斐波那契数列性能有问题，n=64 需要584年
        // System.out.println(fib(45));
        //改造fib，复杂度降为O(n)
        System.out.println(fib2(0));
        System.out.println(fib2(1));
        System.out.println(fib2(2));
        System.out.println(fib2(3));
        System.out.println(fib2(4));
        System.out.println(fib2(5));
        System.out.println(fib2(67));
        System.out.println("+++++++++++++++++++++++++++");
        //比较时间复杂度
        int n = 3;
//        Times.test("fib", () -> System.out.println(fib(n)));
        Times.test("fib2", () -> System.out.println(fib2(n)));
        Times.test("fib3", () -> System.out.println(fib3(n)));
    }

    /**
     * 0 1 1 2 3 5 8 13
     * 0 1 2 3 4 5 6 7  (第多少个数，从0开始)
     * 递归版本 O(2^n)  看fib调用多少次，其中有很多重复计算
     *
     * @param n 第多少个数，从0开始
     * @return
     */
    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 0 1 1 2 3 5 8 13
     * 0 1 2 3 4 5 6 7  (第多少个数，从0开始)
     * 非递归版本  O(n)
     *
     * @param n 第多少个数，从0开始
     * @return
     */
    public static int fib2(int n) {
        if (n <= 1) {
            return n;
        }
        int first = 0;
        int second = 1;
        for (int i = 0; i < n - 1; i++) {
            int sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }

    /**
     * 特征方程 O(1)
     *
     * @param n (第多少个数，从0开始)
     * @return
     */
    public static int fib3(int n) {
        double c = Math.sqrt(5);
        return (int) ((Math.pow((1 + c) / 2, n) - Math.pow((1 - c) / 2, n)) / c);
    }
}
