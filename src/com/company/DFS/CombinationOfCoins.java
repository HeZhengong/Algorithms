package com.company.DFS;

import java.util.ArrayList;
import java.util.List;

public class CombinationOfCoins {
    public List<List<Integer>> combinations(int target, int[] coins) {
        List<List<Integer>>result=new ArrayList<List<Integer>>();
        List<Integer> curResult=new ArrayList<>();
        findCombination(coins,target, 0,result,curResult);
//        result.add(curResult);
        return result;
    }

    private void findCombination(int[] coins, int targetRemaining, int i, List<List<Integer>> result, List<Integer> curResult) {
        if (i == coins.length - 1) {
            if(targetRemaining%coins[coins.length-1]==0) {
                curResult.add(targetRemaining / coins[i]);
                result.add(new ArrayList<Integer>(curResult));
                curResult.remove(curResult.size() - 1);
            }
            return;
        }

        for (int j = 0; j <= targetRemaining / coins[i]; j++) {
            curResult.add(j);
            findCombination(coins, targetRemaining - j * coins[i], i + 1, result,curResult);
            curResult.remove(curResult.size()-1);
        }
    }

    public static void main(String[] args) {
        CombinationOfCoins s=new CombinationOfCoins();
        int target=99;
        int[] coins={1,2,5,10,25};

        List<List<Integer>> result=s.combinations(target,coins);
        System.out.println(result);
        System.out.println(result.size());
    }
}
