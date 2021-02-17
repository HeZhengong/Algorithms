package com.company.DFSII;

import com.company.DFS.AllPermutation;

import java.util.ArrayList;
import java.util.List;

public class AllPermutationOfSubSets {
    public List<String> allPermutationsOfSubsets(String input) {
        List<String> result=new ArrayList<>();
        char[] s=input.toCharArray();
        permutation(s,0,result);
        return result;
    }

    private void permutation(char[] s, int i, List<String>res) {
//        if(i==s.length){
//            res.add(new String(s));
//            return;
//        }
        res.add(new String(s,0,i));
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
        AllPermutationOfSubSets s=new AllPermutationOfSubSets();
        String test="abc";
        List<String> result=s.allPermutationsOfSubsets(test);
        System.out.println(result);
    }
}
class Schedule {
    public List<String> schedules(String input) {
        List<String> result=new ArrayList<>();
        char[] s=input.toCharArray();
        permutation(s,0,result);
        return result;
    }

    private void permutation(char[] s, int i, List<String> result) {

        for (int j = i; j < s.length; j++) {
            swap(s,i,j);
            permutation(s,i+1,result);
            swap(s,i,j);
        }
    }

    private void swap(char[] s, int i, int j) {
        char temp=s[i];
        s[i]=s[j];
        s[j]=temp;
    }
}