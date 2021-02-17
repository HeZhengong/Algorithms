package com.company.BinarySearch;

public class searchRotateArray {
    public int search(int[] nums, int target) {
        if(nums.length==0){
            return -1;
        }
        int left=0;
        int right=nums.length-1;
        while(left<right-1){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>nums[0]){
                if(target<nums[mid]&&target>=nums[left]){
                    right=mid-1;
                }
                else{
                    left=mid;
                }
            }
            else{
                if(target>nums[mid]&&target<=nums[right]){
                    left=mid+1;
                }
                else{
                    right=mid;
                }
            }
        }
        if(nums[left]==target){
            return left;
        }
        else if(nums[right]==target){
            return right;
        }
        else {
            return -1;
        }
    }

    public static void main(String[] args) {
        searchRotateArray s=new searchRotateArray();
        int []array={3,1,3,3};
        int result=s.search(array,3);
        System.out.println(result);
    }
}
