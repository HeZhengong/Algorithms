package com.company.BinarySearch;

import javax.xml.transform.Source;

public class BinarySearch1 {
    public static int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(target>nums[mid]){
                left=mid+1;
            }
            else if(target<nums[mid]){
                right=mid-1;
            }
            else{
                return mid;
            }
        }
        return -1;


    }
    public static int[] kClosest(int[] array, int target, int k) {
        int left=0;
        int right=array.length-1;
        while(left<right-1){
            int mid=left+(right-left)/2;
            if(target<array[mid]){
                right=mid;
            }
            else if(target>array[mid]){
                left=mid;
            }
            else{
                left=mid;
                right=mid+1;
            }
        }
        int[] result=new int[k];
        for (int i = 0; i <k ; i++) {
            if(right>=array.length||(left>=0&&Math.abs(array[left]-target)<=Math.abs(array[right]-target))){
                result[i]=array[left];
                    left--;

            }
            else{
                result[i]=array[right];
                if(right<array.length){
                    right++;
                }
            }

        }
        return result;

    }

    public static int closest(int[] array, int target) {
        if(array.length==0){
            return -1;
        }
        int left=0;
        int right=array.length-1;
        while(left<right-1){
            int mid=left+(right-left)/2;
            if(target<array[mid]){
                right=mid;
            }
            else if(target>array[mid]){
                left=mid;
            }
            else{
                return mid;
            }
        }
        if((Math.abs(array[left]-target))<(Math.abs(array[right]-target))){
            return left;
        }
        else
            return right;

    }
    public static int firstOccur(int[] array, int target) {
        if(array.length==0){
            return -1;
        }
        int left=0;
        int right=array.length-1;
        while(left<right-1){
            int mid=left+(right-left)/2;
            if(target<array[mid]){
                right=mid-1;
            }
            else if(target>array[mid]){
                left=mid+1;
            }
            else{
                right=mid;
            }
        }
        if(array[left]==target){
            return left;
        }else if(array[right]==target){
            return right;
        }else{
            return -1;
        }
    }
    public static int lastOccur(int[] array, int target) {
        if(array.length==0){
            return -1;
        }
        int left=0;
        int right=array.length-1;
        while(left<right-1){
            int mid=left+(right-left)/2;
            if(target<array[mid]){
                right=mid-1;
            }
            else if(target>array[mid]){
                left=mid+1;
            }
            else{
                left=mid;
            }
        }
        if(array[right]==target){
            return right;
        }else if(array[left]==target){
            return left;
        }else{
            return -1;
        }

        // Write your solution here
    }

    public static int totalOccurrence(int[] array, int target) {
        int first=firstOccur(array,target);
        int last=lastOccur(array,target);
        if(first==-1&&last==-1){
            return 0;
        }
        else{
            return (last-first+1);
        }

    }

    public static int[] search(int[][] matrix, int target) {
        int row=matrix.length,column=matrix[0].length;
        int [] result={row, column};
        if(matrix.length==0||matrix[0].length==0){
            return new int[]{-1,-1};
        }
        int left=0;
        int right= row*column-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            int midRow=mid/column;
            int midCol=mid%column;
            if(target==matrix[midRow][midCol]){
                return new int[]{midRow, midCol};
            }
            else if(target>matrix[midRow][midCol]){
                left=mid+1;
            }
            else{
                right=mid-1;
            }


        }
        return new int[]{-1,-1};

    }

    public static int smallestElementLargerThanTarget(int[] array, int target) {
        if(array.length==0){
            return -1;
        }
        int left=0;
        int right=array.length-1;
        while(left<right-1){
            int mid=left+(right-left)/2;
            if(target>array[mid]){
                left=mid+1;
            }
            else if(target<array[mid]){
                right=mid;
            }
            else{
                left=mid;
            }
        }
        if(array[left]>target){
            return left;
        }
        else if(array[right]<=target) {
            return -1;
        }
        else{
            return right;
        }

    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int right;
        if (row == 1) {
            right = col - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (matrix[0][mid] == target) {
                    return true;
                } else if (matrix[0][mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return false;
        } else {
            right = row * col - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int midRow = mid / col;
                int midCol = mid % col;
                if (matrix[midRow][midCol] == target) {
                    return true;
                } else if (matrix[midRow][midCol] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int[] nums={-1,0,3,5,9,12};
        int[] nums1={1,2,2,2,6,7,10,11,13};
        int[] nums2={17,27,39,44,45,49,64};
        int target=8;
        int p=search(nums,target);
        int q=closest(nums1,target);
        int[] r=kClosest(nums2, 10, 3);
        int []array={1,2,2,2,3};
        int result=totalOccurrence(array,4);
        System.out.println(result);

        int[][] m={ {1}, {3}};
//        int s=smallestElementLargerThanTarget(nums2, 65);
//        System.out.println(s);
        boolean result1=searchMatrix(m,2);
        System.out.println(result1);

//        System.out.println(p);
//        System.out.println(q);
//        for(int i=0; i<r.length;i++) {
//            System.out.println(r[i]);
//        }
//        int []result=search(m,7);
//        System.out.println(result[0]);
//        System.out.println(result[1]);
    }
}
