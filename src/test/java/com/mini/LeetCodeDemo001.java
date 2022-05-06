package com.mini;

import org.junit.Test;

/**
 * 剑指 Offer II 001. 整数除法
 */
public class LeetCodeDemo001 {

    @Test
    public void divideTest() {
        System.out.println(divide3(Integer.MIN_VALUE, 1));
        System.out.println(divide2(Integer.MIN_VALUE, 1));
        System.out.println(divide(Integer.MIN_VALUE, 1));
        System.out.println(1 << 1);
        System.out.println(3 << 4);
        System.out.println(8 >> 3);
    }

    /**
     * int类型的两数相处，不用除法、乘法
     *
     * @param numA
     * @param numB
     * @return
     */
    public int divide(int numA, int numB) {
        /**
         * 每次尝试减去除数的倍数
         * 譬如 numA = 22, numb = 3, k表示3的次数
         *  numA = 22, numb = 3                 k = 1
         *         22 - （3+3） = 16 > 0        k = k+k = 2
         *         22 - （6+6） = 10 > 0        k = k+k = 4
         *         22 - （12+12）= -2 < 0
         * numA = 10, numb = 3                  k = 1
         *        10 -  （3+3） = 4 > 0         k = k+k = 2
         *        10 -  （6+6） = -2 < 0
         * numA = 4, numb = 3                   k = 1
         *         4 -  （3+3） = -2 < 0
         */
        if (numA == Integer.MIN_VALUE && numB == -1) {
            return Integer.MAX_VALUE;
        }
        // numA 和numB 都是负数或者都是正数， 那结果是正数
        // numA 或numB 只要有一个是负数， 那结果是负数
        // 结果为正数还是负数标志
        int sign = (numA > 0) ^ (numB > 0) ? -1 : 1;
        //  如果numA为 -2147483648，Math.abs(numA)的值也是-2147483648
        numA = Math.abs(numA);
        numB = Math.abs(numB);
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            // 防止numB << i 越界，故此用 numA >> i，
            // numA >>> i (相当于numA除以i)  无符号右移的目的是：将 -2147483648 看成 2147483648
            // 防止numB是最小值Integer.MIN_VALUE
            if ((numA >>> i) - numB >= 0) {
                // numB << i 表示  numB向左移i位（也就是 numB乘以2的i次方）
                numA -= (numB << i);
                result += (1 << i);
            }
        }
        return sign == 1 ? result : -result;
    }

    public int divide3(int numA, int numB) {
        if (numA == Integer.MIN_VALUE && numB == -1) {
            return Integer.MAX_VALUE;
        }
        int sign = (numA > 0) ^ (numB > 0) ? -1 : 1;
        if (numA > 0) numA = -numA;
        if (numB > 0) numB = -numB;
        int result = 0;
        while (numA <= numB) {
            int value = numB;
            // 每次减去 （numB）的倍数，K表示有多少个 （numB）
            int k = 1;
            // 0xc0000000 是十进制 -2^30 的十六进制的表示
            // 而 numA 的值不可能比 -2^31 还要小，所以 value 不可能比 -2^30 小
            while (value >= 0xc0000000 && numA <= value + value) {
                value += value;
                k += k;
            }
            numA -= value;
            result += k;
        }
        return sign == 1 ? result : -result;
    }

    public int divide2(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1)
            return Integer.MAX_VALUE;
        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        if (a > 0) a = -a;
        if (b > 0) b = -b;
        int res = 0;
        while (a <= b) {
            int value = b;
            int k = 1;
            // 0xc0000000 是十进制 -2^30 的十六进制的表示
            // 判断 value >= 0xc0000000 的原因：保证 value + value 不会溢出
            // 可以这样判断的原因是：0xc0000000 是最小值 -2^31 的一半，
            // 而 a 的值不可能比 -2^31 还要小，所以 value 不可能比 0xc0000000 小
            // -2^31 / 2 = -2^30
            while (value >= 0xc0000000 && a <= value + value) {
                value += value;
                // 代码优化：如果 k 已经大于最大值的一半的话，那么直接返回最小值
                k += k;
            }
            a -= value;
            res += k;
        }
        // bug 修复：因为不能使用乘号，所以将乘号换成三目运算符
        return sign == 1 ? res : -res;
    }


    public int divide1(int numA, int numB) {
        if (numA == Integer.MIN_VALUE && numB == -1) {
            return Integer.MAX_VALUE;
        }
        if (numA == numB) {
            return 1;
        }
        // 标明结果是整数还是负数
        int sign = (numA > 0) ^ (numB > 0) ? -1 : 1;

        if (numA > 0) numA = -numA;
        if (numB > 0) numB = -numB;

        int result = 0;
        while (numA <= numB) {
            numA -= numB;
            result++;
        }
        return sign == 1 ? result : -result;
    }
}
