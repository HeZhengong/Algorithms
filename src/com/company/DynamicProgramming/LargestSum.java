package com.company.DynamicProgramming;

public class LargestSum {
    public int largestSum(int[] array) {
//        int[] sum=new int[array.length];
        int CurMax=array[0];
        int globalMax=array[0];
        for (int i = 1; i < array.length; i++) {
            CurMax = Math.max(CurMax+array[i],array[i]);
            globalMax=Math.max(globalMax,CurMax);
        }
        return globalMax;
    }
}
