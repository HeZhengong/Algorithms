package com.company.Recursion;

public class apowerb {
    public double myPow(double a, int b) {
        long N=b;
        if(N>0){
            return powerAB(a,N);
        }
        else if(N==0){
            return 1;
        }
        else {
            return 1.0/powerAB(a,-N);
        }
    }
    public double powerAB(double a, long b){
            if (b == 0) {
                return 1;
            }
            double halfResult = powerAB(a, b / 2);
            if (b % 2 == 1) {
                return halfResult * halfResult * a;
            } else {
                return halfResult * halfResult;
            }
    }

    public static void main(String[] args) {
        apowerb s=new apowerb();
        double result=s.myPow(1,-2147483648);
        System.out.println(result);
    }
}
