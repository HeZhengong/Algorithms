package com.company.DynamicProgramming;

public class LongestAscendingArray {
    public int longest(int[] array) {
        if(array==null||array.length==0){
            return 0;
        }
        int[] curLongest= new int[array.length+1];
        curLongest[0]=1;
        int globalMax=1;
        for (int i = 1; i < array.length; i++) {
            if(array[i]<=array[i-1]){
                curLongest[i]=1;
            }
            else{
                curLongest[i]=curLongest[i-1]+1;
            }
            globalMax=Math.max(globalMax,curLongest[i]);
        }
        return globalMax;
    }

    public static void main(String[] args) {
        LongestAscendingArray s=new LongestAscendingArray();
        int[] array={134,977,60,213,919,141,90,1030,705,574,611,149,571,656,259,216,794,276,37,537,735,209,286,600,872,189,349,652,132,182,625};
        System.out.println(s.longest(array));
    }
}
