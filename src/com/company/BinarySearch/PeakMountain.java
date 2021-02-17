package com.company.BinarySearch;

public class PeakMountain {
    public int peakIndexInMountainArray(int[] A) {
        int left=0;
        int right=A.length-1;
        while(left<right-1){
            int mid=left+(right-left)/2;
            if(A[mid]>A[left]&&A[mid]<A[right]){
                left=mid;
            }
            else if(A[mid]<A[left]&&A[mid]>A[right]){
                right=mid;
            }
            else{
                right--;
            }
        }
        if(left<right){
            return right;
        }
        else{
            return left;
        }

    }

    public static void main(String[] args) {
        PeakMountain s=new PeakMountain();
        int []array={24,69,100,99,79,78,67,36,26,19};
        int result=s.peakIndexInMountainArray(array);
        System.out.println(result);
    }
}
