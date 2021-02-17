package com.company.LinkedList;

public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode slow=head;
        ListNode quick=head;
        while(quick.next!=null&&quick.next.next!=null){
                slow=slow.next;
                quick=quick.next.next;
        }
        return slow;
    }
    public static void main(String[] args) {
        ListNode L1=new ListNode(1);
        ListNode L2=new ListNode(2);
        ListNode L3=new ListNode(3);
        L1.next=L2;
        L2.next=L3;
        MiddleNode solution=new MiddleNode();
        ListNode result=solution.middleNode(L1);
        System.out.println(result.value);
    }
}
