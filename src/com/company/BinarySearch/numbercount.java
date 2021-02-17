package com.company.BinarySearch;

public class numbercount {
    public int search(int[] nums, int target){
        int first=0;
        int last=nums.length-1;
        if(nums.length==0||nums==null){
            return 0;
        }
        else{
            first=FindFirst(nums,target);
            last=FindLast(nums,target);
        }
        int count=last-first+1;
        return count;
    }

    private int FindLast(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<right-1){
            int mid=left+(right-left)/2;
            if(nums[mid]<target){
                left=mid+1;
            }
            else if(nums[mid]==target){
                left=mid;
            }
            else{
                right=mid-1;
            }
        }
        if(nums[right]==target){
            return right;
        }
        else if(nums[left]==target){
            return left;
        }
        else{
            return 0;
        }
    }

    private int FindFirst(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<right-1){
            int mid=left+(right-left)/2;
            if(nums[mid]<target){
                left=mid+1;
            }
            else if(nums[mid]==target){
                right=mid;
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
        }
        else{
            return 1;
        }
    }


    public static void main(String[] args) {
        numbercount s=new numbercount();
        int []nums={5,7,7,8,8,10};
        int result=s.search(nums,8);
        System.out.println(result);
    }
}
