package com.company.CrossTrainingI;

public class LargestAndSmallest {
    public int[] largestAndSmallest(int[] array) {
        int smallest=array[0];
        int largest=array[0];
        for(int i=1;i<array.length;i++) {
            if(array[i]<smallest){
                smallest=array[i];
            }
            if(array[i]>largest){
                largest=array[i];
            }
        }
        int [] result=new int[]{smallest,largest};
        return result;
    }



    public static void main(String[] args) {
        LargestAndSmallest s=new LargestAndSmallest();
        int[] result=s.largestAndSmallest(new int[]{2,1,4,5,3});
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
