package com.company.Recursion;

import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;

public class StringAbrev {
    public boolean match(String input, String pattern) {
        if(input.length()==0&&pattern.length()==0){
            return true;
        }
        if(input.length()==0||pattern.length()==0){
            return false;
        }
        if((pattern.charAt(0)<'0'||pattern.charAt(0)>'9')){
            if(input.charAt(0)!=pattern.charAt(0)){
                return false;
            }
            else{
                return match(input.substring(1),pattern.substring(1));
            }
        }
        else{
            int i=0;
            int num=0;
            while(i<pattern.length()&&((pattern.charAt(i))>='0')&&(pattern.charAt(i)<='9')){
                num=num*10+(pattern.charAt(i)-'0');
                i++;
            }
            if(num>input.length()){
                return false;
            }
            else{
                return match(input.substring(num),pattern.substring(i));
            }
        }
    }

    public static void main(String[] args) {
        StringAbrev s=new StringAbrev();
        boolean result=s.match(new String("student"),new String("s2d2t"));
        System.out.println(result);
    }
}
