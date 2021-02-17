package com.company.leetcode;

public class LongestPali {
    public String longestPalindrome(String s) {
        boolean [][] check = new boolean[s.length()][s.length()];
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j+i < s.length(); j++) {
                int k = j+i;
                if(i==0){
                    check[j][k]=true;
                }
                else if(i==1){
                    if(s.charAt(j)==s.charAt(k)){
                        check[j][k]=true;
                    }
                }
                else{
                    check[j][k]=(s.charAt(j)==s.charAt(k)&&check[j+1][k-1]);
                }

                if(check[j][k]&&i+1>ans.length()){
                    ans = s.substring(j,j+i+1);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestPali s = new LongestPali();
        System.out.println(s.longestPalindrome("ababa"));
    }
}
