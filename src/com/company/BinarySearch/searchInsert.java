package com.company.BinarySearch;

public class searchInsert {
    public int searchInsert(int[] input, int target) {
        if(input.length==0){
            return -1;
        }
        int left=0;
        int right=input.length-1;
        while(left<right-1){
            int mid=left+(right-left)/2;
            if(input[mid]<target){
                left=mid+1;
            }
            else if(input[mid]==target){
                right=mid;
            }
            else{
                right=mid-1;
            }
        }
        if(input[left]>=target){
            return left;
        }
        if(input[right]>=target){
            return right;
        }
        else{
            return input.length;
        }
    }

    public static void main(String[] args) {
        searchInsert s=new searchInsert();
        int []array={2,5,7,7,13};
        int result=s.searchInsert(array,7);
        System.out.println(result);
    }
}
