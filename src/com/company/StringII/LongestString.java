package com.company.StringII;

import java.util.HashSet;
import java.util.Set;

public class LongestString {
    public int longest(String input) {
        int slow=0;
        int fast=0;
        int longest=0;
        Set<Character> distinct=new HashSet<>();
        while(fast<input.length()){
            if(distinct.contains(input.charAt(fast))){
                distinct.remove(input.charAt(slow));
                slow++;
            }
            else{
                distinct.add(input.charAt(fast));
                fast++;
                longest=Math.max(fast-slow,longest);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestString s=new LongestString();
        String input="bcdserfgbd";
        System.out.println(s.longest(input));
    }
}
