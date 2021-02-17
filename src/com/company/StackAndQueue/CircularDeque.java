package com.company.StackAndQueue;

public class CircularDeque {
    private int[] DequeArray;
    private int head;
    private int tail;
    private int size;

    public CircularDeque(int k) {
        DequeArray=new int[k+1];
        head=0;
        tail=0;
        this.size=DequeArray.length;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }
        head=(head-1+size)%size;
        DequeArray[head]=value;
//        head=(head-1+size)%size;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }
        DequeArray[tail]=value;
        tail=(tail+1)%size;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty()) {
            return false;
        }
        head = (head + 1) % size;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }
        tail=(tail-1+size)%size;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(isEmpty()) {
            return -1;
        }
        return DequeArray[head];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(isEmpty()) {
            return -1;
        }
        return DequeArray[(tail - 1+size) % size];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return head==tail;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return (tail+1)%size==head;
    }

    public static void main(String[] args) {
        CircularDeque circularDeque = new CircularDeque(3); // set the size to be 3
        circularDeque.insertLast(1);            // return true
        circularDeque.insertLast(2);            // return true
        circularDeque.insertFront(3);            // return true
        circularDeque.insertFront(4);            // return false, the queue is full
        circularDeque.getRear();              // return 2
        circularDeque.isFull();                // return true
        circularDeque.deleteLast();            // return true
        circularDeque.insertFront(4);            // return true
        circularDeque.getFront();            // return 4
    }
}
