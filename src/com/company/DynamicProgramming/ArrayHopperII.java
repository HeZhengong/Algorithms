package com.company.DynamicProgramming;

import java.util.HashMap;

public class ArrayHopperII {
    public int minJump(int[] array) {
        if(array.length==1){
            return 0;
        }
        int[] numberOfSteps=new int[array.length];
        numberOfSteps[array.length-1]=0;

        for (int i = array.length-2; i >=0; i--) {
            int curMin=Integer.MAX_VALUE;
            if(array[i]+i>=array.length-1){
                numberOfSteps[i]=1;
            }
            else{
                for (int j = 0; j <= array[i]; j++) {
                    if(numberOfSteps[i+j]!=0) {
                        curMin = Math.min(curMin, 1 + numberOfSteps[i+j]);
                    }
                }
                if(curMin==Integer.MAX_VALUE){
                    numberOfSteps[i]=0;
                }
                else {
                    numberOfSteps[i] = curMin;
                }
            }
        }
        if(numberOfSteps[0]==0){
            return -1;
        }
        return numberOfSteps[0];
    }

    public int minJump1(int[] array){
        int length=array.length;
        int[] minJump=new int[length];
        minJump[0]=0;
        for (int i = 0; i < length; i++) {
            minJump[i]=-1;
            for (int j = i-1; j >= 0; j--) {
                if(j+array[j]>=i&&minJump[j]!=-1) {
                    if (minJump[i] == -1 || minJump[i] > minJump[j] + 1) {
                        minJump[i] = minJump[j] + 1;
                    }
                }
            }
        }
        return minJump[length-1];
    }

    public static void main(String[] args) {
        ArrayHopperII s=new ArrayHopperII();
        System.out.println(s.minJump(new int[]{2,1,1,1,1,0}));
    }
}
