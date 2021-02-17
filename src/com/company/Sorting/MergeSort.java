package com.company.Sorting;

public class MergeSort {
    public int[] mergeSort(int[] array) {
        if(array==null||array.length==0){
            return array;
        }
        int left=0;
        int right=array.length-1;
        return mergeSort(array,left,right);

    }
    public int[] mergeSort(int[] array, int left, int right){
//        int mid=left+(right-left)/2;
        if(left==right){
            return new int[]{array[left]};
        }
        int mid=left+(right-left)/2;
        int []leftResult=mergeSort(array,left,mid);
        int []rightResult=mergeSort(array,mid+1,right);
        return merge(leftResult,rightResult);
    }
    public int[] merge(int []leftResult,int []rightResult){
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
        MergeSort s=new MergeSort();
        int array[]={1,6,2,4,5};
        int []result=s.mergeSort(array);
        for (int i = 0; i <result.length ; i++) {
            System.out.println(result[i]);
        }
    }
}
