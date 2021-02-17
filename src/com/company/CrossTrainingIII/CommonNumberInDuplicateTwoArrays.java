package com.company.CrossTrainingIII;

import java.util.*;

public class CommonNumberInDuplicateTwoArrays {
    public List<Integer> common(int[] A, int[] B) {
        List<Integer> result=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            Integer number=map.get(A[i]);
            if(number==null){
                map.put(A[i],1);
            }
            else{
                map.put(A[i],number+1);
            }
        }
        Arrays.sort(B);
        for (int i = 0; i < B.length; i++) {
            Integer number=map.get(B[i]);
            if(number!=null&&number!=0){
                result.add(B[i]);
                map.put(B[i],number-1);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        CommonNumberInDuplicateTwoArrays s=new CommonNumberInDuplicateTwoArrays();
        int[] a={1,2,3};
        int[] b={3,1,4,3,3,3};
        System.out.print(s.common(a,b));
    }
}
