package y23.m9.d10;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.concurrent.locks.ReentrantLock;

/**
 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。

 请你将两个数相加，并以相同形式返回一个表示和的链表。

 你可以假设除了数字 0 之外，这两个数都不会以 0开头。



 示例 1：

 输入：l1 = [2,4,3], l2 = [5,6,4]
 输出：[7,0,8]
 解释：342 + 465 = 807.


 示例 2：

 输入：l1 = [0], l2 = [0]
 输出：[0]


 示例 3：

 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 输出：[8,9,9,9,0,0,0,1]




 提示：


 每个链表中的节点数在范围 [1, 100] 内
 0 <= Node.val <= 9
 题目数据保证列表表示的数字不含前导零


 */
/*
https://leetcode.cn/problems/add-two-numbers/
*/
class Solutionp2 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> deque1=new ArrayDeque<>();
        Deque<Integer> deque2=new ArrayDeque<>();
        ListNode next=l1;
        while (next!=null){
            deque1.addLast(next.val);
            next=next.next;
        }
        next=l2;
        while (next!=null){
            deque2.addLast(next.val);
            next=next.next;
        }
        ListNode res=new ListNode();
        ListNode tNode=res;
        int processor=0;
        while (!deque1.isEmpty()||!deque2.isEmpty()){
            if (deque1.isEmpty()){
                int t=processor+deque2.pollFirst();
                tNode.val=t%10;
                processor=t/10;
            }else if (deque2.isEmpty()){
                int t=processor+deque1.pollFirst();
                tNode.val=t%10;
                processor=t/10;
            }else{
                int t=processor+deque1.pollFirst()+deque2.pollFirst();
                tNode.val=t%10;
                processor=t/10;
            }
            if (!deque1.isEmpty()||!deque2.isEmpty()){
                ListNode nextNode=new ListNode();
                tNode.next=nextNode;
                tNode=nextNode;
            }
        }
        if (processor!=0){
            ListNode nextNode=new ListNode();
            tNode.next=nextNode;
            nextNode.val=processor;
        }
        return res;
    }
}