package com.company.StringI;

import java.util.HashSet;
import java.util.Set;

public class RemoveCertainChar {
    public String remove(String input, String t) {
        Set<Character> set=new HashSet<>();
        for (int i = 0; i <t.length() ; i++) {
            set.add(t.charAt(i));
        }
        char[] array=input.toCharArray();
        int slow=0;
        for(int fast=0;fast<array.length;fast++){
            if(!set.contains(array[fast])){
                array[slow++]=array[fast];
            }
        }
        return new String(array,0,slow);
    }
}
