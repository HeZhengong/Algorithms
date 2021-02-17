package com.company.StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class StackWithMin {
    private Deque<Integer> stack;
    private Deque<Integer> minStack;
    public StackWithMin(){
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public int pop() {
        if(stack.isEmpty()) {
            return -1;
        }
        Integer result=stack.pollFirst();
        if(minStack.peekFirst().equals(result)){
            minStack.pollFirst();
        }
        return result;
    }

    public void push(int element) {
        stack.offerFirst(element);
        if(minStack.isEmpty()||element<=minStack.peekFirst()){
            minStack.offerFirst(element);
        }
    }

    public int top() {
        if(stack.isEmpty()){
            return -1;
        }
        return stack.peek();
    }

    public int min() {
        if(minStack.isEmpty()) {
            return -1;
        }
        return minStack.peekFirst();
    }
}
