package com.company.Recursion;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixII {
    public List<Integer> spiral(int[][] matrix) {
        List<Integer> result=new ArrayList<>();
        if(matrix.length==0){
            return result;
        }
        helper(matrix, 0, matrix[0].length-1, 0, matrix.length-1, result);
        return result;
    }

    private void helper(int[][] matrix, int left, int right, int up, int down, List<Integer> result) {
        if(left>right||up>down){
            return;
        }
        if(left==right){
            for (int i = up; i <= down; i++) {
                result.add(matrix[i][left]);
            }
            return;
        }
        if(up==down) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[up][i]);
            }
            return;
        }
        for(int i=left;i<=right;i++){
            result.add(matrix[up][i]);
        }
        for (int i = up+1; i <= down-1 ; i++) {
            result.add(matrix[i][right]);
        }
        for (int i = right; i >= left ; i--) {
            result.add(matrix[down][i]);
        }
        for (int i = down-1; i > up ; i--) {
            result.add(matrix[i][left]);
        }
        helper(matrix,left+1,right-1,up+1,down-1,result);
    }

    public static void main(String[] args) {
        SpiralMatrixII s=new SpiralMatrixII();
        int[][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> result=s.spiral(matrix);
        System.out.println(result);
    }
}
