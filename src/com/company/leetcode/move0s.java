package com.company.leetcode;

public class move0s {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if(nums[fast]!=0) {
                if (nums[slow] != 0) {
                    slow++;
                } else {
                    swap(nums, slow, fast);
                    slow++;
                }
            }
        }
    }
    public void swap(int[] nums, int slow, int fast){
        int temp=nums[slow];
        nums[slow]=nums[fast];
        nums[fast]=temp;
    }

    public static void main(String[] args) {
        move0s s=new move0s();
        int[] test={0,1,0,3,12};
        s.moveZeroes(test);
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }
    }
}
