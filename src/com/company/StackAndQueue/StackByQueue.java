package com.company.StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class StackByQueue {
    private Queue<Integer> q1;
    private Queue<Integer> q2;
    public StackByQueue() {
        q1=new ArrayDeque<>();
        q2=new ArrayDeque<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q1.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public Integer pop() {
        Integer prev=q1.poll();
        Integer cur=q1.poll();
        while(cur!=null){
            q2.offer(prev);
            prev=cur;
            cur=q1.poll();
        }
        Queue<Integer> temp=q1;
        q1=q2;
        q2=temp;
        return prev;
    }

    /** Get the top element. */
    public Integer top() {
        Integer topElement=pop();
        if(topElement!=null){
            q1.offer(topElement);
        }
        return topElement;
    }

    /** Returns whether the stack is empty. */
    public boolean isEmpty() {
        return top()==null;
    }
}
