package com.company.CrossTrainingI;

import java.util.ArrayDeque;
import java.util.Deque;

public class dedupIV {
    public int[] dedup(int[] array) {
        if(array.length<=1){
            return array;
        }
        Deque<Integer> stack=new ArrayDeque<>();
        stack.offerFirst(array[0]);
        int count=0;
        for (int i = 1; i < array.length; i++) {
            if(array[i]==stack.peekFirst()){
                if(i!=array.length-1) {
                    count++;
                }
                else{
                    stack.pollFirst();
                }
            }
            else{
                if(count!=0){
                    if(stack.peekFirst()==array[i]){
                        if(i!=array.length-1) {
                            count++;
                        }
                        else{
                            stack.pollFirst();
                        }
                    }
                    else{
                        stack.pollFirst();
                        if(stack.isEmpty()||stack.peekFirst()!=array[i]) {
                            stack.offerFirst(array[i]);
                            count = 0;
                        }
                        else{
                            count = 1;
                        }
                    }
                }
                else{
                    stack.offerFirst(array[i]);
                }
            }
        }

        int[] result=new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.pollLast();
        }
        return result;
    }


    public static void main(String[] args) {
        dedupIV s=new dedupIV();
        int[] test={1,2,3,3,3,2,2,3};
        int[]result=s.dedup(test);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
