package com.company.StringI;

import com.company.LinkedList.RemoveDuplicates;

public class RemoveDepulicate {
    public String deDup(String input) {
        if(input==null||input.length()<1){
            return new String();
        }
        char[] array=input.toCharArray();
        int slow=0;
        for (int fast = 0; fast < array.length; fast++) {
            if(array[slow]!=array[fast]){
                array[slow+1]=array[fast];
                slow++;
            }
        }
        return new String(array,0,slow+1);
    }

    public static void main(String[] args) {
        RemoveDepulicate s=new RemoveDepulicate();
        String test="aaaabbbccc";
        String result=s.deDup(test);
        System.out.println(result);
    }
}
