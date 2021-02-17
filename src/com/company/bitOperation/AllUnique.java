package com.company.bitOperation;

public class AllUnique {
    public boolean allUnique(String word) {
        boolean[] wordExist=new boolean[256];
        for(int i=0;i<word.length();i++){
            int charNow=word.charAt(i);
            if(wordExist[charNow]){
                return false;
            }
            else{
                wordExist[charNow]=true;
            }
        }
        return true;
    }
}
