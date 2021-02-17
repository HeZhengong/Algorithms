package com.company.Sorting;

public class selectionSort {
    public int[] solve(int[] array) {
        int []result = new int[array.length];
        if(array==null||array.length==0){
            return array;
        }
        for(int i=0;i<array.length;i++){
            int min=i;
            for(int j=i+1;j<array.length;j++){
                if(array[j]<array[min]){
                    min=j;
                }
            }
            int temp=array[i];
            array[i]=array[min];
            array[min]=temp;
            result[i]=array[i];
        }
        return result;
    }

    public static void main(String[] args) {
        selectionSort s=new selectionSort();
        int []test={4, 2, -3, 6, 1};
        int []result=s.solve(test);
        for (int i = 0; i <result.length ; i++) {
            System.out.println(result[i]);
        }

    }

}
