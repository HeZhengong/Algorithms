package com.company.CrossTrainingII;

import java.util.HashSet;
import java.util.Set;

public class TwoSUm {
    public boolean existSum(int[] array, int target) {
        HashSet<Integer> hashset=new HashSet<>();
        for(int i=0;i<array.length;i++){
            if(hashset.contains(target-array[i])){
                return true;
            }
            else{
                hashset.add(array[i]);
            }
        }
        return false;
    }
}
