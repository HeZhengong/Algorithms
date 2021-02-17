package com.company.StackAndQueue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class StackByQueueLinked {
    private LinkedList<Integer> q1;
    private LinkedList<Integer> q2;
    private int top;
    public StackByQueueLinked() {
        q1=new LinkedList<>();
        q2=new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q1.offer(x);
        top=x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public void pop() {
        while(q1.size()>1){
            top=q1.pop();
            q2.push(top);
        }
        q1.poll();
        LinkedList<Integer> temp=q1;
        q1=q2;
        q2=temp;
    }

    /** Get the top element. */
    public Integer top() {
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean isEmpty() {
        return q1.isEmpty();
    }
}
