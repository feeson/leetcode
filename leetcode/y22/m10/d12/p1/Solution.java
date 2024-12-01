package y22.m10.d12.p1;

/**
 * 给定链表头结点 head，该链表上的每个结点都有一个 唯一的整型值 。同时给定列表 nums，该列表是上述链表中整型值的一个子集。
 *
 * 返回列表 nums 中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表 nums 中）构成的集合。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/linked-list-components
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.HashSet;
import java.util.LinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public static void main(String[] args) {
//        ListNode head=new ListNode(0,new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4)))));
//        int[] nums=new int[]{0,3,1,4};
        ListNode head=new ListNode(3,new ListNode(4,new ListNode(0,new ListNode(2,new ListNode(1)))));
        int[] nums=new int[]{4};

        System.out.println(numComponents(head,nums));
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static int numComponents(ListNode head, int[] nums) {
        HashSet<Integer> hashSet=new HashSet<>();
        for (int i=0;i<nums.length;++i){
            hashSet.add(nums[i]);
        }
        int index=1;
        int[] arr=new int[3];
        if (hashSet.contains(head.val)){
            arr[0]=1;
        }else {
            arr[0]=-1;
        }
        do {
            if (head.next!=null)
                head=head.next;
            if (hashSet.contains(head.val)){
                if (arr[(index-1)%3]>0){
                    arr[index%3]=arr[(index-1)%3];
                }else {
                    arr[index%3]=-arr[(index-1)%3]+1;
                }
            }else {
                if (arr[(index-1)%3]>0){
                    arr[index%3]=-arr[(index-1)%3]-1;
                }else {
                    arr[index%3]=arr[(index-1)%3];
                }
            }
            index++;
        }while (head.next!=null);
        int val=arr[(index-1)%3];
        if (val%2==0){
            return val/2>0?val/2:-val/2;
        }else {
            if (val>0){
                return (val+1)/2;
            }else {
                return -(val+1)/2;
            }
        }
    }
}