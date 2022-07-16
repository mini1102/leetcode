package com.mini;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer II 027. 回文链表
 */
public class LeetCodeDemo027 {

    @Test
    public void isPalindromeTest() {
        ListNode headA5 = new ListNode(1);
        ListNode headA4 = new ListNode(2);
      //  ListNode headA3 = new ListNode(3);
        ListNode headA2 = new ListNode(1);
        ListNode headA1 = new ListNode(1);
        headA5.next = null;
        headA4.next = headA5;
       // headA3.next = headA4;
        headA2.next = headA4;
        headA1.next = headA2;

        ListNode head = headA1;

       /* ListNode reverseHead = reverseList(head);
        while(null != reverseHead) {
            System.out.println(reverseHead.val);
            reverseHead = reverseHead.next;
        }*/
        //System.out.println(isPalindrome(head));
        System.out.println(isPalindrome(head));
    }

    public boolean isPalindrome1(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (null != head) {
            list.add(head.val);
            head = head.next;
        }
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            if (list.get(left) != list.get(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode source = sourceList(head);

        ListNode reverseHead = reverseList(head);
        while (null != source) {
            if (source.val != reverseHead.val) {
                return false;
            }
            source = source.next;
            reverseHead = reverseHead.next;
        }
        return true;
    }

    private ListNode sourceList(ListNode head) {
        return head; // 次方法有问题，head还是会受到影响
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (null != curr) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

/*
    public boolean isPalindrome(ListNode head) {
        String str = JSON.toJSONString(head);
        ListNode source = JSON.parseObject(str, ListNode.class);

        ListNode reverseHead = reverseList(head);
        while (null != source) {
            if (source.val != reverseHead.val) {
                return false;
            }
            source = source.next;
            reverseHead = reverseHead.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (null != curr) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }*/

    /**
     * Definition for singly-linked list.
     */
    public  class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int x) {
            val = x;
        }

        ListNode(int x, ListNode n) {
            val = x;
            next = n;
        }
    }

}
