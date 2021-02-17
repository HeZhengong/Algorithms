package com.company.CrossTrainingII;

import java.lang.annotation.Target;
import java.util.*;

public class ThreeSum {
    public List<List<Integer>> allTriples(int[] array, int target) {
        List<List<Integer>> result=new ArrayList<>();
        Set<Integer> hashSet=new HashSet<>();
        for(int i=0;i<array.length;i++){
            //List<Integer> curResult=new ArrayList<>();
            TwoSum(array,result,i+1,array[i],array.length-1,target-array[i]);
//                if(!hashSet.contains(array[i])) {
//                    result.add(curResult);
//                }
//            }
            hashSet.add(array[i]);
        }
        return result;
    }

    private void TwoSum(int[] array, List<List<Integer>> curResult, int first, int firstValue, int right, int remaining) {
        HashMap<Integer,Integer> hashMap=new HashMap();
        Integer countFirst=hashMap.get(firstValue);
        if(countFirst==null){
            hashMap.put(firstValue,1);
        }
        else{
            hashMap.put(firstValue,countFirst++);
        }
        for (int i = first; i < array.length; i++) {
            Integer count=hashMap.get(array[i]);
            if(count!=null&&array[i]*2==remaining&&count==1&&remaining-array[i]!=firstValue){
//                curResult.add(firstValue);
////                curResult.add(array[i]);
////                curResult.add(remaining-array[i]);
                curResult.add(Arrays.asList(firstValue,array[i],remaining-array[i]));
            }
            else if(count==null&&(hashMap.containsKey(remaining-array[i]))){
//                curResult.add(firstValue);
//                curResult.add(array[i]);
//                curResult.add(remaining-array[i]);
                curResult.add(Arrays.asList(firstValue,array[i],remaining-array[i]));
            }

            if(count==null){
                hashMap.put(array[i],1);
            }
            else{
                hashMap.put(array[i],count+1);
            }
        }
//        return !curResult.isEmpty();
    }

    public static void main(String[] args) {
        ThreeSum s=new ThreeSum();
        int[] test={3,4,0,-1,2,0,5};
        System.out.print(s.allTriples(test,5));
    }
}
