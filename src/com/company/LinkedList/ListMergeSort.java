package com.company.LinkedList;


public class ListMergeSort {
    public ListNode mergeSort(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode mid=middleNode(head);
        ListNode midNext=mid.next;
        mid.next=null;
        ListNode left=mergeSort(head);
        ListNode right=mergeSort(midNext);
        return merge(left,right);
    }
    public ListNode merge(ListNode one, ListNode two) {
        ListNode dummy=new ListNode(0);
        ListNode cur=dummy;
        ListNode oneHead=one;
        ListNode twoHead=two;
        while(oneHead!=null&&twoHead!=null){
            if(oneHead.value<twoHead.value){
                cur.next=oneHead;
                oneHead=oneHead.next;
            }else{
                cur.next=twoHead;
                twoHead=twoHead.next;
            }
            cur=cur.next;
        }
        if(oneHead==null){
            cur.next=twoHead;
        }
        if(twoHead==null){
            cur.next=oneHead;
        }
        return dummy.next;
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
        ListMergeSort solution=new ListMergeSort();
        ListNode result=solution.mergeSort(L1);
        while(result!=null){
            System.out.println(result.value);
            result=result.next;
        }
    }
}
