package y23.m9.d26;
/**
 给定一个已排序的链表的头head ，删除原始链表中所有重复数字的节点，只留下不同的数字。返回 已排序的链表。



 示例 1：

 输入：head = [1,2,3,3,4,4,5]
 输出：[1,2,5]


 示例 2：

 输入：head = [1,1,1,2,3]
 输出：[2,3]




 提示：


 链表中节点数目在范围 [0, 300] 内
 -100 <= Node.val <= 100
 题目数据保证链表已经按升序 排列


 */
/*
https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/?envType=study-plan-v2&envId=top-interview-150
*/



class Solutionp6 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode root=new ListNode(-10000);
        root.next=head;
        ListNode first=root;
        ListNode second=first.next;
        ListNode third=second;
        while (first!=null){
            int n=0;
            while (third!=null&&third.val==second.val){
                third=third.next;
                n++;
            }
            if (n>1){
                first.next=third;
            }else {
                first=second;
            }
            if (first!=null){
                second=first.next;
                third=second;
            }
        }
        return root.next;
    }
}