package com.company.LinkedList;

public class ReverseInPairs {
    public ListNode reverseInPairs(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode newHead=head.next;
        head.next=reverseInPairs(newHead.next);
        newHead.next=head;
        return newHead;
    }
    public ListNode reverseInPairs1(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode first = cur.next, second = cur.next.next;
            cur.next = second;
            first.next = second.next;
            cur.next.next = first; // second.next = first?
            cur = cur.next.next;
        }
        return dummy.next;
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
        ReverseInPairs solution=new ReverseInPairs();
        ListNode result=solution.reverseInPairs(L1);
        while(result!=null){
            System.out.println(result.value);
            result=result.next;
        }
    }
}
