package com.company.CrossTrainingI;

import java.util.Arrays;

public class DedupIII {
    public int[] dedup(int[] array) {
        if(array.length<=1){
            return array;
        }
        int slow=0;
        int fast=0;
        while(fast<array.length){
            int fast2=fast+1;
            while(fast2<array.length&&array[fast2]==array[fast]){
                fast2++;
            }

            if(fast2-fast==1){
                array[slow++]=array[fast];
            }
            fast=fast2;
        }

        return Arrays.copyOf(array,slow);
    }
}
