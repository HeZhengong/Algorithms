package com.company.DynamicProgramming;

public class LargestSquareOfMatches {
    public int largestSquareOfMatches(int[][] matrix) {
        if(matrix.length==0||matrix[0].length==0){
            return 0;
        }
        int result = 0;
        int row = matrix.length;
        int column = matrix[0].length;
        int [][] right=new int[row+1][column+1];
        int [][] down=new int[row+1][column+1];
        for (int i = row-1; i >=0 ; i--) {
            for (int j = column-1; j >= 0 ; j--) {
                if(hasRight(matrix[i][j])){
                    right[i][j]=right[i][j+1]+1;
                }
                if(hasDown(matrix[i][j])){
                    down[i][j]=down[i+1][j]+1;
                }
                if(hasBoth(matrix[i][j])){
                    for(int maxLength=Math.min(right[i][j],down[i][j]);maxLength>=1;maxLength--){
                        if(right[i+maxLength][j]>=maxLength&&down[i][j+maxLength]>=maxLength){
                            result=Math.max(result,maxLength);
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }

    private boolean hasBoth(int val) {
        return val==0b11;
    }

    private boolean hasDown(int val) {
        return (val&0b10)!=0;
    }

    private boolean hasRight(int val) {
        return (val&0b1)!=0;
    }
}
