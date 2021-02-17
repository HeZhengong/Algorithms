package com.company.DynamicProgramming;

public class LargestSquareOfOnes {
    public int largest(int[][] matrix) {
        int result=0;
        int[][] largest=new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(i==0||j==0){
                    largest[i][j]=matrix[i][j]==1?1:0;
                }
                else if(matrix[i][j]==1){
                    largest[i][j]=Math.min(largest[i][j-1]+1,largest[i-1][j]+1);
                    largest[i][j]=Math.min(largest[i][j],largest[i-1][j-1]+1);
                }
                result = Math.max(result,largest[i][j]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LargestSquareOfOnes s=new LargestSquareOfOnes();
        int[][] array={{1,1,1,1 },

                       {1, 1, 1, 0},

                       {1, 1, 1, 1},

                       {1, 1, 0, 1}};
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println(s.largest(array));
    }
}
