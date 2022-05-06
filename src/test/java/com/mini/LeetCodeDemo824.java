package com.mini;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LeetCodeDemo824 {

    @Test
    public void toGoatLatinTest() {
        long start = System.currentTimeMillis();
        String sentence = "Each word consists of lowercase and uppercase letters only";
        String result = toGoatLatin(sentence);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(result);
    }

    public String toGoatLatin(String sentence) {
        boolean flag = sentence.matches("[a-zA-Z\\s]+");
        if (!flag) {
            throw new RuntimeException("字符串只允许英文字母和空格");
        }
        int length = sentence.length();
        if (length < 0 || length > 150) {
            throw new RuntimeException("字符串长度在1到150之间");
        }
        String suffix = "a";
        String addStr = "ma";
        List<String> yuanyi = Arrays.asList("a", "e", "i", "o", "u", "A", "E", "I", "O", "U");
        String[] sentenceArr = sentence.trim().split("\\s+");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sentenceArr.length; i++) {
            if (yuanyi.contains(sentenceArr[i].substring(0, 1))) {
                result.append(sentenceArr[i]).append(addStr);
            } else {
                result.append(sentenceArr[i].substring(1, sentenceArr[i].length()));
                result.append(sentenceArr[i].substring(0, 1)).append(addStr);
            }
            for (int j = 0; j <= i; j++) {
                result.append(suffix);
            }
            if (i != sentenceArr.length - 1) {
                result.append(" ");
            }
        }
        return result.toString();
    }
}
