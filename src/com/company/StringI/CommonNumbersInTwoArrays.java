package com.company.StringI;

import java.util.*;

public class CommonNumbersInTwoArrays {
    public List<Integer> common(int[] A, int[] B) {
        List<Integer> result=new ArrayList<>();
        HashMap<Integer,Integer> setA=new HashMap<>();
        HashMap<Integer,Integer> setB=new HashMap<>();
        for (int i:A) {
            Integer ct=setA.get(i);
            if(ct==null){
                setA.put(i,1);
            }
            else{
                setA.put(i, ct+1);
            }
        }
        for (int i:B) {
            Integer ct=setB.get(i);
            if(ct==null){
                setB.put(i,1);
            }
            else{
                setB.put(i, ct+1);
            }
        }
        for(Map.Entry<Integer,Integer> entry:setA.entrySet()){
            Integer ctInB=setB.get(entry.getKey());
            if(ctInB!=null){
                int appear=Math.min(entry.getValue(),ctInB);
                for (int i = 0; i <appear ; i++) {
                    result.add(entry.getKey());
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CommonNumbersInTwoArrays s=new CommonNumbersInTwoArrays();
        int[] a={1,2,3,4,5,6};
        int[] b={1,3,3,3};
        List<Integer> result=s.common(a,b);
        System.out.println(result);
    }
}
