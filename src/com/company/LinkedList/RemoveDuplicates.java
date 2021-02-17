package com.company.LinkedList;

public class RemoveDuplicates {
//    public ListNode removeDup(ListNode head) {
//        if(head==null||head.next==null){
//            return head;
//        }
//        ListNode dummyNode=new ListNode(0);
//        ListNode cur=dummyNode;
//        ListNode slow=head;
//        ListNode quick=head.next;
//        while(slow.next!=null||slow==null){
//
//            while(quick.next!=null||quick==null){
//
//                if(slow.value==quick.value){
//                    slow=slow.next;
//                }
//                quick=quick.next;
//            }
//            cur.next=slow;
//            if(cur.next.next.next==null&&cur.next.value==cur.next.next.value){
//                cur.next=slow.next;
//            }
//            slow=slow.next;
//            cur=cur.next;
//            quick=slow.next;
//        }
//        return dummyNode.next;
//    }
    public ListNode removeDup(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode prev = head;
        ListNode curr = head.next;
        while(curr != null){
            if(prev.value != curr.value){
                prev = prev.next;
                curr = curr.next;
            }
            else{
                prev.next = curr.next;
                curr = curr.next;
            }
        }
        return head;
    }
    public ListNode removeDup1(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode dummyNode=new ListNode(0);
        ListNode p=dummyNode;
        ListNode pre=null;
        ListNode slow=head;
        ListNode fast=head.next;
        while(slow!=null) {
            if ((pre == null || pre.value != slow.value) && (fast == null || fast.value != slow.value)) {
                p.next = slow;
                p = p.next;
            }
            pre = slow;
            slow = fast;
            if (fast != null) {
                fast = fast.next;
            }
        }
        p.next=null;
        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode L1=new ListNode(1);
        ListNode L2=new ListNode(2);
        ListNode L3=new ListNode(3);
        ListNode L4=new ListNode(4);
        ListNode L5=new ListNode(5);
        ListNode L6=new ListNode(5);
        ListNode L7=new ListNode(5);
        L1.next=L2;
        L2.next=L3;
        L3.next=L4;
        L4.next=L5;
        L5.next=L6;
        L6.next=L7;
        RemoveDuplicates solution=new RemoveDuplicates();
        ListNode result=solution.removeDup1(L1);
        while(result!=null){
            System.out.println(result.value);
            result=result.next;
        }
    }
}
