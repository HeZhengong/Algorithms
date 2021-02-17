package com.company.DIY;

public class LongestPalinSubString {
    public int longestPalindrome(String input) {
        int length=input.length();
        int[][] n=new int[length][length];
        for (int i =  length-1; i >= 0; i--) {
            n[i][i]=1;
            for (int j = i+1; j < length; j++) {
                if(input.charAt(i)==input.charAt(j)){
                    n[i][j]=n[i+1][j-1]+2;
                }
                else{
                    n[i][j]=Math.max(n[i+1][j],n[i][j-1]);
                }
            }
        }
        return n[0][length];
    }
}
