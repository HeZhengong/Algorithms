package com.company.LinkedList;

public class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result=new ListNode(0);
        ListNode cur=result;
        int extra=0;
        while(l1!=null||l2!=null){
            int resultPos=extra;
            if(l1!=null){
                resultPos=resultPos+l1.value;
                l1=l1.next;
            }
            if(l2!=null){
                resultPos=resultPos+l2.value;
                l2=l2.next;
            }
            cur.next=new ListNode(resultPos%10);
            extra=resultPos/10;
            cur=cur.next;
        }
        if(extra==1){
            ListNode extraPos=new ListNode(1);
            cur.next=extraPos;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(9);
        ListNode l2=new ListNode(8);
        ListNode l3=new ListNode(1);
        ListNode l4=new ListNode(1);
        l1.next=l2;
        l3.next=l4;
        AddTwoNumber solution = new AddTwoNumber();
        ListNode result=solution.addTwoNumbers(l1,l3);
        while(result!=null){
            System.out.println(result.value);
            result=result.next;
        }
    }
}
