package com.company.bitOperation;

public class Hexada {
    public String hex(int number) {
        if(number==0){
            return "0x0";
        }
        StringBuilder sb=new StringBuilder();
        char[] hex={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        while(number>0){
            int reminder=number%16;
            sb.append(hex[reminder]);
            number/=16;
        }
        sb.append("x0");
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        Hexada s=new Hexada();
        System.out.println(s.hex(18));
    }
}
