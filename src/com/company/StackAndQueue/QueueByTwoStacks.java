package com.company.StackAndQueue;



import java.util.LinkedList;

public class QueueByTwoStacks {
    private LinkedList<Integer> in;
    private LinkedList<Integer> out;
    public QueueByTwoStacks(){
        in=new LinkedList<>();
        out=new LinkedList<Integer>();
    }
    public Integer poll() {
        move();
        return out.isEmpty()?null:out.pollFirst();
    }

    private void move() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.offerFirst(in.pollFirst());
            }
        }
    }

    public void offer(int element) {
        in.offerFirst(element);
    }

    public Integer peek() {
        move();
        return out.isEmpty()?null:out.peekFirst();
    }

    public int size() {
        return in.size()+out.size();
    }

    public boolean isEmpty() {
        return in.size()==0&&out.size()==0;
    }
}
