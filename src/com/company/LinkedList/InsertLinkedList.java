package com.company.LinkedList;

import java.lang.annotation.Target;

public class InsertLinkedList {
    public ListNode insert(ListNode head, int value) {
        ListNode newHead=new ListNode(value);
        if(head==null||value<head.value){
            newHead.next=head;
            return newHead;
        }
        ListNode cur=head;
        while(cur.next!=null&&cur.next.value<value){
            cur=cur.next;
        }
        newHead.next=cur.next;
        cur.next=newHead;
        return head;
    }

    public static void main(String[] args) {
        ListNode L1=new ListNode(1);
        ListNode L2=new ListNode(3);
        ListNode L3=new ListNode(3);
        ListNode L4=new ListNode(3);
        ListNode L5=new ListNode(8);
        ListNode L6=new ListNode(11);
        ListNode L7=new ListNode(15);
        L1.next=L2;
        L2.next=L3;
        L3.next=L4;
        L4.next=L5;
        L5.next=L6;
        L6.next=L7;
        InsertLinkedList solution=new InsertLinkedList();
        ListNode result=solution.insert(L1,16);
        while(result!=null){
            System.out.println(result.value);
            result=result.next;
        }
    }

}
