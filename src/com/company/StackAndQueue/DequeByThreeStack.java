package com.company.StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeByThreeStack {
    private Deque<Integer> left;
    private Deque<Integer> right;
    private Deque<Integer> buffer;
    public DequeByThreeStack() {
        left=new ArrayDeque<>();
        right=new ArrayDeque<>();
        buffer=new ArrayDeque<>();
    }

    public void offerFirst(int element) {
        left.offerFirst(element);
    }

    public void offerLast(int element) {
        right.offerFirst(element);
    }

    public Integer pollFirst() {
        move(right,left);
        return left.isEmpty()?null:left.pollFirst();
    }

    public Integer pollLast() {
        move(left,right);
        return right.isEmpty()?null:right.pollFirst();
    }

    public Integer peekFirst() {
        move(right,left);
        return left.isEmpty()?null:left.peekFirst();
    }

    public Integer peekLast() {
        move(left,right);
        return right.isEmpty()?null:right.peekFirst();
    }

    private void move(Deque<Integer> right, Deque<Integer> left) {
        if(!left.isEmpty()){
            return;
        }
        int halfSize=right.size()/2;
        for(int i=0;i<halfSize;i++){
            buffer.offerFirst(right.pollFirst());
        }
        while(!right.isEmpty()){
            left.offerFirst(right.pollFirst());
        }
        while(!buffer.isEmpty()){
            right.offerFirst(buffer.pollFirst());
        }
    }

    public int size() {
        return left.size()+right.size();
    }

    public boolean isEmpty() {
        return left.isEmpty()&&right.isEmpty();
    }
}
