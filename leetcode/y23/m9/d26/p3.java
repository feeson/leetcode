package y23.m9.d26;
/**
 给你单链表的头指针 head 和两个整数left 和 right ，其中left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。


 示例 1：

 输入：head = [1,2,3,4,5], left = 2, right = 4
 输出：[1,4,3,2,5]


 示例 2：

 输入：head = [5], left = 1, right = 1
 输出：[5]




 提示：


 链表中节点数目为 n
 1 <= n <= 500
 -500 <= Node.val <= 500
 1 <= left <= right <= n




 进阶： 你可以使用一趟扫描完成反转吗？

 */
/*
https://leetcode.cn/problems/reverse-linked-list-ii/?envType=study-plan-v2&envId=top-interview-150
*/



class Solutionp3 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (right-left==0)
            return head;
        ListNode root= new ListNode(0);
        root.next=head;
        ListNode first=root;
        ListNode second=first.next;
        for (int i=1;i<left;++i){
            first=first.next;
            second=second.next;
        }
        ListNode third=second.next;
        ListNode hh=first;
        ListNode ee=second;
        for (int i=left;i<=right;++i){
            second.next=first;
            first=second;
            second=third;
            if (third!=null)
                third=third.next;
        }
        hh.next=first;
        ee.next=second;
        return root.next;
    }

//    public static void main(String[] args) {
//        Solution solution=new Solution();
//        ListNode listNode = solution.reverseBetween(new ListNode(3,new ListNode(5) ),1,2);
//        System.out.println();
//    }
}