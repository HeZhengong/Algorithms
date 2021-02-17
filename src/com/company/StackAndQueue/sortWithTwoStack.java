package com.company.StackAndQueue;


import java.util.LinkedList;
import java.util.Stack;

public class sortWithTwoStack {
    public void sort(LinkedList<Integer> s1) {
        if(s1==null||s1.size()<=1){
            return;
        }
        LinkedList<Integer> s2 = new LinkedList<Integer>();
        sort(s1,s2);

    }

    private void sort(LinkedList<Integer> s1, LinkedList<Integer> s2) {
        while(!s1.isEmpty()){
            int curMin=Integer.MAX_VALUE;
            int count=0;
            while(!s1.isEmpty()){
                int cur=s1.pollFirst();
                if(cur<curMin){
                    curMin=cur;
                    count=1;
                }
                else if(cur==curMin){
                    count++;
                }
                s2.offerFirst(cur);
            }
            while(!s2.isEmpty()&&s2.peekFirst()>=curMin){
                int temp=s2.pollFirst();
                if(temp!=curMin){
                    s1.offerFirst(temp);
                }
            }
            while(count-->0){
                s2.offerFirst(curMin);
            }
        }
        while(!s2.isEmpty()) {
            s1.offerFirst(s2.pollFirst());
        }
    }

    public static void main(String[] args) {
        sortWithTwoStack s=new sortWithTwoStack();
        LinkedList<Integer> linkedList;
        linkedList=new LinkedList<>();
        linkedList.push(4);
        linkedList.push(3);
        linkedList.push(2);
        linkedList.push(1);
        s.sort(linkedList);
        while(!linkedList.isEmpty()) {
            System.out.println(linkedList.getFirst());
            linkedList.pop();
        }
    }
}
