package com.company.BinarySearch;

public class FindMissingNumber {
    public static int missingNumber(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(mid!=nums[mid]){
                right=mid;
            }
            else{
                left=mid+1;
            }
        }
        return left;

    }

    public static void main(String[] args) {
        int []a={0,1,3};
        int result=missingNumber(a);
        System.out.println(result);
    }
}
