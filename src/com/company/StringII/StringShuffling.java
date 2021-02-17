package com.company.StringII;

public class StringShuffling {
    public int[] reorder(int[] array) {
        if(array.length%2==0){
            reorder(array,0,array.length-1);
        }
        else{
            reorder(array,0,array.length-2);
        }
        return array;
    }

    private void reorder(int[] array, int left, int right) {
        int length=right-left+1;
        if(length<=2){
            return;
        }
        int mid=left+length/2;
        int lMid=left+length/4;
        int rMid=left+3*length/4;
        reverse(lMid,mid-1,array);
        reverse(mid,rMid-1,array);
        reverse(lMid,rMid-1,array);
        reorder(array,left,left+(lMid-left)*2-1);
        reorder(array,left+(lMid-left)*2,right);
    }
    private void reverse(int left, int right, int[] s) {
        if(left>=right){
            return;
        }
        int temp=s[left];
        s[left]=s[right];
        s[right]=temp;
        reverse(left+1,right-1,s);
    }

    public static void main(String[] args) {
        StringShuffling s=new StringShuffling();
        int[] test={1,2,3,4,5,6};
        int[] result=s.reorder(test);
        for (int i = 0; i <result.length ; i++) {
            System.out.println(result[i]);
        }
    }
}
