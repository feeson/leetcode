package y24.m5.d5.gcd;

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
    int gcd(int u,int v){
        if (u < v){
            u = u^v;
            v = u^v;
            u= u^v;
        }
        return v == 0 ? u : gcd(v,u % v);
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode root = head;
        ListNode first = head;
        ListNode second = head.next;
        while (second != null){
            ListNode nxt = second.next;

            int val = gcd(first.val, second.val);
            ListNode node = new ListNode(val);
            first.next = node;
            node.next = second;
            first = second;
            second = nxt;
        }
        return root;
    }
}