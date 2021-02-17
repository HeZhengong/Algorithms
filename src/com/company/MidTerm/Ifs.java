package com.company.MidTerm;

import java.util.List;

public class Ifs {
    public void ifs(int n){
        if(n<=0){
            return;
        }
        char[] cur=new char[2*n];
        helper(n,n,0,cur);
    }

    private void helper(int leftBracket, int rightBracket, int index, char[] cur) {
        if(leftBracket==0&&rightBracket==0){
            printBlock(cur);
            return;
        }
        if(leftBracket>0){
            cur[index]='{';
            helper(leftBracket-1,rightBracket,index+1,cur);
        }
        if(rightBracket>0){
            cur[index]='}';
            helper(leftBracket,rightBracket-1,index+1,cur);
        }
    }

    private void printBlock(char[] cur) {
        int space=0;
        for (int i = 0; i < cur.length; i++) {
            if(cur[i]=='{'){
                printSpace(space);
                System.out.println("if{");
                space+=2;
            }
            else{
                space-=2;
                printSpace(space);
                System.out.println("}");
            }
        }
        System.out.println();
    }

    private void printSpace(int space) {
        while (space > 0) {
            System.out.print(" ");
        }
        space--;
    }
}
