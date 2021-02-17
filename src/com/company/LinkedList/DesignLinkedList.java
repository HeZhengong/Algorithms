package com.company.LinkedList;

public class DesignLinkedList {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
//        System.out.println(linkedList);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
        linkedList.get(1);            // returns 2
        linkedList.deleteAtIndex(1);  // now the linked list is 1->3
        linkedList.get(1);
    }
}
class MyLinkedList {
    private ListNode head;
//    private int firstIndex=0;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        ListNode head;
        int firstIndex=0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        int firstIndex=0;
        ListNode cur=head;
        while(cur!=null){
            if(firstIndex!=index){
                firstIndex++;
                cur=cur.next;
            }
            else{
                return cur.value;
            }
        }
        return -1;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode newNode=new ListNode(val);
        newNode.next=head;
        head=newNode;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode newNode=new ListNode(val);
        while(head.next!=null){
            head=head.next;
        }
        head.next=newNode;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        int firstIndex=0;
        ListNode newNode=new ListNode(val);
        ListNode cur=head;
        if(val==0){
            ListNode newHead=newNode;
            newNode.next=head;
            head=newHead;
        }
        while(cur!=null){
            if((firstIndex+1)!=index){
                cur=cur.next;
                firstIndex++;
            }
            else{
                newNode.next=cur.next;
                cur.next=newNode;
                cur=cur.next;
                firstIndex++;
            }
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        int firstIndex=0;
        ListNode cur=head;
        if(index==0){
            head=head.next;
        }
        while(cur!=null&&cur.next!=null){
            if((firstIndex+1)!=index){
                cur=cur.next;
                firstIndex++;
            }
            else{
                cur.next=cur.next.next;
                cur=cur.next;
            }

        }
    }
}