package com.company.StringII;

import java.io.InputStream;

public class StringCompress {
    public String compress(String input) {
        if(input==null||input.isEmpty()){
            return input;
        }
        char[] array=input.toCharArray();
        return encode(array);
    }

    private String encode(char[] array) {
        int slow=0;
        int fast=0;
        int newLength=0;
        while(fast<array.length){
            int begin=fast;
            while(fast<array.length&&array[fast]==array[begin]){
                fast++;
            }
            array[slow++]=array[begin];
            if(fast-begin==1){
                newLength+=2;
            }
            else{
                int len=copyDigits(array,slow,fast-begin);
                slow+=len;
                newLength+=len+1;
            }
        }
        char[] result=new char[newLength];
        fast=slow-1;
        slow=newLength-1;
        while(fast>=0){
            if(Character.isDigit(array[fast])){
                while(fast>=0&&Character.isDigit(array[fast])){
                    result[slow]=array[fast];
                    slow--;
                    fast--;
                }
            }
            else{
                result[slow]='1';
                slow--;
            }
            result[slow]=array[fast];
            slow--;
            fast--;
        }
        return new String(result);
    }

    private int copyDigits(char[] array, int slow, int count) {
        int len=0;
        for(int i=count;i>0;i/=10){
            slow++;
            len++;
        }
        for(int i=count;i>0;i/=10){
            int digit=i%10;
            array[--slow]=(char)('0'+digit);
        }
        return len;
    }

    public static void main(String[] args) {
        StringCompress s=new StringCompress();
        String input="aaaaabbbbbbcccccccccc";
        String result=s.compress(input);
        System.out.println(result);
    }
}
