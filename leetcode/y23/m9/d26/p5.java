package y23.m9.d26;
/**
 给你一个链表，删除链表的倒数第n个结点，并且返回链表的头结点。



 示例 1：

 输入：head = [1,2,3,4,5], n = 2
 输出：[1,2,3,5]


 示例 2：

 输入：head = [1], n = 1
 输出：[]


 示例 3：

 输入：head = [1,2], n = 1
 输出：[1]




 提示：


 链表中结点的数目为 sz
 1 <= sz <= 30
 0 <= Node.val <= 100
 1 <= n <= sz




 进阶：你能尝试使用一趟扫描实现吗？

 */
/*
https://leetcode.cn/problems/remove-nth-node-from-end-of-list/?envType=study-plan-v2&envId=top-interview-150
*/



class Solutionp5 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode root=new ListNode(0);
        root.next=head;
        ListNode first=root;
        ListNode second=first.next;
        ListNode third=second;
        for (int i=0;i<n;++i)
            third=third.next;
        while (third!=null){
            first=first.next;
            second=second.next;
            third=third.next;
        }
        first.next=second.next;
        return root.next;

    }
}