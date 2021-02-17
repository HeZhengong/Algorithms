package com.company.CrossTrainingII;

import java.util.*;

public class TwoSumPairI {
    public List<List<Integer>> allPairs(int[] array, int target) {
        List<List<Integer>> result=new ArrayList<>();
        Map<Integer,List<Integer>> map=new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            List<Integer>indices=map.get(target-array[i]);
            if(indices!=null){
                for (int j:indices) {
                    result.add(Arrays.asList(j,i));
                }
            }
            if(!map.containsKey(array[i])){
                map.put(array[i],new ArrayList<Integer>());
            }
            map.get(array[i]).add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        TwoSumPairI s=new TwoSumPairI();
        int[] test={1,2,2,4};
        System.out.print(s.allPairs(test,6));
    }
}
