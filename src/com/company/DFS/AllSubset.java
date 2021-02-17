package com.company.DFS;

import java.util.ArrayList;
import java.util.List;

public class AllSubset {
    public List<String> subSets(String set) {
        if(set==null){
            return null;
        }
        List<String> result=new ArrayList<>();
        char[] index=set.toCharArray();
        StringBuilder sb=new StringBuilder();
        helper(index,0,sb,result );
        return result;
    }

    private void helper(char[] index, int i, StringBuilder sb, List<String> result) {
        if(i==index.length){
            result.add(sb.toString());
            return;
        }
        sb.append(index[i]);
        helper(index,i+1,sb,result);
        sb.deleteCharAt(sb.length()-1);
        helper(index,i+1,sb,result);
    }

    public static void main(String[] args) {
        AllSubset s=new AllSubset();
        String set="abc";
        List<String> result=s.subSets(set);
        System.out.println(result);
    }
}
