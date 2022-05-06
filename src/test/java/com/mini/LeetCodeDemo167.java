package com.mini;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * 167. 两数之和 II - 输入有序数组
 */
public class LeetCodeDemo167 {

    @Test
    public void twoSumTest() {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        System.out.println(JSON.toJSONString(twoSum(numbers, target)));
    }


    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int x = numbers[i];
            int index = searchBinary(numbers, target - x, i + 1, numbers.length - 1);
            if (index != -1) {
                return new int[]{i + 1, index + 1};
            }
        }
        return new int[0];
    }

    private int searchBinary(int[] numbers, int target, int leftIndex, int rightIndex) {
        while (leftIndex <= rightIndex) {
            int midIndex = leftIndex + ((rightIndex - leftIndex) / 2);
            if (numbers[midIndex] == target) {
                return midIndex;
            }
            if (numbers[midIndex] < target) {
                leftIndex = midIndex + 1;
            } else {
                rightIndex = midIndex - 1;
            }
        }
        return -1;
    }

    /**
     * 给你一个下标从 1 开始的整数数组numbers ，该数组已按 非递减顺序排列 ，请你从数组中找出满足相加之和等于目标数target 的两个数。
     * 如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
     * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
     * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
     * 你所设计的解决方案必须只使用常量级的额外空间。
     * 示例 1：
     * 输入：numbers = [2,7,11,15], target = 9
     * 输出：[1,2]
     * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
     */
    public int[] twoSum4(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            }
            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[0];
    }

    /**
     * 使用双指针方式
     * 譬如：int[] numbers = {1,2,3,4,5,9,10};int target = 8;
     * 左边指针取出 1， 右边指针取出10   1+10>8;
     * 则往右边移一位取9， 1+9>8;
     * 则往右边移一位取5，1+5<8;
     * 则往左边移一位取2，2+5<8;
     * 则往左边移一位取3，3+5=8;
     * 说明找到了，则输出
     */
    public int[] twoSum3(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left, right};
            }
            if (numbers[left] + numbers[right] > target) {
                // 由于右边一定比左边大
                right--;
            } else {
                left++;
            }
        }
        return new int[0];
    }

    /**
     * 给定一个已按照 升序排列 的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数target 。
     * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 0开始计数 ，
     * 所以答案数组应当满足 0<= answer[0] < answer[1] < numbers.length。
     * 假设数组中存在且只存在一对符合条件的数字，同时一个数字不能使用两次。
     * 示例
     * 输入：numbers = [1,2,4,6,10], target = 8
     * 输出：[1,3]
     * 解释：2 与 6 之和等于目标数 8 。因此 index1 = 1, index2 = 3 。
     */
    public int[] twoSum2(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int x = numbers[i];
            // 查找的范围  下标 在 i+1, numbers.length-1 之间
            // 二分查找
            int index = search(numbers, target - x, i + 1, numbers.length - 1);
            // -1说明没有找到
            if (index != -1) {
                return new int[]{i, index};
            }
        }
        return new int[0];
    }

    private int search(int[] numbers, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] == target) {
                return mid;
            }
            // 如果mid下标对应的数字小于目标值，则 下次 找 下标[mid+1, right]之间的数
            if (numbers[mid] < target) {
                left = mid + 1;
            } else {
                // 如果mid下标对应的数字大于目标值，则 下次 找 下标[left, mid-1]之间的数
                right = mid - 1;
            }
        }
        // 找不到返回-1
        return -1;
    }

    public int[] twoSum1(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

}
