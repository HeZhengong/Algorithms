package com.company.Recursion;

import com.company.StringI.MissingNumberI;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public List<List<Integer>> nqueens(int n) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> curResult=new ArrayList<>();
        helper(n,result,curResult);
        return result;
    }

    private void helper(int n, List<List<Integer>> result, List<Integer> curResult) {
        if(curResult.size()==n){
            result.add(new ArrayList<>(curResult));
            return;
        }
        for(int i=0; i<n;i++){
            if(valid(curResult,i)){
                curResult.add(i);
                helper(n,result,curResult);
                curResult.remove(curResult.size()-1);
            }
        }
    }

    private boolean valid(List<Integer> curResult, int column) {
        int row=curResult.size();
        for (int j = 0; j < row; j++) {
            if(curResult.get(j)==column||Math.abs(curResult.get(j)-column)==row-j){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        NQueens s=new NQueens();
        List<List<Integer>> result=s.nqueens(4);
        System.out.println(result);
    }
}
