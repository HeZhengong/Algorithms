package com.company.StringI;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveRepeatedChar {
    public String deDup(String input) {
        if(input==null||input.length()<1){
            return new String();
        }
        char[] s=input.toCharArray();
        Deque<Character> stack=new ArrayDeque<>();
        int fast=0;
        while (fast<s.length) {
            char curPeek=s[fast];
            if(!stack.isEmpty()&&stack.peek()==curPeek){
                while(fast<s.length&&s[fast]==curPeek){
                    fast++;
                }
                stack.poll();
            }
            else {
                stack.offerFirst(curPeek);
                fast++;
            }
        }
        char[] result=new char[stack.size()];
        while(!stack.isEmpty()){
            for(int i=stack.size()-1;i>=0;i--){
                result[i]=stack.poll();
            }
        }
        return new String(result,0,result.length);
    }
    public static void main(String[] args) {
        RemoveRepeatedChar s=new RemoveRepeatedChar();
        String test="aabababzx";
        String result=s.deDup(test);
        System.out.println(result);
    }
}
