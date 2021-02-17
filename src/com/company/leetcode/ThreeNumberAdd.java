package com.company.leetcode;

import com.company.LinkedList.PalindromeList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberAdd {
    public List<List<Integer>> threeSum(int[] nums){
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans= new ArrayList<>();

        for(int first=0; first<n;first++){
            if(first>0&&nums[first]==nums[first-1]){
                continue;
            }

            int third=n-1;
            for(int second=first+1;second<n;second++){
                if(second>first+1&&nums[second]==nums[second-1]){
                    continue;
                }
                while(second<third&&nums[second]+nums[third]+nums[first]>0){
                    third--;
                }
                if(second>=third){
                    break;
                }
                if(nums[second]+nums[third]+nums[first]==0){
                    List<Integer> list= new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ThreeNumberAdd s=new ThreeNumberAdd();
        int[] array={-1,0,1,2,-1,-4};
        List<List<Integer>> result=s.threeSum(array);
        System.out.println(result);
    }
}
