package y23.m9.d18;
/**
 给定一个单链表 L 的头节点 head ，单链表 L 表示为：

 L0 → L1 → … → Ln - 1 → Ln


 请将其重新排列后变为：

 L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …

 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。



 示例 1：



 输入：head = [1,2,3,4]
 输出：[1,4,2,3]

 示例 2：



 输入：head = [1,2,3,4,5]
 输出：[1,5,2,4,3]



 提示：


 链表的长度范围为 [1, 5 * 104]
 1 <= node.val <= 1000


 */
/*
https://leetcode.cn/problems/reorder-list/description/?envType=daily-question&envId=2023-09-18
*/
class Solutionp8 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public void reorderList(ListNode head) {
        int len=0;
        ListNode t=head;
        while (t!=null){
            t=t.next;
            len++;
        }
        ListNode[] arr=new ListNode[len/2+1];
        int lenD2=len/2;
        for (int i=0;i<len;++i){
            if (i<=lenD2){
                arr[i]=head;
                head=head.next;
            } else{
                int offset=len-i-1;
                arr[offset].next=head;
                t=head.next;
                head.next=arr[offset+1];
                head=t;
            }
        }
        arr[lenD2].next=null;
    }
}