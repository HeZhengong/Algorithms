package com.company.DynamicProgramming;



public class LargestX {
    public int largest(int[][] matrix) {
        int row=matrix.length;
        int column=matrix[0].length;
        if(row<=0){
            return 0;
        }
        if(column<=0){
            return 0;
        }
        int[][] leftTop = leftUp(matrix,row, column);
        int[][] rightBottom= rightDown(matrix, row, column);
        return merge(leftTop,rightBottom,row, column);
    }

    private int[][] rightDown(int[][] matrix, int row, int column) {
        int [][] right = new int[row][column];
        int [][] down = new int[row][column];
        for (int i = row-1; i >=0 ; i--) {
            for (int j = column-1; j >=0; j--) {
                if(matrix[i][j]==1) {
                    right[i][j] = getNumber(right, i + 1, j + 1, row, column) + 1;
                    down[i][j] = getNumber(down, i + 1, j - 1, row, column) + 1;
                }
            }
        }
        merge(right,down,row,column);
        return right;
    }

    private int[][] leftUp(int[][] matrix, int row, int column) {
        int [][] left= new int[row][column];
        int [][] up= new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if(matrix[i][j]==1){
                    left[i][j]=getNumber(left,i-1,j-1,row,column)+1;
                    up[i][j]=getNumber(up,i-1,j+1,row,column)+1;
                }
            }
        }
        merge(left,up,row,column);
        return left;
    }

    private int merge(int[][] left, int[][] up, int row, int column) {
        int result=0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                left[i][j] = Math.min(left[i][j],up[i][j]);
                result=Math.max(result, left[i][j]);
            }
        }
        return result;
    }

    private int getNumber(int[][] number, int upBound, int rightBound, int row, int column) {
        if(upBound<0||upBound>=row||rightBound<0||rightBound>=column){
            return 0;
        }
        return number[upBound][rightBound];
    }

    public static void main(String[] args) {
        LargestX s=new LargestX();
        int [][] test = { {1,1,0,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,0,1,0},{0,0,0,1,1}};
        System.out.println(s.largest(test));
    }
}
