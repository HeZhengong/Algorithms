package com.company.StringI;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MissingNumberI {
    public int missing(int[] array) {
        int length=array.length+1;
        HashSet<Integer> set=new HashSet<>();
        for (int number:array) {
            set.add(number);
        }
        for(int i=1;i<length;i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        String test1="ZTMNPXTNECFAPEQEFKECNPCJTTMNZCWSENPONTMJSWZTNWSTFWSVPXTFWVFEFWCFEBFCWVTFXTFXEVQEAVFGVOENWKCFAAEAVXCWEAWTWSERNTRTPVWVTFWSCWCGGLEFCNEXNECWEAEYMCG";
        System.out.println(test1.length());
        MissingNumberI s=new MissingNumberI();
        int[]test={1,2,4};
        int answer=s.missing(test);
        System.out.println(answer);
    }
}
