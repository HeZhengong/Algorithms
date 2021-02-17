package com.company.StringII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllAnagrams {
    public List<Integer> allAnagrams(String sh, String lo) {
        List<Integer> result=new ArrayList<>();
        if(sh.length()==0||lo.length()<sh.length()){
            return result;
        }
        Map<Character,Integer> map=countMap(sh);
        int match=0;
        for (int i = 0; i <lo.length(); i++) {
            char tmp=lo.charAt(i);
            Integer count=map.get(tmp);
            if(count!=null){
                map.put(tmp,count-1);
                if(count==1){
                    match++;
                }
            }
            if(i>=sh.length()){
                tmp=lo.charAt(i-sh.length());
                count=map.get(tmp);
                if(count!=null){
                    map.put(tmp,count+1);
                    if(count==0){
                        match--;
                    }
                }
            }
            if(match==map.size()){
                result.add(i-sh.length()+1);
            }
        }
        return result;
    }

    private Map<Character, Integer> countMap(String lo) {
        Map<Character, Integer> map=new HashMap<>();
        for (char s: lo.toCharArray()) {
            Integer count=map.get(s);
            if(map.containsKey(s)){
                map.put(s,count+1);
            }
            else{
                map.put(s,1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        AllAnagrams s=new AllAnagrams();
        String sh="abcabasabc";
        String lo="abca";
        List<Integer> result=s.allAnagrams(lo,sh);
        System.out.println(result);
    }
}
