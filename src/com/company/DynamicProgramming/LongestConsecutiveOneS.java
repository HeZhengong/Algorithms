package com.company.DynamicProgramming;

public class LongestConsecutiveOneS {
    public int longest(int[] array){
        if(array.length==0){
            return 0;
        }
        int globalMax=0;
        int curResult=0;
        for (int i = 0; i < array.length; i++) {
            if(array[i]==0||curResult==0){
                curResult=1;
            }
            else{
                curResult++;
            }
            globalMax=Math.max(globalMax,curResult);
        }
        return globalMax;
    }

    public static void main(String[] args) {
        LongestConsecutiveOneS s= new LongestConsecutiveOneS();
        int[] array={0,1,0,1,1,1,0};
        System.out.println(s.longest(array));
    }
}
