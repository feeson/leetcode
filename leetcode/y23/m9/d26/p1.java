package y23.m9.d26;
/**
 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。



 示例 1：

 输入：l1 = [1,2,4], l2 = [1,3,4]
 输出：[1,1,2,3,4,4]


 示例 2：

 输入：l1 = [], l2 = []
 输出：[]


 示例 3：

 输入：l1 = [], l2 = [0]
 输出：[0]




 提示：


 两个链表的节点数目范围是 [0, 50]
 -100 <= Node.val <= 100
 l1 和 l2 均按 非递减顺序 排列


 */
/*
https://leetcode.cn/problems/merge-two-sorted-lists/?envType=study-plan-v2&envId=top-interview-150
*/


class Solutionp1 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1==null)
            return list2;
        if (list2==null)
            return list1;
        ListNode next1=list1,next2=list2;
        ListNode main= null;
        if (next1.val<next2.val){
            main=next1;
            next1=next1.next;
        }else{
            main=next2;
            next2=next2.next;
        }
        ListNode root=main;
        while (next1!=null||next2!=null){
            if (next1==null){
                main.next=next2;
                next2=next2.next;
            }else if (next2==null){
                main.next=next1;
                next1=next1.next;
            }else {
                if (next1.val<next2.val){
                    main.next=next1;
                    next1=next1.next;
                }else {
                    main.next=next2;
                    next2=next2.next;
                }
            }
            main=main.next;
        }
        return root;
    }

//    public static void main(String[] args) {
//        Solution solution=new Solution();
//        ListNode l1=new ListNode(1,new ListNode(2,new ListNode(4)));
//        ListNode l2=new ListNode(1,new ListNode(3,new ListNode(4) ));
//        ListNode listNode = solution.mergeTwoLists(l1, l2);
//        System.out.println();
//    }
}