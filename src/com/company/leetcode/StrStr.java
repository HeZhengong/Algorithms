package com.company.leetcode;

public class StrStr {
    public int strStr(String haystack, String needle) {
        if(haystack==null||needle==null||haystack.length()<needle.length()){
            return -1;
        }
        if(needle.length()==0){
            return 0;
        }
        for(int i=0;i<=haystack.length()-needle.length();i++){
            int j=0;
            while(j<needle.length()&&haystack.charAt(i+j)==needle.charAt(j)){
                j++;
            }
            if(j==needle.length()){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        StrStr sh=new StrStr();
        String l="a";
        String s="a";
        System.out.println(sh.strStr(l,s));

    }
}
