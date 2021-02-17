package com.company.Final;


import java.util.ArrayDeque;
import java.util.Deque;

public class Dinner {
//        class dinner{
//            public boolean dinner(String[] input){
//                char[] record=new char[input.length*2];
//                for (int i = 0; i < input.length; i++) {
//                    String string=input[i];
//                    char[] arr=string.toCharArray;
//                    record[i*2+0]=arr[0];
//                    record[i*2+1]=arr[arr.length-1];
//                }
//                return dedup(record);
//            }
//
//            private boolean dedup(char[] record) {
//                Deque<Character> stack=new ArrayDeque<>();
//                stack.offer(record[0]);
//                for(int i=1;i<record.length;i++){
//                    if(stack.peekFirst()==record[i]){
//                        stack.pollFirst();
//                    }
//                    else{
//                        stack.offerFirst(record[i]);
//                    }
//                }
//                return stack.isEmpty();
//            }
//        }
    public boolean canChain(String[] input){
        return helper(input,1);
    }

    private boolean helper(String[] input, int i) {
        if(i==input.length){
            return CanConnect(input[i-1],input[0]);
        }
        for (int j = i; j < input.length; j++) {
            if(CanConnect(input[i-1],input[j])){
                swap(input,i,j);
                if(helper(input,i+1)){
                    return true;
                }
                swap(input,i,j);
            }
        }
        return false;
    }

    private void swap(String[] input, int i, int j) {
        String tmp=input[i];
        input[i]=input[j];
        input[j]=tmp;
    }

    private boolean CanConnect(String s1, String s2) {
        return s1.charAt(s1.length()-1)==s2.charAt(0);
    }

    public static void main(String[] args) {
        Dinner s=new Dinner();
        String[] input={"alice","eason","nofe","elise","era"};
        System.out.println(s.canChain(input));
    }
}
