package com.company.leetcode;

import com.company.HeapAndBFS.KthSmallest;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestInArray {
    public int findKthLargest(int[] nums, int k) {
        int result=0;
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1==o2){
                    return 0;
                }
                return o1>o2?-1:1;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            maxHeap.offer(nums[i]);
        }
        for (int i = 0; i < k; i++) {
            result=maxHeap.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        KthLargestInArray s=new KthLargestInArray();
        int nums[]={3,2,1,5,6,4};
        int result=s.findKthLargest(nums,2);
        System.out.println(result);
    }
}
