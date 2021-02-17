package com.company.StringI;

import com.company.LinkedList.RemoveDuplicates;

public class RemoveSpaces {
    public String removeSpaces(String input) {
        char[] array=input.toCharArray();
        int slow=0;
        for(int fast=0;fast<array.length;fast++){
            if(array[fast]==' '){
                if(fast!=0&&array[fast-1]!=' '){
                    array[slow++]=array[fast];
                }
            }
            else{
                array[slow++]=array[fast];
            }
        }
        if(slow>0&&array[slow-1]==' '){
            slow--;
        }
        return new String(array,0,slow);
    }

    public static void main(String[] args) {
        RemoveSpaces s=new RemoveSpaces();
        String test="                 I am     a      man  .";
        String result=s.removeSpaces(test);
        System.out.println(result);
    }
}
