package com.company.Recursion;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
/*    public List<Integer> spiral(int[][] matrix) {
        List<Integer> result=new ArrayList<>();
        helper(matrix,0,matrix.length,result);
        return result;
    }

    private void helper(int[][] matrix, int index, int size, List<Integer> result) {
        if(size==0){
            return;
        }
        if(size==1){
            result.add(matrix[index][index]);
            return;
        }
        for(int i=0;i<size-1;i++){
            result.add(matrix[index][index+i]);
        }
        for(int i=0;i<size-1;i++){
            result.add(matrix[index+i][index+size-1]);
        }
        for (int i = size-1; i >= 1; i--) {
            result.add(matrix[index+size-1][index+i]);
        }
        for(int i=size-1; i>=1; i--){
            result.add(matrix[index+i][index]);
        }
        helper(matrix,index+1,size-2,result);
    }*/
    public List<Integer> spiral(int[][] matrix) {

    List<Integer> result=new ArrayList<>();
    if(matrix.length==0){
        return result;
    }
    int length = matrix.length;
    helper(matrix, 0, matrix.length-1, result);
    return result;
    }
    public void helper(int[][] matrix, int left, int right, List<Integer> result){
        if(left>right){
            return;
        }
        if(left==right){
            result.add(matrix[left][left]);
            return;
        }
        for(int i=left;i<=right;i++){
            result.add(matrix[left][i]);
        }
        for(int i=left+1;i<=right;i++){
            result.add(matrix[i][right]);
        }
        for(int i=right-1;i>=left;i--){
            result.add(matrix[right][i]);
        }
        for(int i=right-1;i>left;i--){
            result.add(matrix[i][left]);
        }

        helper(matrix,++left,--right,result);
    }

    public static void main(String[] args) {
        SpiralMatrix s=new SpiralMatrix();
        int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> result=s.spiral(matrix);
        System.out.println(result);
    }
}
