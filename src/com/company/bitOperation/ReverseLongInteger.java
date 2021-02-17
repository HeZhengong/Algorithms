package com.company.bitOperation;

public class ReverseLongInteger {
    public long reverseBits(long n) {
        for(int offset=0;offset<16;offset++){
            long right=(n>>offset)&1L;
            long left=(n>>(31-offset))&1L;
            if(left!=right){
                n^=(1L<<offset);
                n^=(1L<<(31-offset));
            }
        }
        return n;
    }
    public long reverseBits(long n, int i, int j){
        long left_bit=((n>>i)&1);
        long right_bit=((n>>j)&1);
        if(left_bit!=right_bit){
            n^=((1<<i)|(1<<j));
        }
        return n;
    }

    public static void main(String[] args) {
        ReverseLongInteger s=new ReverseLongInteger();
        long result=s.reverseBits(new Long(1234));
        System.out.println(result);
    }

}
