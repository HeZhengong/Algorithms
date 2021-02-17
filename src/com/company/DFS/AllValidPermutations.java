package com.company.DFS;

import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.List;

public class AllValidPermutations {
    public List<String> validParentheses(int n) {
        List<String> result=new ArrayList<>();
        if(n==0){
            return result;
        }
        char[] cur=new char[2*n];
        StringBuilder sb=new StringBuilder();
        helper(n, 0,0,sb,result);
        return result;
    }

    private void helper(int n, int left, int right, StringBuilder sb,List<String> result) {
        if(left==n&&right==n){
            result.add(sb.toString());
            return;
        }
        if(left<n){
            sb.append('(');
            helper(n,left+1,right,sb,result);
            sb.deleteCharAt(sb.length()-1);
        }
        if(left>right){
            sb.append(')');
            helper(n,left,right+1,sb,result);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        AllValidPermutations s=new AllValidPermutations();
        int n=3;
        List<String>result=s.validParentheses(3);
        System.out.println(result);
    }
}
