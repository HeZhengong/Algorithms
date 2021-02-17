package com.company.Recursion;

public class fibonacci {
    public int fibonacci(int K) {
        if(K<0){
            return 0;
        }
        if(K==0){
            return 0;
        }
        if(K==1){
            return 1;
        }
        else{
            return fibonacci(K-1)+fibonacci(K-2);
        }
    }

    public static void main(String[] args) {
        fibonacci s=new fibonacci();
        int result=s.fibonacci(-1);
        System.out.println(result);
    }
}
