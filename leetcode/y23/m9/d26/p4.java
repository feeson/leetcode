package y23.m9.d26;
/**
 给你链表的头节点 head ，每k个节点一组进行翻转，请你返回修改后的链表。

 k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。

 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。



 示例 1：

 输入：head = [1,2,3,4,5], k = 2
 输出：[2,1,4,3,5]


 示例 2：



 输入：head = [1,2,3,4,5], k = 3
 输出：[3,2,1,4,5]



 提示：


 链表中的节点数目为 n
 1 <= k <= n <= 5000
 0 <= Node.val <= 1000




 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？




 */
/*
https://leetcode.cn/problems/reverse-nodes-in-k-group/?envType=study-plan-v2&envId=top-interview-150
*/


class Solutionp4 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k==1)
            return head;
        ListNode root=new ListNode(0);
        root.next=head;
        ListNode first=root;
        ListNode second=first.next;
        ListNode third=second.next;
        loop:
        for (;;){
            ListNode next=second;
            for (int i=0;i<k;++i){
                if (next==null){
                    break loop;
                }
                next=next.next;
            }
            ListNode hh=first;
            ListNode ee=second;
            for (int i=0;i<k;++i){
                second.next=first;
                first=second;
                second=third;
                if (third!=null)
                    third=third.next;
            }
            hh.next=first;
            ee.next=second;
            first=ee;
        }
        return root.next;
    }

//    public static void main(String[] args) {
//        Solution solution=new Solution();
//        ListNode listNode = solution.reverseKGroup(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2);
//        System.out.println();
//    }
}
