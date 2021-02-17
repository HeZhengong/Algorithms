package com.company.DynamicProgramming;

public class LongestAscendingSubsequence {
    public int longest(int[] array) {
        if(array==null||array.length==0){
            return 0;
        }
        int result=1;
        int[] lowest_ending=new int[array.length];
        lowest_ending[0]=1;
        for (int i = 1; i < array.length; i++) {
            lowest_ending[i]=1;
            for (int j = 0; j <i ; j++) {
                if(array[i]>array[j]){
                    lowest_ending[i]=Math.max(lowest_ending[i],lowest_ending[j]+1);
                }
                result=Math.max(result,lowest_ending[i]);
            }
        }
        return result;
    }

    public int longest1(int[] array){
        if(array==null||array.length==0){
            return 0;
        }
        int[] tbl=new int[array.length+1];
        int result=1;
        tbl[1]=array[0];
        for (int i = 1; i < array.length; i++) {
            int index=find(tbl,1,result,array[i]);

            if(index==result){
                tbl[++result]=array[i];
            }
            else{
                tbl[index+1]=array[i];
            }
        }
        return result;
    }

    private int find(int[] tbl, int left, int right, int target) {
        while(left+1<right){
            int mid=left+(right-left)/2;
            if(tbl[mid]>=target){
                right=mid-1;
            }
            else{
                left=mid;
            }
        }
        for (int i = right; i >= left ; i--) {
            if(tbl[i]<target){
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        LongestAscendingSubsequence s=new LongestAscendingSubsequence();
        System.out.println(s.longest1(new int[]{7,2,3,1,1,5,8,1,1,9,1,6}));
    }
}
