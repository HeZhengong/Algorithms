package com.company.LinkedList;


import java.util.LinkedList;

public class ReverseListNode {
    public ListNode reverse(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode prev=null;
        while(head!=null){
            ListNode next=head.next;
            head.next=prev;
            prev=head;
            head=next;
        }
        return prev;
    }
    public ListNode reverse1(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode newHead=reverse(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode L1=new ListNode(1);
        ListNode L2=new ListNode(2);
        ListNode L3=new ListNode(3);
        L1.next=L2;
        L2.next=L3;
        ReverseListNode solution=new ReverseListNode();
        ListNode head=solution.reverse(L1);
        while(head!=null){
            System.out.println(head.value);
            head=head.next;
        }
    }

}
