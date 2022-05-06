package com.mini;

import org.junit.Test;

/**
 * 剑指 Offer II 018. 有效的回文
 */
public class LeetCodeDemo018 {

    @Test
    public void isPalindromeTest() {
        String s = "A man, a plan, a canal: Panama";
        s = " ";
        s = "race a car";
        System.out.println(isPalindrome(s));
    }


    public boolean isPalindrome(String s) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (isLetterOrDigit(s.charAt(i))) {
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        int left = 0;
        int right = sb.length() - 1;
        while (left < right) {
            if (sb.charAt(left) != sb.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isPalindrome2(String s) {
        StringBuffer sgood = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sgood.append(Character.toLowerCase(ch));
            }
        }
        int n = sgood.length();
        int left = 0, right = n - 1;
        while (left < right) {
            if (Character.toLowerCase(sgood.charAt(left)) != Character.toLowerCase(sgood.charAt(right))) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }


    /**
     * 有效的回文
     * 给定一个字符串 s ，验证 s 是否是 回文串 ，只考虑字母和数字字符，可以忽略字母的大小写。
     * 本题中，将空字符串定义为有效的 回文串 。
     * 示例 1:
     * 输入: s = "A man, a plan, a canal: Panama"
     * 输出: true
     * 解释："amanaplanacanalpanama" 是回文串
     *
     * @return
     */
    public boolean isPalindrome1(String s) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (isLetterOrDigit(s.charAt(i))) {
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        StringBuilder sb_reverse = new StringBuilder(sb).reverse();
        if (sb.toString().equals(sb_reverse.toString())) {
            return true;
        }
        return false;
    }

    private boolean isLetterOrDigit(char c) {
        return Character.isLetterOrDigit(c);
    }
}
