package com.company.StringII;

import java.util.logging.Level;

public class ReverseWordSentence {
    public String reverseWords(String input) {
        char[] s=input.toCharArray();
        reverse(s,0,input.length()-1);
        int start=0;
        int end=0;
        for(int i=0;i<input.length();i++){
            if(s[i]!=' '&&(i==0||s[i-1]==' ')){
                start=i;
            }
            if(s[i]==s[s.length-1]||s[i+1]==' '){
                end=i;
                reverse(s,start,end);
            }
        }
        return new String(s);
    }
    public String reverseSingleWord(String input){
        char[] s=input.toCharArray();
        int left=0;
        int right=0;
        for (int i = 0; i < s.length; i++) {
            if (i!=s.length-1&&s[i+1] == ' ') {
                left=right;
                right=i;
                reverse(s,left,right);
                right=i+2;
            }
            if(i==s.length-1){
                left=right;
                right=i;
                reverse(s,left,right);
            }
        }
        return new String(s);
    }

    private void reverse(char[] s, int left, int right) {
        while(left<right){
            char temp=s[left];
            s[left]=s[right];
            s[right]=temp;
            left++;
            right--;
        }
    }

    public String reverseWords1(String s) {
        char[] input=s.toCharArray();
        int left=0;
        int right=0;
        for (int i = 0; i < input.length; i++) {
            if (i!=input.length-1&&input[i+1] == ' ') {
                left=right;
                right=i;
                reverse(input,left,right);
                right=i+2;
            }
            if(i==input.length-1){
                left=right;
                right=i;
                reverse(input,left,right);
            }
        }
        return new String(input);
    }



    public static void main(String[] args) {
        ReverseWordSentence s=new ReverseWordSentence();
        String result=s.reverseWords1(new String("Let's take LeetCode contest"));
        System.out.println(result);
    }
}
