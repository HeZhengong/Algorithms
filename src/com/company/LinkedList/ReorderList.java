package com.company.LinkedList;

public class ReorderList {
    public ListNode reorder(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode mid=middleNode(head);
        ListNode normalHead=head;
        ListNode newHead=mid.next;
        mid.next=null;   //break the connection between the last listnodes of two lists. IMPORTANT!
        ListNode reverseHead=reverse(newHead);
        return merge(normalHead,reverseHead);
    }

    public ListNode merge(ListNode l1, ListNode l2){
        ListNode dummyNode=new ListNode(0);
        ListNode cur=dummyNode;
        while(l1!=null&&l2!=null){
            cur.next=l1;
            l1=l1.next;
            cur.next.next=l2;
            l2=l2.next;
            cur=cur.next.next;
        }
        if(l1==null){
            cur.next=l2;
        }
        else{
            cur.next=l1;
        }
        return dummyNode.next;
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

    public static void main(String[] args) {
        ListNode L1=new ListNode(1);
        ListNode L2=new ListNode(3);
        ListNode L3=new ListNode(4);
        ListNode L4=new ListNode(5);
        ListNode L5=new ListNode(8);
        ListNode L6=new ListNode(11);
        ListNode L7=new ListNode(15);
        L1.next=L2;
        L2.next=L3;
        L3.next=L4;
        L4.next=L5;
        L5.next=L6;
        L6.next=L7;
        ReorderList solution=new ReorderList();
        ListNode result=solution.reorder(L1);
        while(result!=null){
            System.out.println(result.value);
            result=result.next;
        }
    }
}
