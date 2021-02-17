package com.company.DFS;

import com.company.DynamicProgramming.ArrayHopper;

import java.util.ArrayList;
import java.util.List;

public class AllPermutation {
    public List<String> permutations(String input) {
        List<String> result=new ArrayList<>();
        char[] s=input.toCharArray();
        permutation(s,0,result);
        return result;
    }

    private void permutation(char[] s, int i, List<String>res) {
        if(i==s.length){
            res.add(new String(s));
            return;
        }

        for (int j = i; j < s.length; j++) {
            swap(s,i,j);
            permutation(s,i+1,res);
            swap(s,i,j);
        }
    }

    private void swap(char[] s, int i, int j) {
        char temp=s[i];
        s[i]=s[j];
        s[j]=temp;
    }

    public static void main(String[] args) {
        AllPermutation s=new AllPermutation();
        String test="abc";
        List<String> result=s.permutations(test);
        System.out.println(result);
    }
}
