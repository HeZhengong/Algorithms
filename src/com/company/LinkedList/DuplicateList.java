package com.company.LinkedList;

public class DuplicateList {
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null){
            return false;
        }
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ListNode L1=new ListNode(1);
        ListNode L2=new ListNode(2);
        ListNode L3=new ListNode(3);
        ListNode L4=new ListNode(1);
        L1.next=L2;
        L2.next=L3;
        L3.next=L4;
        DuplicateList solution=new DuplicateList();
        Boolean result=solution.hasCycle(L1);
        System.out.println(result);
    }
}
