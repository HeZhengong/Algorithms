package com.company.Sorting;

public class MinIndex {
    public int minIndex(int[] array, int i) {
        int min=i;
        for(int j=i;j<array.length;j++){
            if(array[j]<array[min]){
                min=j;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        MinIndex s=new MinIndex();
        int[] array={5,4,3,2,1};
        int result=s.minIndex(array,1);
        System.out.println(result);
    }
}
