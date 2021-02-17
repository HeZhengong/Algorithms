package com.company.Sorting;

public class SortingTwoArrays {
    public int[] merge(int[] one, int[] two) {
        int[] result=new int[one.length+two.length];
        int oneCur=0;
        int twoCur=0;
        int resultCur=0;
        while(resultCur<result.length){
            while(oneCur!=one.length&&twoCur!=two.length){
                if(one[oneCur]<two[twoCur]){
                    result[resultCur]=one[oneCur];
                    oneCur++;
                }
                else{
                    result[resultCur]=two[twoCur];
                    twoCur++;
                }
                resultCur++;
            }
            if(oneCur==one.length&&twoCur<two.length){
                result[resultCur]=two[twoCur];
                twoCur++;
                resultCur++;
            }
            if(twoCur==two.length&&oneCur<one.length){
                result[resultCur]=one[oneCur];
                oneCur++;
                resultCur++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SortingTwoArrays s=new SortingTwoArrays();
        int[] array1={0,5,5,5,8,10};
        int[] array2={2,3,4,4,5,7};
        int[] array3={2};
        int[] array4={4};
        int[] result=s.merge(array3,array4);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
