package com.company.CrossTrainingI;

import java.util.Arrays;

public class DedupII {
    public int[] dedup(int[] array) {
        if(array.length<=1){
            return array;
        }
        int slow=2;
        for(int fast=2;fast<array.length;fast++){
            if(array[slow-2]!=array[fast]){
                array[slow++]=array[fast];
            }
        }

        return Arrays.copyOf(array,slow);
    }

    public static void main(String[] args) {
        DedupII s=new DedupII();
        int[] test={2,2,2,3,3};
        int[] result=s.dedup(test);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
