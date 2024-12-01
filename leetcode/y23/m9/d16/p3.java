package y23.m9.d16;


import java.math.BigInteger;
import java.util.*;

class Solution {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public int[] reversePrint(ListNode head) {
        if (head==null)
            return new int[0];
        int len=0;
        Deque<Integer> deque=new ArrayDeque<>();
        while (head!=null){
            len++;
            deque.addLast(head.val);
            head=head.next;
        }
        int[]res=new int[len];
        len=0;
        while (!deque.isEmpty()){
            res[len++]=deque.pollLast();
        }
        return res;
    }
}
