package com.company.StringII;

import org.omg.PortableServer.ServantLocatorPOA;

import java.awt.*;

public class StringDepress {
    public String decompress1(String input) {
        char[] array=input.toCharArray();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<array.length;i++){
            char ch=array[i++];
            int count=array[i]-'0';
            for(int j=0;j<count;j++){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    public String decompress(String input){
        if(input==null||input.length()<=1){
            return input;
        }
        char[] array=input.toCharArray();
        return decompressLong(array,decompressShort(array));
    }

    private String decompressLong(char[] array, int length) {
        int newLength=length;
        for(int i=0;i<length;i++){
            int digit=getDigit(array[i]);
            if(digit>2&&digit<=9){
                newLength+=digit-2;
            }
        }
        char[] result=new char[newLength];
        int end=newLength-1;
        for(int i=length-1;i>=0;i--){
            int digit=getDigit(array[i]);
            if(digit>2&&digit<=9){
                i--;
                for(int j=0;j<digit;j++){
                    result[end--]=array[i];
                }
            }
            else{
                result[end--]=array[i];
            }
        }
        return new String(result);
    }

    private int decompressShort(char[] array) {
        int slow=0;
        for(int fast=0;fast<array.length;fast+=2){
            int digit=getDigit(array[fast+1]);
            if(digit>=0&&digit<=2) {
                for (int j = 0; j < digit; j++) {
                    array[slow] = array[fast];
                    slow++;
                }
            }
            else{
                    array[slow++]=array[fast];
                    array[slow++]=array[fast+1];
            }
        }
        return slow;
    }

    private int getDigit(char arr){
        return arr-'0';
    }

    public static void main(String[] args) {
        StringDepress s=new StringDepress();
        String result=s.decompress(new String("A6B8C1D8"));
        System.out.println(result);
    }
}
