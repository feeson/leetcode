package y23.m9.d26;


/**
 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动k个位置。



 示例 1：

 输入：head = [1,2,3,4,5], k = 2
 输出：[4,5,1,2,3]


 示例 2：

 输入：head = [0,1,2], k = 4
 输出：[2,0,1]




 提示：


 链表中节点的数目在范围 [0, 500] 内
 -100 <= Node.val <= 100
 0 <= k <= 2 * 109


 */
/*
https://leetcode.cn/problems/rotate-list/description/?envType=study-plan-v2&envId=top-interview-150
*/



class Solutionp7 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null)
            return head;
        ListNode root=new ListNode(0);
        root.next=head;
        ListNode next=head;
        int n=0;
        while (next!=null){
            n++;
            next=next.next;
        }
        k=k%n;
        ListNode first=root;
        ListNode second=root.next;
        ListNode third=second;
        for (int i=0;i<k;++i)
            third=third.next;
        while (third.next!=null){
            third=third.next;
            second=second.next;
        }
        third.next=root.next;
        first.next=second.next;
        second.next=null;
        return root.next;
    }

//    public static void main(String[] args) {
//        Solution solution=new Solution();
//        ListNode listNode = solution.rotateRight(new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5))))),2);
//        System.out.println();
//    }
}