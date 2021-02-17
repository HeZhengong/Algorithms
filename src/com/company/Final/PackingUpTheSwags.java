package com.company.Final;

public class PackingUpTheSwags {
    public int packUp(int input){
        int[] min=new int[input+1];
        //base case:
        min[0]=0;
        //induction rule:
        for (int i = 1; i < min.length; i++) {
            min[i]=i;
            for (int j = 1; j*j <= i; j++) {
                min[i]=Math.min(min[i],min[i-j*j]+1);
            }
        }
        return min[input];
    }

    public static void main(String[] args) {
        PackingUpTheSwags s=new PackingUpTheSwags();
        System.out.println(s.packUp(10));
    }
}
