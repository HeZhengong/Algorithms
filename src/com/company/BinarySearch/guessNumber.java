package com.company.BinarySearch;

public class guessNumber {
    public int guessNumber(int n, int guess) {
        int left=1;
        int right=n;
        while(left<right){
            int mid=left+(right-left)/2;
            if(mid<guess){
                left=mid+1;
            }
            else if(mid==guess){
                return mid;
            }
            else{
                right=mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        guessNumber s=new guessNumber();
        int result=s.guessNumber(10,6);
        System.out.println(result);
    }
}
