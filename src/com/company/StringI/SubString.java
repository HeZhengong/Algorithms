package com.company.StringI;

import java.util.ArrayList;
import java.util.List;

public class SubString {
        public int strstr(String large, String small) {
            if(large==null||small==null||large.length()<small.length()){
                return -1;
            }
            if(small.length()==0){
                return 0;
            }
            for(int i=0;i<=large.length()-small.length();i++){
                int j=0;
                while(j<small.length()&&large.charAt(i+j)==small.charAt(j)){
                    j++;
                }
                if(j==small.length()){
                    return i;
                }
            }
            return -1;
        }

    public List<Integer> strstr1(String large, String small) {
        List<Integer> result=new ArrayList<>();
        if(large==null||small==null||large.length()<small.length()){
            return result;
        }
        if(small.length()==0){
            return result;
        }
        for(int i=0;i<=large.length()-small.length();i++){
            int j=0;
            while(j<small.length()&&large.charAt(i+j)==small.charAt(j)){
                j++;
            }
            if(j==small.length()){
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SubString s=new SubString();
        List<Integer> result=s.strstr1(new String("abbabbbab"), new String("bbab"));
        System.out.println(result);
    }
}
