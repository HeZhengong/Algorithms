package com.company.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        helper(nums,0,result);
        return result;
    }

    private void helper(int[] nums, int index, List<List<Integer>> result) {
        List<Integer> curResult=new ArrayList<>();
        if(index==nums.length){
            for (int i = 0; i < nums.length ; i++) {
                curResult.add(nums[i]);
            }
            result.add(curResult);
        }
        Set<Integer> set=new HashSet<>();
        for(int j=index;j<nums.length;j++){
            if(set.contains(nums[j])){
                continue;
            }
            set.add(nums[j]);
            swap(nums,index,j);
            helper(nums,index+1,result);
            swap(nums,index,j);
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void main(String[] args) {
        PermutationUnique s=new PermutationUnique();
        List<List<Integer>> result=s.permuteUnique(new int[]{1,2,2});
        System.out.println(result);
    }
}
