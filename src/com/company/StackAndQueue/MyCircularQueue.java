package com.company.StackAndQueue;

import com.company.LinkedList.PalindromeList;

public class MyCircularQueue {
    private ListNode head;
    private ListNode tail;
    private int capacity;
    private int count;
    public MyCircularQueue(int k) {
        this.capacity=k;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(this.count==this.capacity){
            return false;
        }
        ListNode newNode=new ListNode(value);
        if(this.count==0){
            head=tail=newNode;
        }
        else{
            tail.next=newNode;
            tail=newNode;
        }
        this.count+=1;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(this.count==0){
            return false;
        }
        this.head=this.head.next;
        this.count-=1;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(this.count==0){
            return -1;
        }
        else{
            return this.head.value;
        }
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(this.count==0){
            return -1;
        }
        else{
            return this.tail.value;
        }
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return (this.count==0);
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (this.count==capacity);
    }
}
