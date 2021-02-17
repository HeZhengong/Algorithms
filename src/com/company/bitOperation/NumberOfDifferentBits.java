package com.company.bitOperation;

public class NumberOfDifferentBits {
    public int diffBits(int a, int b) {
        int c=a^b;
        int count=0;
        while(c!=0){
            if((c&1)!=0){
                count++;
            }
            c = c>>>1;
        }
        return count;
    }
}
