package com.company.BinarySearch;

public class BinarySearch2 {
    public static int[] searchRange(int[] nums, int target) {
        int[] result=new int[2];
        if(nums.length==0){
            result[0]=-1;
            result[1]=-1;
        }
        else{
            result[0]=findFirst(nums,nums.length,target);
            result[1]=findLast(nums,nums.length,target);
        }


        return result;
    }

    private static int findLast(int[] nums, int length, int target) {
        int left=0;
        int right=length-1;

        while(left<right-1){
            int mid=left+(right-left)/2;
            if(target==nums[mid]){
                left=mid;
            }
            else if(target>nums[mid]){
                left=mid+1;
            }
            else {
                right = mid - 1;
            }
        }
        if(nums[right]==target){
            return right;
        }
        else if(nums[left]==target){
            return left;
        }
        else {
            return -1;
        }
    }

    private static int findFirst(int[] nums, int length, int target) {
        int left=0;
        int right=length-1;
        while(left<right-1){
            int mid=left+(right-left)/2;
            if(target==nums[mid]){
                right=mid;
            }
            else if(target>nums[mid]){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        if(nums[left]==target){
            return left;
        }
        else if(nums[right]==target){
            return right;
        }else {
            return -1;
        }
    }


    public static void main(String[] args) {
        int[] nums={-1,0,3,9,9,12};
        int target=9;
        int[] p=searchRange(nums,target);
        System.out.println(p[0]);
        System.out.println(p[1]);
    }
}
