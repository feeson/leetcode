package y22.m09.d27.p1;


public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res=new ListNode(0);
        ListNode head=res;
        while (true){
            if (l1==null&&l2==null){
                break;
            }
            if ((l1==null?0:l1.val)+ (l2==null?0:l2.val)>9){
                res.next=new ListNode(1);
            }
            res.val+= ((l1==null?0: l1.val)+ (l2==null?0: l2.val))%10;
            if (res.val==10){
                res.val=0;
                if (res.next==null){
                    res.next=new ListNode(1);
                }else {
                    res.next.val+=1;
                }
            }
            if (res.next==null&&((l1==null?false:l1.next!=null)||(l2==null?false:l2.next!=null))){
                res.next=new ListNode(0);
            }
            if (res.next!=null)
                res=res.next;
            if (l1!=null)
                l1=l1.next;
            if (l2!=null)
                l2=l2.next;
        }
        return head;
    }
}
