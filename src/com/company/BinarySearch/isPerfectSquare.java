package com.company.BinarySearch;

public class isPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if(num<2){
            return true;
        }
        else{
            long left=2;
            long right=num/2;
            while(left<=right){
                long mid=left+(right-left)/2;
                if(mid*mid==num){
                    return true;
                }
                else if(mid*mid<num){
                    left=mid+1;
                }
                else{
                    right=mid-1;
                }
            }
            return false;
        }

    }

    public static void main(String[] args) {
        isPerfectSquare s= new isPerfectSquare();
        System.out.println(s.isPerfectSquare(808201));
        System.out.println(Math.sqrt(808201));
    }
}
