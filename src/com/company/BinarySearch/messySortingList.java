package com.company.BinarySearch;

public class messySortingList {
    public int minArray(int[] numbers) {
        int left=0;
        int right=numbers.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(numbers[mid]>numbers[right]){
                left=mid+1;
            }
            else if(numbers[mid]==numbers[right]){
                right--;
            }
            else{
                right=mid;
            }

        }
        return numbers[left];
    }

    public static void main(String[] args) {
        messySortingList solution= new messySortingList();
        int []a={10,1,10,10,10,10};
        int result=solution.minArray(a);
        System.out.println(result);
    }

}
