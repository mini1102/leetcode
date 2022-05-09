package com.mini;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 剑指 Offer II 023. 两个链表的第一个重合节点
 */
public class LeetCodeDemo023 {

    @Test
    public void getIntersectionNodeTest() {
        ListNode headA5 = new ListNode(4);
        ListNode headA4 = new ListNode(2);
        ListNode headA3 = new ListNode(1);
        ListNode headA2 = new ListNode(9);
        ListNode headA1 = new ListNode(0);
        headA5.next = null;
        headA4.next = headA5;
        headA3.next = headA4;
        headA2.next = headA3;
        headA1.next = headA2;
        ListNode headA = headA1;

        ListNode headB3 = new ListNode(4);
        ListNode headB2 = new ListNode(2);
        ListNode headB1 = new ListNode(3);
        headB3.next = null;
        headB2.next = headB3;
        headB1.next = headB2;
        ListNode headB = headB1;


       /* while (null != headA) {
            System.out.println(JSON.toJSONString(headA.val));
            headA = headA.next;
        }*/
        ListNode node = getIntersectionNode (headA, headB);
        System.out.println(node);

        System.out.println(15>>2);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode temp = headA;
        while (temp != null) {
            visited.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (visited.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (null != pA && null != pB && !pA.equals(pB)) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }


    /**
     * 会超时
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while ((null == pA || null == pB) || !pA.equals(pB)) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    /**
     * 此方式暂时验证不了 ，因为  pA != pB  这个方式判断两个对象是否相等，返回的是false
     * @return
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }


    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ListNode listNode = (ListNode) o;
            return val == listNode.val;
        }

        @Override
        public int hashCode() {
            return Objects.hash(val);
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("ListNode{");
            sb.append("val=").append(val);
            sb.append('}');
            return sb.toString();
        }
    }

}
