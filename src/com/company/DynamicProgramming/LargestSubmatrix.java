package com.company.DynamicProgramming;

public class LargestSubmatrix {
    public int largest(int[][] matrix){
        //1. pre-processing: Calculate the pre-fix sum for each column.
        int[][] prefixSum=new int[matrix.length][matrix[0].length];
        int result=Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            int[] n=new int[prefixSum[0].length];
            for (int j = i; j < matrix.length; j++) {
                add(n, matrix[j]);

                result = Math.max(result,max(n));
            }
        }
        return result;
        //2. calculate the prefix sum for each column.
    }

    public void add(int[] cur, int[] add){
        for (int i = 0; i < cur.length; i++) {
            cur[i]+=add[i];
        }
    }

    public int max(int[] cur){
        int result=cur[0];
        int tmp=cur[0];
        for (int i = 1; i < cur.length; i++) {
            tmp=Math.max(tmp+cur[i],cur[i]);
            result=Math.max(result,tmp);
        }
        return result;
    }

    public static void main(String[] args) {
        LargestSubmatrix s=new LargestSubmatrix();
        int[][] matrix={{1, -2, -1, 4},

                {1, -1,  1, 1},

                {0, -1, -1, 1},

                {0,  0,  1, 1} };
        System.out.println(s.largest(matrix));
    }
}
