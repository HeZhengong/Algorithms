package com.company.DynamicProgramming;

import java.util.concurrent.ForkJoinPool;

public class ArrayHopper {
    public boolean canJump(int[] array) {
        if(array.length==1){
            return true;
        }
        boolean[] judge=new boolean[array.length];
        for (int i = array.length-2; i >=0 ; i--) {
            if(i+array[i]>=array.length-1){
                judge[i]=true;
            }
            else{
                for (int j = array[i]; j >= 1 ; j--) {
                    if(judge[j+i]){
                        judge[i]=true;
                        break;
                    }
                }
            }
        }
        return judge[0];
    }

    public static void main(String[] args) {
        ArrayHopper s=new ArrayHopper();
        System.out.println(s.canJump(new int[]{2,1,1,1,2}));
    }
}
