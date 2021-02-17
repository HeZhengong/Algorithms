package com.company.LinkedList;

public class merge {
    public ListNode merge(ListNode one, ListNode two) {
        ListNode dummy=new ListNode(0);
        ListNode cur=dummy;
        ListNode oneHead=one;
        ListNode twoHead=two;
        while(oneHead.next!=null&&twoHead.next!=null){
            if(oneHead.value<twoHead.value){
                cur.next=oneHead;
                oneHead=oneHead.next;
            }else{
                cur.next=twoHead;
                twoHead=twoHead.next;
            }
            cur=cur.next;
        }
        if(oneHead.next==null){
            cur.next=twoHead;
        }
        if(twoHead.next==null){
            cur.next=oneHead;
        }
        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
