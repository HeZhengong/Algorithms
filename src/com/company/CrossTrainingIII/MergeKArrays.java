package com.company.CrossTrainingIII;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKArrays {
    public int[] merge(int[][] arrayOfArrays) {
        int m=arrayOfArrays.length;
        int n=arrayOfArrays[0].length;
        int[] result=new int[m*n];
        PriorityQueue<Integer> minHeap=new PriorityQueue(m, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1==o2){
                    return 0;
                }
                return o1>o2?-1:1;
            }
        });
        for (int i = 0; i < m; i++) {
            minHeap.offer(arrayOfArrays[i][0]);
        }
        return result;
    }
}
