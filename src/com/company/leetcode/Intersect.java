package com.company.leetcode;

import java.util.*;

public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length==0||nums2.length==0){
            return new int[]{};
        }
        List<Integer> result= new ArrayList<>();
        Map<Integer,Integer> m1=new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if(m1.containsKey(nums1[i])){
                int number=m1.get(nums1[i]);
                m1.put(nums1[i],number+1);
            }
            else{
                m1.put(nums1[i],1);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if(m1.containsKey(nums2[i])){
                int curCount=m1.get(nums2[i]);
                if(curCount>=1){
                    result.add(nums2[i]);
                    m1.put(nums2[i],curCount-1);
                }
            }
        }
        int[] answer=new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Intersect s=new Intersect();
        int[] number1={1,2,2,1};
        int[] number2={2,2};
        int[] result=s.intersect(number1,number2);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
