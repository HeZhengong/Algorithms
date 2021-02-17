package com.company.DFSII;

import java.util.ArrayList;
import java.util.List;

public class AllSubsetsOfSizeK {
    public List<String> subSetsOfSizeK(String set, int k) {
        List<String> result=new ArrayList<>();
        if(set==null){
            return result;
        }
        char[] s=set.toCharArray();
        StringBuilder sb=new StringBuilder();
        helper(s,0,sb,result,k);
        return result;
    }

    private void helper(char[] s, int i, StringBuilder sb, List<String> result, int k) {
        if(sb.length()==k){
            result.add(sb.toString());
            return;
        }
        if(i==s.length){
            return;
        }
        sb.append(s[i]);
        helper(s,i+1,sb,result,k);
        sb.deleteCharAt(sb.length()-1);
        helper(s,i+1,sb,result,k);
    }

    public static void main(String[] args) {
        AllSubsetsOfSizeK s=new AllSubsetsOfSizeK();
        String set="abcd";
        System.out.print(s.subSetsOfSizeK(set,2));

    }
}
