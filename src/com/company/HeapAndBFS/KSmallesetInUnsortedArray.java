package com.company.HeapAndBFS;

import java.util.Comparator;
import java.util.PriorityQueue;
public class KSmallesetInUnsortedArray {
    public int[] kSmallest(int[] array, int k) {
        if(array==null||k==0){
            return new int[0];
        }
        PriorityQueue<Integer> minHeap=new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1==o2){
                    return 0;
                }
                return o1>o2?1:-1;
            }
        });
        for (int i = 0; i < array.length; i++) {
            minHeap.offer(array[i]);
        }
        int[] result=new int[k];
        for (int i = 0; i < k; i++) {
            result[i]=minHeap.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        KSmallesetInUnsortedArray s=new KSmallesetInUnsortedArray();
        int[] array={3,5,4,1,2};
        int[] result=s.kSmallest(array,3);
        for (int i = 0; i <result.length ; i++) {
            System.out.println(result[i]);
        }
    }
}
