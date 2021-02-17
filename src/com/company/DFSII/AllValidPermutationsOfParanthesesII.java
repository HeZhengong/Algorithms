package com.company.DFSII;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class AllValidPermutationsOfParanthesesII {
    private static final char[] PS=new char[]{'(',')','<','>','{','}'};
    public List<String> validParentheses(int l, int m, int n) {
        List<String> result=new ArrayList<>();
        int[] remain=new int[]{l,l,m,m,n,n};
        Deque<Character> stack=new ArrayDeque<>();
        int length=2*l+2*m+2*n;
        StringBuilder sb=new StringBuilder();
        helper(sb,stack,remain,length,result);
        return result;
    }

    private void helper(StringBuilder sb, Deque<Character> stack, int[] remain, int length, List<String> result) {
        if(sb.length()==length){
            result.add(sb.toString());
            return;
        }
        for (int i = 0; i < remain.length; i++) {
            if(i%2==0){
                if(remain[i]>0){
                    sb.append(PS[i]);
                    stack.offerFirst(PS[i]);
                    remain[i]--;
                    helper(sb,stack,remain,length,result);
                    sb.deleteCharAt(sb.length()-1);
                    stack.pollFirst();
                    remain[i]++;
                }
            }
            else{
                if(!stack.isEmpty()&&stack.peekFirst()==PS[i-1]){
                    sb.append(PS[i]);
                    stack.pollFirst();
                    remain[i]--;
                    helper(sb,stack,remain,length,result);
                    sb.deleteCharAt(sb.length()-1);
                    stack.offerFirst(PS[i-1]);
                    remain[i]++;
                }
            }
        }
    }

    public static void main(String[] args) {
        AllValidPermutationsOfParanthesesII s=new AllValidPermutationsOfParanthesesII();
        System.out.println(s.validParentheses(2,2,2));
    }
}
