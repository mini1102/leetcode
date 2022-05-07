package com.mini;

import org.junit.Test;

/**
 * 剑指 Offer II 019. 最多删除一个字符得到回文
 */
public class LeetCodeDemo019 {

    @Test
    public void isPalindromeTest() {
        String s = " ";
        s = "12345321";
        System.out.println(validPalindrome(s));
    }

    /**
     给定一个非空字符串s，请判断如果最多 从字符串中删除一个字符能否得到一个回文字符串。

     示例 1:
     输入: s = "aba"
     输出: true
     示例 2:
     输入: s = "abca"
     输出: true
     解释: 可以删除 "c" 字符 或者 "b" 字符
     示例 3:
     输入: s = "abc"
     输出: false

     提示:
     1 <= s.length <= 105
     s 由小写英文字母组成
     */
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return validPalindrome(s, left + 1, right) || validPalindrome(s, left, right - 1);
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    private boolean validPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
