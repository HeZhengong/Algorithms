package com.company.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SumOfThreeClosest {
    public int threeSumClosest1(int[] nums, int target) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(3, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1-target)==Math.abs(o2-target)){
                    return 0;
                }
                else if(Math.abs(o1-target)>Math.abs(o2-target)){
                    return 1;
                }
                else{
                    return -1;
                }
            }
        });
        int sum=0;
        for (int i = 0; i <nums.length ; i++) {
            pq.offer(nums[i]);
        }
        for(int j=0;j<3;j++){
            sum+=pq.poll();
        }
        return sum;
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for(int i=0;i<nums.length;i++) {
            int start = i+1, end = nums.length - 1;
            while(start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if(Math.abs(target - sum) < Math.abs(target - ans))
                    ans = sum;
                if(sum > target)
                    end--;
                else if(sum < target)
                    start++;
                else
                    return ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SumOfThreeClosest s=new SumOfThreeClosest();
        int[] array={0,2,1,-3};
    }
}
