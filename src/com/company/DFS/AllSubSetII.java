package com.company.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class AllSubSetII {
    public List<String> subSets(String set) {
        List<String> result=new ArrayList<>();
        if(set==null){
            return result;
        }
        char[] arraySets=set.toCharArray();
        Arrays.sort(arraySets);
        StringBuilder sb=new StringBuilder();
        helper(arraySets,sb,0, result);
        return result;
    }

    private void helper(char[] arraySets, StringBuilder sb, int index, List<String> result) {
        if(index==arraySets.length){
            result.add(sb.toString());
            return;
        }
        helper(arraySets,sb.append(arraySets[index]),index+1,result);
        sb.deleteCharAt(sb.length()-1);
        while(index<arraySets.length-1&&arraySets[index]==arraySets[index+1]){
            index++;
        }
        helper(arraySets,sb,index+1,result);
    }
}
