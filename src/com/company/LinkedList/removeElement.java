package com.company.LinkedList;

public class removeElement {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode=new ListNode(0);
        ListNode cur=dummyNode;
        while(head!=null){
            if(head.value!=val){
                cur.next=head;
                head=head.next;
                cur=cur.next;
            }
            else{
                head=head.next;
                cur.next=head;
            }
        }
        return dummyNode.next;
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
        removeElement solution=new removeElement();
        ListNode result=solution.removeElements(L1,3);
        while(result!=null){
            System.out.println(result.value);
            result=result.next;
        }
    }
}
