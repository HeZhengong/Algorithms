package com.company.Sorting;

public class Move0s {
    public int[] moveZero(int[] array) {
        int left=0;
        int right=array.length-1;
        quickSort(array,left,right);
        return array;
    }

    private void quickSort(int[] array, int left, int right){
        if(left>=right){
            return;
        }
        int pivotPos=partition(array,left,right);
        quickSort(array,left,pivotPos-1);
        quickSort(array,pivotPos+1,right);
    }
    private int partition(int[] array, int left, int right){
        int pivotPos=left+(right-left)/2;
        int pivotValue=array[pivotPos];
        swap(array,pivotPos,right);
        int leftBound=left;
        int rightBound=right-1;
        while(leftBound<=rightBound) {
            if (array[leftBound] != 0) {
                leftBound++;
            } else if (array[rightBound] == 0) {
                rightBound--;
            } else {
                swap(array, leftBound++, rightBound--);
            }
        }
        swap(array,leftBound,right);
        return leftBound;
    }

    public void swap(int[] array, int left, int right){
        int temp=array[left];
        array[left]=array[right];
        array[right]=temp;
    }

    public static void main(String[] args) {
        Move0s s= new Move0s();
        int []array={1,1,0,0,1,1};
        int []result=s.moveZero(array);
        for (int i = 0; i <result.length ; i++) {
            System.out.println(result[i]);
        }
    }
}
