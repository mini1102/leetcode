package com.mini;

import org.junit.Test;

/**
 *剑指 Offer II 002 二进制加法
 */
public class LeetCodeDemo002 {

    @Test
    public void addBinaryTest() {
        System.out.println(addBinary("1010", "1011"));
        System.out.println(addStrings("1010", "1011"));
    }

    /**
     * 两个二进制 相加
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int enterNum = 0;
        int length1 = a.length() - 1;
        int length2 = b.length() - 1;
        while (length1 >= 0 || length2 >= 0) {
            int n1 = length1 >= 0 ? a.charAt(length1) - '0' : 0;
            int n2 = length2 >= 0 ? b.charAt(length2) - '0' : 0;
            int sum = n1 + n2 + enterNum;
            enterNum = sum / 2;
            res.append(sum % 2);
            length1--;
            length2--;
        }
        if (enterNum > 0) res.append(enterNum);
        return res.reverse().toString();
    }


    /**
     * 两个字符串整数相加
     * @return
     */
    public String addStrings(String num1, String num2){
        StringBuilder res = new StringBuilder();
        int remainNum = 0;
        int length1 = num1.length() - 1;
        int length2 = num2.length() - 1;
        while(length1 >= 0 || length2 >= 0) {
            int n1 = length1 >= 0 ? num1.charAt(length1) - '0' : 0;
            int n2 = length2 >= 0 ? num2.charAt(length2) - '0' : 0;
            int sum = n1 + n2 + remainNum;
            remainNum = sum / 10;
            res.append(sum%10);
            length1--;
            length2--;
        }
        if(remainNum > 0) res.append(remainNum);
        return res.reverse().toString();
    }

    public String addStrings1(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int l1 = num1.length() - 1;
        int l2 = num2.length() - 1;
        while (l1 >= 0 || l2 >= 0) {
            int x = l1 < 0 ? 0 : num1.charAt(l1) - '0';
            int y = l2 < 0 ? 0 : num2.charAt(l2) - '0';

            int sum = x + y + carry;
            res.append(sum % 10);
            carry = sum / 10;

            l1--;
            l2--;
        }
        if (carry != 0) res.append(carry);
        return res.reverse().toString();
    }
}
