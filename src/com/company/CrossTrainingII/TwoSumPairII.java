package com.company.CrossTrainingII;

import com.company.DynamicProgramming.ArrayHopper;

import java.util.*;

public class TwoSumPairII {
    public List<List<Integer>> allPairs(int[] array, int target) {
        List<List<Integer>> result=new ArrayList<>();
        HashMap<Integer,Integer> hashMap=new HashMap();
        for (int i = 0; i < array.length; i++) {
            Integer count=hashMap.get(array[i]);
            if(count!=null&&array[i]*2==target&&count==1){
                result.add(Arrays.asList(array[i],array[i]));
            }
            else if(count==null&&hashMap.containsKey(target-array[i])){
                result.add(Arrays.asList(array[i],target-array[i]));
            }

            if(count==null){
                hashMap.put(array[i],1);
            }
            else{
                hashMap.put(array[i],count+1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TwoSumPairII s=new TwoSumPairII();
        int[] test={1,1,1,1};
        System.out.print(s.allPairs(test,2));
    }
}
