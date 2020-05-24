package com.company.complexity;

/**
 * 两种求和时间复杂度比较
 *
 * @author zycstart
 * @create 2020-05-21 23:11
 */
public class Summation {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        int plus = plus(1, 10000);
        System.out.println(plus);
        System.out.println(System.currentTimeMillis());
        System.out.println("=============================");
        System.out.println(System.currentTimeMillis());
        int plus2 = plus2(1, 10000);
        System.out.println(plus2);
        System.out.println(System.currentTimeMillis());
    }

    /**
     * 连续自然数相加
     *
     * @param begin
     * @param end
     * @return
     */
    private static int plus(int begin, int end) {
        int sum = 0;
        for (int i = begin; i <= end; i++) {
            sum += i;
        }
        return sum;
    }

    /**
     * 使用数学公式求和
     *
     * @param begin
     * @param end
     * @return
     */
    private static int plus2(int begin, int end) {
        return (begin + end) * (end - begin + 1) / 2;
    }
}
