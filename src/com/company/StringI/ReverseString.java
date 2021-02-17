package com.company.StringI;

public class ReverseString {
    public String reverse(String input) {
        char[] s=input.toCharArray();
        int i=0;
        int j=s.length-1;
        while(i<j){
            char temp=s[i];
            s[i]=s[j];
            s[j]=temp;
            i++;
            j--;
        }
        return new String(s);
    }

    public static void main(String[] args) {
        ReverseString s=new ReverseString();
        String result=s.reverse(new String("abc"));
        System.out.println(result);
    }
}
