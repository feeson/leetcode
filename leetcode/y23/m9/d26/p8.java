package y23.m9.d26;

import java.util.Spliterator;

/**
 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。

 你应当 保留 两个分区中每个节点的初始相对位置。



 示例 1：

 输入：head = [1,4,3,2,5,2], x = 3
 输出：[1,2,2,4,3,5]


 示例 2：

 输入：head = [2,1], x = 2
 输出：[1,2]




 提示：


 链表中节点的数目在范围 [0, 200] 内
 -100 <= Node.val <= 100
 -200 <= x <= 200


 */
/*
https://leetcode.cn/problems/partition-list/?envType=study-plan-v2&envId=top-interview-150
*/
class Solutionp8 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode root=new ListNode(0);
        root.next=head;
        ListNode first=root;
        ListNode second=first.next;
        while (second!=null&&second.val<x){
            second=second.next;
            first=first.next;
        }
        if (second==null)
            return head;
        ListNode third=second;
        ListNode next=third.next;
        while (next!=null){
            if (next.val<x){
                third.next=next.next;
                first.next=next;
                next.next=second;
                first=next;
                next=third;
            }
            third=next;
            next=next.next;
        }
        return root.next;
    }

//    public static void main(String[] args) {
//        Solution solution=new Solution();
//        ListNode partition = solution.partition(new ListNode(2,new ListNode(1)),5);
//        System.out.println();
//    }
}