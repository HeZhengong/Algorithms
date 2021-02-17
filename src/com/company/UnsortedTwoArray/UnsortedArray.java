package com.company.UnsortedTwoArray;

import com.company.Sorting.MergeSort;

public class UnsortedArray {
    public int findMin(int[] array1, int[] array2, int k){
        int m = array1.length;
        int n = array2.length;
        int []ComArray = new int[m+n];
        for (int i = 0; i < array1.length; i++) {
            ComArray[i] = array1[i];
        }
        for (int j = 0; j < array2.length; j++) {
            ComArray[m+j] = array2[j];
        }
        ComArray = mergeSort(ComArray);
        return ComArray[k-1];
    }

    private int[] mergeSort(int[] array) {
        if(array==null||array.length==0){
            return array;
        }
        int left=0;
        int right=array.length-1;
        return mergeSort(array,left,right);
    }

    private int[] mergeSort(int[] array, int left, int right) {
        if(left==right){
            return new int[]{array[left]};
        }
        int mid=left+(right-left)/2;
        int []leftResult=mergeSort(array,left,mid);
        int []rightResult=mergeSort(array,mid+1,right);
        return merge(leftResult,rightResult);
    }

    private int[] merge(int[] leftResult, int[] rightResult) {
        int []result=new int[leftResult.length+rightResult.length];
        int leftIndex=0;
        int rightIndex=0;
        int resultIndex=0;
        while(leftIndex<leftResult.length&&rightIndex<rightResult.length){
            if(leftResult[leftIndex]<rightResult[rightIndex]){
                result[resultIndex]=leftResult[leftIndex];
                leftIndex++;
                resultIndex++;
            }
            else{
                result[resultIndex]=rightResult[rightIndex];
                rightIndex++;
                resultIndex++;
            }
        }

        while(leftIndex<leftResult.length){
            result[resultIndex]=leftResult[leftIndex];
            resultIndex++;
            leftIndex++;
        }
        while(rightIndex<rightResult.length){
            result[resultIndex]=rightResult[rightIndex];
            resultIndex++;
            rightIndex++;
        }
        return result;
    }

    public static void main(String[] args) {
        UnsortedArray test = new UnsortedArray();
        int [] l1 = new int[]{2,7,3,1,5};
        int [] l2 = new int[]{4,10,20};
        System.out.println(test.findMin(l1,l2,3));
    }
}
