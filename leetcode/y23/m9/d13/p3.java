package y23.m9.d13;
/**
 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。



 示例 1：

 输入：head = [1,2,3,4]
 输出：[2,1,4,3]


 示例 2：

 输入：head = []
 输出：[]


 示例 3：

 输入：head = [1]
 输出：[1]




 提示：


 链表中节点的数目在范围 [0, 100] 内
 0 <= Node.val <= 100


 */
/*
https://leetcode.cn/problems/swap-nodes-in-pairs/?envType=daily-question&envId=2023-09-13
*/
class Solutionp3 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapPairs(ListNode head) {
        if (head==null||head.next==null)return head;
        ListNode root= new ListNode(0, head);
        ListNode h=root,m=root.next,n=root.next.next;


        while (n!=null){
            h.next=n;
            m.next=n.next;
            n.next=m;

            if (m.next==null)return root.next;
            h=m;
            m=m.next;
            if (m.next==null)return root.next;
            n=m.next;
        }
        return root.next;
    }
}
