package com.company.DynamicProgramming;

public class maxProductOfCuttingRope {
    public int maxProduct(int length) {
        int[] n=new int[length+1];
        n[0]=0;
        n[1]=0;
        for (int i = 2; i <= length; i++) {
            int curMax=0;
            for (int j = 1; j < i; j++) {
                curMax=Math.max(curMax,Math.max(j,n[j])*(i-j));
            }
            n[i]=curMax;
        }
        return n[length];
    }

    public static void main(String[] args) {
        maxProductOfCuttingRope s=new maxProductOfCuttingRope();
        System.out.println(s.maxProduct(4));
    }
}
