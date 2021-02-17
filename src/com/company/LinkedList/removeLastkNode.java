package com.company.LinkedList;

public class removeLastkNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null){
            return null;
        }
        ListNode dummyNode=new ListNode(0);
        ListNode cur=dummyNode;
        int length=findLength(head);
        int pos=length-n;
        for(int i=0; i<pos;i++){
            cur.next=head;
            head=head.next;
            cur=cur.next;
        }
        cur.next=head.next;
        return dummyNode.next;
    }

    public int findLength(ListNode head){
        int length=0;
        while(head!=null){
            head=head.next;
            length++;
        }
        return length;
    }

    public static void main(String[] args) {
        removeLastkNode s=new removeLastkNode();
        ListNode L1=new ListNode(1);
        ListNode L2=new ListNode(2);
        ListNode L3=new ListNode(3);
        ListNode L4=new ListNode(4);
        ListNode L5=new ListNode(5);

        L1.next=L2;
        L2.next=L3;
        L3.next=L4;
        L4.next=L5;
        ListNode result=s.removeNthFromEnd(L1,1);
        while(result!=null){
            System.out.println(result.value);
            result=result.next;
        }
    }
}
