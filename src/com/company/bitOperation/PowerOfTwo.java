package com.company.bitOperation;

public class PowerOfTwo {
    public boolean isPowerOfTwo(int number) {
        int count=0;
        for(int i=0;i<32;i++){
            if((number>>i&1)==1){
                count++;
            }
        }
        return count==1;
    }

    public static void main(String[] args) {
        PowerOfTwo s=new PowerOfTwo();
        System.out.println(s.isPowerOfTwo(2));
    }
}
