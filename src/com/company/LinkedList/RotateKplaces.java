package com.company.LinkedList;

public class RotateKplaces {
    public ListNode rotateKplace(ListNode head, int n) {
        if (head == null || head.next == null) {
            return head;
        }

            ListNode dummyNode = new ListNode(0);
            ListNode cur = dummyNode;
            ListNode pre = new ListNode(0);
            ListNode firstPart=pre;
            ListNode curl=head;

            int ListLength = countListNode(head);
            int headPos = ListLength - n % ListLength;
            for (int i = 0; i < headPos; i++) {
                pre.next = curl;
                pre = pre.next;
                curl = curl.next;
            }
            cur.next=curl;
            pre.next = null;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = firstPart.next;
            return dummyNode.next;
    }

    public int countListNode(ListNode head) {
        int count = 1;
        while (head.next != null) {
            head = head.next;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        ListNode L1=new ListNode(1);
        ListNode L2=new ListNode(2);
        ListNode L3=new ListNode(3);
        ListNode L4=new ListNode(4);
        ListNode L5=new ListNode(5);
//        ListNode L6=new ListNode(6);
//        ListNode L7=new ListNode(7);
        L1.next=L2;
        L2.next=L3;
        L3.next=L4;
        L4.next=L5;
//        L5.next=L6;
//        L6.next=L7;
        RotateKplaces solution=new RotateKplaces();
        ListNode result=solution.rotateKplace(L1,2);
        while(result!=null){
            System.out.println(result.value);
            result=result.next;
        }
    }
}
