package com.company.CrossTrainingI;

public class Move0sToTheEnd {
    public int[] moveZero(int[] array) {
        if(array.length<=1){
            return array;
        }
        int slow=0;
        int fast=0;
        while(fast<array.length){
            if(array[fast]==0){
                fast++;
            }
            else if(array[slow]!=0){
                slow++;
                fast++;
            }
            else{
                swap(array,slow++,fast++);
            }
        }
        return array;
    }

    public void swap(int[] array, int left, int right){
        int temp=array[left];
        array[left]=array[right];
        array[right]=temp;
    }

    public static void main(String[] args) {
        Move0sToTheEnd s=new Move0sToTheEnd();
        int[] test={3,4,0,0,1,2};
        int[] result=s.moveZero(test);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
