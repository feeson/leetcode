package y24.m9.txmusic.p2;

import java.util.*;

class ListNode {
    int val;
    ListNode next = null;
    public ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param a ListNode类
     * @param b ListNode类
     * @return ListNode类
     */
    public ListNode mergeList (ListNode a, ListNode b) {
        // write code here
        ListNode head = a;
        ArrayList<ListNode> alist = new ArrayList<>();
        ArrayList<ListNode> blist = new ArrayList<>();
        while (a != null){
            alist.add(a);
            a = a.next;
        }
        while (b != null){
            blist.add(b);
            b = b.next;
        }
        int preCommon = 0;
        while (true){
            if (alist.get(preCommon).val == blist.get(preCommon).val)
                preCommon++;
            else
                break;
        }
        int lastCommon = 0;
        while (true){
            if (alist.get(alist.size() - 1 - lastCommon).val == blist.get(blist.size() - 1 - lastCommon).val){
                lastCommon++;
            }else
                break;
        }
        alist.get(preCommon - 1).next = alist.get(alist.size() - lastCommon);
        return head;
    }
}