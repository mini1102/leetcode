package com.mini;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.List;

/**
 * 剑指 Offer II 024. 反转链表
 */
public class LeetCodeDemo024 {

    @Test
    public void reverseListTest() {
        ListNode headA5 = new ListNode(5);
        ListNode headA4 = new ListNode(4);
        ListNode headA3 = new ListNode(3);
        ListNode headA2 = new ListNode(2);
        ListNode headA1 = new ListNode(1);
        headA5.next = null;
        headA4.next = headA5;
        headA3.next = headA4;
        headA2.next = headA3;
        headA1.next = headA2;

        ListNode headA = headA1;

/*
反转之前输出
        while (null != headA) {
            System.out.println(JSON.toJSONString(headA.val));
            headA = headA.next;
        }
*/

        ListNode node = reverseList(headA);
        while (null != node) {
            System.out.println(JSON.toJSONString(node.val));
            node = node.next;
        }
    }

    /**
     * 给定单链表的头节点 head ，请反转链表，并返回反转后的链表的头节点。
     * 示例 1：
     * 输入：head = [1,2,3,4,5]
     * 输出：[5,4,3,2,1]

     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }

/*
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
*/


    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode(int x, ListNode n) {
            val = x;
            next = n;
        }
    }

}
