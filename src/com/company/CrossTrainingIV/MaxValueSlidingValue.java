package com.company.CrossTrainingIV;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MaxValueSlidingValue {
    public List<Integer> maxWindows(int[] array, int k) {

        List<Integer> result=new ArrayList<>();
        if(k<=1){
            for (int i=0;i<array.length;i++) {
                result.add(array[i]);
            }
            return result;
        }
        helper(array,k,result);
        return result;
    }

    private void helper(int[] array, int k, List<Integer> result) {
        Deque<Integer> deque=new ArrayDeque<>();
        deque.offerFirst(array[0]);
        for (int i = 1; i < array.length; i++) {

            if(i>=k&&array[i-k]==deque.peekLast()){
                deque.pollLast();
            }

            if(array[i]<deque.peekFirst()) {
                deque.offerFirst(array[i]);
            }
            else{
                while(!deque.isEmpty()&&array[i]>deque.peekFirst()){
                    deque.pollFirst();
                }
                deque.offerFirst(array[i]);
            }
//            result.add(deque.peekLast());
            if(i>=k-1) {
                result.add(deque.peekLast());
            }
        }
    }

    public static void main(String[] args) {
        MaxValueSlidingValue s=new MaxValueSlidingValue();
        int[] test={2,1,3,6,2,3,2,4,1,5,2,7,6,8,1,4};
        int[] test1={1,2,3,4,5,6,7,8,9,1,1};
        List<Integer> result=s.maxWindows(test,3);
        System.out.print(result);
    }
}
