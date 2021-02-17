package com.company.CrossTrainingIII;

import java.util.*;

public class CommonNumberInTwoArrays {
    public List<Integer> common(int[] a, int[] b) {
        Set<Integer> hashSet=new HashSet<>();
        List<Integer> result=new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            hashSet.add(a[i]);
        }
        Arrays.sort(b);
        for (int i = 0; i < b.length; i++) {
            if(hashSet.contains(b[i])){
                result.add(b[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CommonNumberInTwoArrays s=new CommonNumberInTwoArrays();
        int[] a={1,2,3};
        int[] b={3,1,4};
        System.out.print(s.common(a,b));
    }
}
