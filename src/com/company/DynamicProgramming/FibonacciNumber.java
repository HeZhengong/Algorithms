package com.company.DynamicProgramming;

public class FibonacciNumber {
    public long fibonacci(int K) {
        if(K<=0){
            return 0;
        }
        long []fiboArray = new long[K+1];
        fiboArray[0] = 0;
        fiboArray[1] = 1;
        for (int i = 2; i <= K; i++) {
            fiboArray[i] = fiboArray[i-1]+fiboArray[i-2];
        }
        return fiboArray[K];
    }

    public static void main(String[] args) {
        FibonacciNumber s=new FibonacciNumber();
        System.out.println(s.fibonacci(80));
    }
}
