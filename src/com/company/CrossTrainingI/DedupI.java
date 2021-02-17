package com.company.CrossTrainingI;

import java.util.Arrays;

public class DedupI {
    public int[] dedup(int[] array) {
        if(array.length<=1){
            return array;
        }
        int slow=0;
        for(int fast=1;fast<array.length;fast++){
            if(array[slow]!=array[fast]){
                array[++slow]=array[fast];
            }
        }
        return Arrays.copyOf(array, slow+1);
    }


    public static void main(String[] args) {
        DedupI s=new DedupI();
        int[] test={1,1,1,2,2};
        int[] result=s.dedup(test);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
