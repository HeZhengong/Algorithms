package com.company.BinarySearch;

public class shiftPosition {
    public int shiftPosition(int[] array) {
        if(array==null||array.length==0){
            return -1;
        }
        int left=0;
        int right=array.length-1;
        while(left<right-1){
            int mid=left+(right-left)/2;
            if(array[mid]>array[mid+1]){
                return mid+1;
            }
            else{
                if(array[mid]>array[left]){
                    left=mid+1;
                }
                else{
                    right=mid;
                }
            }
        }
        if(array[left]<=array[right]){
            return 0;
        }
        else{
            return right;
        }
        // Write your solution here
    }

    public static void main(String[] args) {
        shiftPosition s=new shiftPosition();
        int array[]={2,3,4,5,6,1};
        int result=s.shiftPosition(array);
        System.out.println(result);
    }
}
