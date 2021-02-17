package com.company.LinkedList;

public class ReverseListtoArray {
    public int[] reversePrint(ListNode head) {
        ListNode cur=head;
        int length=0;
        while(cur!=null){
            length++;
            cur=cur.next;
        }
        int[] result=new int[length];
        cur=head;
        for(int i=length-1;i>=0;i--){
            result[i]=cur.value;
            cur=cur.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseListtoArray s=new ReverseListtoArray();

        ListNode L1=new ListNode(1);
        ListNode L2=new ListNode(2);
        ListNode L3=new ListNode(3);
        ListNode L4=new ListNode(4);
        L1.next=L2;
        L2.next=L3;
        L3.next=L4;
        int[] result=s.reversePrint(L1);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
