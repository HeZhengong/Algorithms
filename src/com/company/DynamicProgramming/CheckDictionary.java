package com.company.DynamicProgramming;


import java.util.HashSet;
import java.util.Set;

public class CheckDictionary {
    public boolean canBreak(String input, String[] dict) {
        Set<String> dic=new HashSet<>();
        for (String s:dict) {
            dic.add(s);
        }
        boolean[] check=new boolean[input.length()+1];
        check[0]=true;
        for (int i = 1; i <= input.length(); i++) {
            if(dic.contains(input.substring(0,i))){
                check[i]=true;
            }
            else{
                for (int j = 1; j < i; j++) {
                    if(check[j]==true&&dic.contains(input.substring(j,i))){
                        check[i]=true;
                        break;
                    }
                }
            }
        }
        return check[input.length()];
    }

    public static void main(String[] args) {
        CheckDictionary s=new CheckDictionary();
        String test="robcatd";
        String[] testdic={"rob","cat","d"};
        System.out.println(s.canBreak(test,testdic));
    }
}
