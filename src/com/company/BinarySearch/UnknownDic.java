package com.company.BinarySearch;

import java.util.Arrays;

public class UnknownDic implements Dictionary{
    private int[] array;
    public UnknownDic(int[] array){
        this.array=array;
    }

    @Override
    public Integer get(int index) {
        if(array==null||index>=array.length){
            return null;
        }
        return array[index];
    }
    public String toString(){
        if(array==null){
            return String.valueOf(null);
        }
        if(array.length<=10){
            return Arrays.toString(array);
        }

        StringBuilder sb=new StringBuilder("[");
        for (int i = 0; i < 5; i++) {
            sb.append(array[i]);
            if(i!=array.length-1){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
