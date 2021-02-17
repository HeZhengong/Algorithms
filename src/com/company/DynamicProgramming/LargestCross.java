package com.company.DynamicProgramming;

public class LargestCross {
    public int largest(int[][] matrix) {
        int result=0;
        int [][]countLeft=new int[matrix.length][matrix[0].length];
        int [][]countRight=new int[matrix.length][matrix[0].length];
        int [][]countTop=new int[matrix.length][matrix[0].length];
        int [][]countBottom=new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(j==0){
                    if(matrix[i][j]==0){
                        countLeft[i][j]=0;
                    }
                    else{
                        countLeft[i][j]=1;
                    }
                }
                else{
                    if(matrix[i][j]==0){
                        countLeft[i][j]=0;
                    }
                    else{
                        countLeft[i][j]=countLeft[i][j-1]+1;
                    }
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = matrix[0].length-1; j >= 0; j--) {
                if(j==matrix[0].length-1){
                    if(matrix[i][j]==0){
                        countRight[i][j]=0;
                    }
                    else{
                        countRight[i][j]=1;
                    }
                }
                else{
                    if(matrix[i][j]==0){
                        countRight[i][j]=0;
                    }
                    else{
                        countRight[i][j]=countRight[i][j+1]+1;
                    }
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(i==0){
                    if(matrix[i][j]==0){
                        countTop[i][j]=0;
                    }
                    else{
                        countTop[i][j]=1;
                    }
                }
                else{
                    if(matrix[i][j]==0){
                        countTop[i][j]=0;
                    }
                    else{
                        countTop[i][j]=countTop[i-1][j]+1;
                    }
                }
            }
        }
        for (int i = matrix.length-1; i >=0 ; i--) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(i==matrix.length-1){
                    if(matrix[i][j]==0){
                        countBottom[i][j]=0;
                    }
                    else{
                        countBottom[i][j]=1;
                    }
                }
                else{
                    if(matrix[i][j]==0){
                        countBottom[i][j]=0;
                    }
                    else{
                        countBottom[i][j]=countBottom[i+1][j]+1;
                    }
                }
            }
        }
        int[][] Largest=new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                Largest[i][j]=Math.min(countLeft[i][j],countRight[i][j]);
                Largest[i][j]=Math.min(Largest[i][j],countBottom[i][j]);
                Largest[i][j]=Math.min(Largest[i][j],countTop[i][j]);
                result=Math.max(result,Largest[i][j]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LargestCross s=new LargestCross();
        int[][] test={ {1,1,1,1,1},{1,1,1,1,0},{0,0,0,1,1}};
        System.out.println(s.largest(test));
    }
}
