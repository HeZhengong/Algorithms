package com.company.BinarySearch;

public class UnknownDicMain {
    public int binarySearch(int left, int right, int target, Dictionary dict){

        while(left<=right&&dict.get(left)!=null){
            int mid=left+(right-left)/2;
            if(dict.get(mid)==null||target<dict.get(mid)){           //target==dict.get(mid)
                right=mid-1;
            }
            else if(target==dict.get(mid)){          //target<dict.get(mid)||dict.get(mid)==null
                return mid;
            }
            else{
                left=mid+1;
            }
        }
        return -1;
    }
    public int search(Dictionary dict, int target) {
        if(dict==null){
            return -1;
        }
        int left=0;
        int right=1;

        while(dict.get(right)!=null&&dict.get(right)<target){
            left=right;
            right=2*right;
        }
        return binarySearch(left,right,target,dict);
    }
}
