package com.company.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CommonLongest {
    public int findLength(int[] A, int[] B) {
        int Alen=A.length;
        int Blen=B.length;
        int result=0;
        for(int i=0;i<Blen;i++){
            int len=Math.min(Alen,Blen-i);
            int maxLen=maxLength(A,B,i,0,len);
            result=Math.max(result,maxLen);
        }
        for(int i=0;i<Alen;i++){
            int len=Math.min(Blen,Alen-i);
            int maxLen=maxLength(A,B,0,i,len);
            result=Math.max(result,maxLen);
        }
        return result;

    }

    private int maxLength(int[] a, int[] b, int addA, int addB, int len) {
        int result=0;
        int length=0;
        for (int i = 0; i < len; i++) {
            if(a[addA+i]==b[addB+i]){
                length++;
            }
            else{
                length=0;
            }
            result=Math.max(length,result);
        }
        return result;
    }

    public static void main(String[] args) {
        CommonLongest s=new CommonLongest();
        int[] A={0,1,1,1,1};
        int[] B={1,0,1,0,1};
        System.out.println(s.findLength(A,B));
    }
}
