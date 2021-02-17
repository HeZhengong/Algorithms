package com.company.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        List<String> curResult = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            findQueens(curResult,0,n,result);
        }
        return result;
    }

    private void findQueens(List<String> curResult, int i, int n, List<List<String>> result) {
        if(i==n){
            result.add(curResult);
        }
        
    }
}
