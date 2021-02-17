package com.company.Recursion;

public class JosephProblem {
    public int lastRemaining(int n, int m) {
        int answer=0;
        for(int i=2;i<=n;i++){
            answer=(answer+m)%i;
        }
        return answer;
    }

    public static void main(String[] args) {
        JosephProblem s=new JosephProblem();
        int result=s.lastRemaining(41,3);
        System.out.println(result);
    }
}
