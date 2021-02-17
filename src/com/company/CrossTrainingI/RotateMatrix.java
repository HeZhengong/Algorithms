package com.company.CrossTrainingI;

import java.awt.event.MouseWheelEvent;

public class RotateMatrix {
    public void rotate(int[][] matrix) {
        if(matrix.length<=1){
            return;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j< i; j++) {
                swap(matrix,i,j);
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length/2; j++) {
                swap(matrix,i,j,matrix.length-1-j);
            }
        }
    }

    private void swap(int[][] matrix, int row, int left, int right) {
        int temp=matrix[row][left];
        matrix[row][left]=matrix[row][right];
        matrix[row][right]=temp;
    }

    private void swap(int[][] matrix, int i, int j) {
        int temp=matrix[i][j];
        matrix[i][j]=matrix[j][i];
        matrix[j][i]=temp;
    }

    public static void main(String[] args) {
        RotateMatrix s=new RotateMatrix();
        int[][] test = { {1, 2, 3},
                {4,5,6},
                {7,8,9} };
        s.rotate(test);
        System.out.println(test);
    }
}
