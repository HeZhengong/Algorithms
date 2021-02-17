package com.company.StringII;

public class SubArrayContains1s {
    public int longestConsecutiveOnes(int[] nums, int k) {
        int slow=0;
        int fast=0;
        int longest=0;
        int num_zeros=0;
        while(fast<nums.length){
            if(nums[fast]==1){
                fast++;
                longest=Math.max(fast-slow,longest);
            }
            else{
                if(num_zeros<k){
                    num_zeros++;
                    fast++;
                    longest=Math.max(fast-slow,longest);
                }
                else{
                    while(num_zeros==k) {
                        if(nums[slow]==0){
                            num_zeros--;
                        }
                        slow++;
                        longest = Math.max(longest, fast - slow + 1);
                    }
                }
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        SubArrayContains1s s=new SubArrayContains1s();
        int[] nums={1,1,1,1,0,0,1};
        System.out.println(s.longestConsecutiveOnes(nums,1));
    }
}
