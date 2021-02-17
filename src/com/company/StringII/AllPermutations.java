package com.company.StringII;

import com.company.DFS.AllPermutation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllPermutations {
    public List<String> permutations(String input) {
        List<String> result=new ArrayList<>();
        char[] s=input.toCharArray();
        helper(s,0,result);
        return result;
    }

    private void helper(char[] s, int i, List<String> result) {
        if(i==s.length){
            result.add(new String(s));
            return;
        }
        Set<Character> used=new HashSet<>();
        for(int j=i;j<s.length;j++){
            if(used.contains(s[j])) {
                continue;
            }
                used.add(s[j]);
                swap(s, j, i);
                helper(s, i + 1, result);
                swap(s, j, i);
        }
    }

    private void swap(char[] s, int i, int j) {
        char temp=s[i];
        s[i]=s[j];
        s[j]=temp;
    }
    public static void main(String[] args) {
        AllPermutations s=new AllPermutations();
        String test="aba";
        List<String> result=s.permutations(test);
        System.out.println(result);
    }
}
