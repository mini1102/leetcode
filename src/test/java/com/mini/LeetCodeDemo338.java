package com.mini;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * #338 比特位计数
 */
public class LeetCodeDemo338 {

    @Test
    public void countBitsTest(){
        int[] bits = countBits(6);
        System.out.println(JSON.toJSONString(bits));
    }

    public int[] countBits(int n) {
        /*
           如果当前n为偶数，则二进制中1的个数为 n >> 1 的二进制中1的个数。
               例如 1(0001) 左移一位后变为 2(0010)，2(0010)左移一位后变为4(0100)，他们1的个数都是不变的，只是位置在变化。
           如果当前n为奇数，则二进制中1的个数为前一个数二进制1的个数+1。
               例如，5(101)，上一个数为4(100), 5 = 4 + 1, 加上的1就是加到了二进制中的最后一位
        */
        int[] bits = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            bits[i] = (i%2 == 0) ? bits[i>>1] : bits[i-1]+1;
        }
        return bits;
    }


}
