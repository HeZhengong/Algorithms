package com.company.StringII;

import java.util.ArrayList;
import java.util.List;

public class StringReplace {
    public String replace(String input, String source, String target) {
        char[] array=input.toCharArray();
        if(source.length()>=target.length()){
            return replaceShorter(array,source,target);
        }
        return replaceLonger(array,source,target);
    }

    private String replaceLonger(char[] array, String source, String target) {
        ArrayList<Integer> matches=getAllMatches(array,source);
        char[] result=new char[array.length+matches.size()*(target.length()-source.length())];
        int lastIndex=matches.size()-1;
        int fast=array.length-1;
        int slow=result.length-1;
        while(fast>=0){
            if(lastIndex>=0&&fast==matches.get(lastIndex)){
                copySubString(result,slow-target.length()+1,target);
                slow-= target.length();
                fast-= source.length();
                lastIndex--;
            }
            else{
                result[slow--]=array[fast--];
            }
        }
        return new String(result);
    }

    private ArrayList<Integer> getAllMatches(char[] array, String source) {
        ArrayList<Integer> matches=new ArrayList<>();
        int i=0;
        while(i<=array.length-source.length()){
            if(equalSubString(array,i,source)){
                matches.add(i+source.length()-1);
                i+=source.length();
            }
            else {
                i++;
            }
        }
        return matches;
    }

    private String replaceShorter(char[] array, String source, String target) {
        int slow=0;
        int fast=0;
        while(fast<array.length){
            if(fast<=array.length-source.length()&&equalSubString(array,fast,source)){
                copySubString(array, slow,target);
                slow+=target.length();
                fast+=source.length();
            }
            else{
                array[slow++]=array[fast++];
            }
        }
        return new String(array,0,slow);
    }

    private void copySubString(char[] result, int slow, String target) {
        for(int i=0;i<target.length();i++){
            result[slow+i]=target.charAt(i);
        }
    }

    private boolean equalSubString(char[] array, int fast, String source) {
        for(int i=0;i<source.length();i++){
            if(array[fast+i]!=source.charAt(i)){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        StringReplace s=new StringReplace();
        String result=s.replace(new String("laicode"),new String("code"),new String("offer"));
        System.out.println(result);
    }
}
