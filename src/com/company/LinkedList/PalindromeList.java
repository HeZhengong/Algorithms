package com.company.LinkedList;

public class PalindromeList {
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null){
            return true;
        }
        ListNode mid=middleNode(head);
        ListNode midNext=mid.next;
        mid.next=null;
        ListNode reverseHead=reverse(midNext);
        while(reverseHead!=null){
            if(head.value!=reverseHead.value){
                return false;
            }
            head=head.next;
            reverseHead=reverseHead.next;
        }
        return true;
    }
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
    public static void main(String[] args) {
        ListNode L1=new ListNode(1);
        ListNode L2=new ListNode(2);
        ListNode L3=new ListNode(3);
        ListNode L4=new ListNode(2);
        ListNode L5=new ListNode(1);
//        ListNode L6=new ListNode(11);
//        ListNode L7=new ListNode(15);
        L1.next=L2;
        L2.next=L3;
        L3.next=L4;
        L4.next=L5;
        PalindromeList solution=new PalindromeList();
        boolean result=solution.isPalindrome(L1);
        System.out.println(result);
    }

}
