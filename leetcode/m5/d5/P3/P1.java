package y24.m5.d5.P3;

import java.util.ArrayDeque;

/**
 * Definition for singly-linked list.
 *
 *
 *
 *
 *
 *
 *
 */
class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode removeNodes(ListNode head) {
        ArrayDeque<ListNode> deque = new ArrayDeque<>();
        deque.addLast(head);
        head = head.next;
        while (head != null){
            while (!deque.isEmpty() && deque.peekLast().val < head.val)
                deque.pollLast();
            deque.addLast(head);
            head = head.next;
        }
        ListNode root = deque.pollFirst();
        root.next = null;
        head = root;
        while (!deque.isEmpty()){
            ListNode nxt = deque.pollFirst();
            nxt.next = null;
            head.next = nxt;
            head = nxt;
        }
        return root;
    }
}