package com.company.BinarySearch;

public class UnknownMain {
    public static void main(String[] args) {
        UnknownDicMain main=new UnknownDicMain();
        Dictionary dict=new UnknownDic(new int[]{1,3});
        int target=4;
        System.out.println(main.search(dict,target));
    }
}
