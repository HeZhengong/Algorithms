package com.company.Sorting;

public class quickSort {

    public int[] quickSort(int[] array){
        if(array==null||array.length<=1){
            return array;
        }
        int left=0;
        int right=array.length-1;
        quickSort(array,left,right);
        return array;
    }

    public void quickSort(int[] array, int left, int right){
        if(left>=right){
            return;
        }
        int pivotPos=partition(array,left,right);
        quickSort(array,left,pivotPos-1);
        quickSort(array,pivotPos+1,right);
    }

    private int partition(int[] array, int left, int right) {
        int pivotPos = getPivotIndex(left,right);
        int pivotValue=array[pivotPos];
        swap(array,pivotPos,right);
        int leftBound=left;
        int rightBound=right-1;
        while(leftBound<=rightBound){
            if(array[leftBound]<pivotValue){
                leftBound++;
            }
            else if(array[rightBound]>pivotValue){
                rightBound--;
            }
            else{
                swap(array,leftBound,rightBound);
                leftBound++;
                rightBound--;
            }
        }
        swap(array,leftBound,right);
        return leftBound;
    }

    private int getPivotIndex( int left, int right) {
        return left+(int)(Math.random()*(right-left+1));
    }

    private void swap(int[] array, int left, int right){
        int temp=array[left];
        array[left]=array[right];
        array[right]=temp;
    }


    public static void main(String[] args) {
        quickSort s=new quickSort();
        int []array={5,4,3,2,1};
        int []result=s.quickSort(array);
        for (int i = 0; i <result.length ; i++) {
            System.out.println(result[i]);
        }
    }
}
