package com.company.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>result=new ArrayList<>();
        helper(nums,0,result);
        return result;
    }
    public void helper(int[] nums, int index, List<List<Integer>> result){
        List<Integer> curResult=new ArrayList<>();
        if(index==nums.length){
            for (int i = 0; i <nums.length ; i++) {
                curResult.add(nums[i]);
            }
            result.add(curResult);
            return;
        }
        for(int j=index;j<nums.length;j++){
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
        Permutation s=new Permutation();
        List<List<Integer>> result=s.permute(new int[]{1,2,3});
        System.out.println(result);
    }
}
