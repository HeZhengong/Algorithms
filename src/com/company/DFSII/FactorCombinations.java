package com.company.DFSII;


import java.util.ArrayList;
import java.util.List;

public class FactorCombinations {
    public List<List<Integer>> combinations(int target) {
        List<List<Integer>> result=new ArrayList<>();
        if(target<=1){
            return result;
        }
        List<Integer> curResult=new ArrayList<>();
        List<Integer> factors=getFactors(target);
        helper(target,factors,0,curResult,result);
        return result;
    }

    private List<Integer> getFactors(int target) {
        List<Integer> factor=new ArrayList<>();
        for (int i = target/2; i > 1; i--) {
            if(target%i==0){
                factor.add(i);
            }
        }
        return factor;
    }

    private void helper(int target, List<Integer> factors, int index, List<Integer> curResult, List<List<Integer>> result) {
        if(index== factors.size()){
            if(target==1){
                result.add(new ArrayList<>(curResult));
            }
            return;
        }
        helper(target,factors,index+1,curResult,result);
        int factor=factors.get(index);
        int size= curResult.size();
        while(target%factor==0){
            curResult.add(factor);
            target/=factor;
            helper(target,factors,index+1,curResult,result);
        }
        curResult.subList(size,curResult.size()).clear();
    }

    public static void main(String[] args) {
        FactorCombinations s=new FactorCombinations();
        System.out.println(s.combinations(24));
    }
}
