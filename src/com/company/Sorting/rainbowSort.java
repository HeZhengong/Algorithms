package com.company.Sorting;

public class rainbowSort {
    public int[] rainbowSort(int[] array) {
        if(array==null||array.length<=1){
            return array;
        }
        int neg=0;
        int zero=0;
        int pos=array.length-1;
        while(zero<=pos){
            if(array[zero]<0){
                swap(array,zero,neg);
                zero++;
                neg++;
            }
            else if(array[zero]==0){
                zero++;
            }
            else{
                swap(array,zero,pos);
                pos--;
            }
        }
        return array;
    }

    public void swap(int[] array, int left, int right){
        int temp=array[left];
        array[left]=array[right];
        array[right]=temp;
    }

    public static void main(String[] args) {
        rainbowSort s=new rainbowSort();
        int []array={-1,0,0,1,-1};
        int []result=s.rainbowSort(array);
        for(int i=0;i<result.length;i++) {
            System.out.println(result[i]);
        }
    }
}
