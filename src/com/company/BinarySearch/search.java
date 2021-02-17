package com.company.BinarySearch;

public class search {
    public int search(int[] array, int target) {
        if(array.length==0||array==null){
            return -1;
        }
        int left=0;
        int right=array.length-1;
        while(left<right-1){
            int mid=left+(right-left)/2;

            while(left<mid&&array[left]==array[mid]){
                left++;
            }             //pre-processing for deduplication


            if(array[mid]==target){
                right=mid;
            }
            else if(array[mid]>=array[left]){
                if(target<=array[mid]&&target>=array[left]){
                    right=mid-1;
                }
                else{
                    left=mid;
                }
            }
            else{
                if(target>array[mid]&&target<=array[right]){
                    left=mid+1;
                }
                else{
                    right=mid;
                }
            }
        }          //binarySearch


        if(array[left]==target){
            return left;
        }
        else if(array[right]==target){
            return right;
        }
        else {
            return -1;
        }     //post-processing
    }

    public static void main(String[] args) {
        search s=new search();
        int []array={399,400,403,404,406,407,416,417,418,419,420,422,427,428,429,430,436,441,442,443,448,449,455,456,458,462,463,464,467,468,469,470,473,477,481,484,486,489,491,492,494,496,497,498,499,501,506,508,511,513,516,342,343,344,348,349,351,355,362,366,367,369,372,375,376,377,379,380,381,384,386,388,394,397,398};
        int []array1={3,3,3,3,3,3,3,3,3,3,3,3,3,3,1,3};
        int result=s.search(array,355);
        System.out.println(result);
    }
}
