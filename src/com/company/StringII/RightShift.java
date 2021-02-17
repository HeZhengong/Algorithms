package com.company.StringII;

public class RightShift {
    public String rightShift(String input, int n) {
        if(n==0||input.length()<=1){
            return input;
        }
        char[] s=input.toCharArray();
        n%=s.length;
        reverse(s,0,s.length-n-1);
        reverse(s,s.length-n,s.length-1);
        reverse(s,0,s.length-1);
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

    public static void main(String[] args) {
        RightShift s=new RightShift();
        String result=s.rightShift(new String("abcd"),1);
        System.out.println(result);
    }
}
