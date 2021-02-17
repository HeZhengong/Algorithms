package com.company.LinkedList;

public class PartitionLinkedList {
    public ListNode partition(ListNode head, int target) {
        ListNode dummySmall=new ListNode(0);
        ListNode dummyBig=new ListNode(0);
        ListNode curSmall=dummySmall;
        ListNode curBig=dummyBig;
        while(head!=null){
            if(head.value<target){
                curSmall.next=head;
                head=head.next;
                curSmall=curSmall.next;
            }
            else{
                curBig.next=head;
                head=head.next;
                curBig=curBig.next;
            }
        }
        curSmall.next=dummyBig.next;
        curBig.next=null;
        return dummySmall.next;
    }
    public static void main(String[] args) {
        ListNode L1=new ListNode(2);
        ListNode L2=new ListNode(4);
        ListNode L3=new ListNode(3);
        ListNode L4=new ListNode(5);
        ListNode L5=new ListNode(1);
//        ListNode L6=new ListNode(11);
//        ListNode L7=new ListNode(15);
        L1.next=L2;
        L2.next=L3;
        L3.next=L4;
        L4.next=L5;
//        L5.next=L6;
//        L6.next=L7;
        PartitionLinkedList solution=new PartitionLinkedList();
        ListNode result=solution.partition(L1,3);
        while(result!=null){
            System.out.println(result.value);
            result=result.next;
        }
    }
}
