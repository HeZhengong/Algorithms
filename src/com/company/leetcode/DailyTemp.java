package com.company.leetcode;

public class DailyTemp {
    public int[] dailyTemperatures(int[] T) {
        if(T==null||T.length==0){
            return new int[]{};
        }
        int[] result=new int[T.length];
        int slow=0;
        int fast=0;
        for(int i=0;i<result.length;i++){
            if(slow<T.length){
                int day=0;
                while(fast<T.length){
                    if(T[slow]<T[fast]){
                        result[i]=day;
                        break;
                    }
                    else{
                        day++;
                        fast++;
                    }
                }
                if(fast==T.length){
                    result[i]=0;
                }
            }
            slow++;
            fast=slow;
        }
        return result;
    }

    public static void main(String[] args) {
        DailyTemp s= new DailyTemp();
        int[] array={};
        int[] result=s.dailyTemperatures(array);
        for (int i = 0; i <result.length ; i++) {
            System.out.println(result[i]);
        }
    }
}
