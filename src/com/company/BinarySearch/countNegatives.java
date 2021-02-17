package com.company.BinarySearch;

public class countNegatives {
    public int countNegatives(int[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        int count=0;
        for(int i=0; i<r;i++){
            if(grid[i][0]<0){
                count+=grid[i].length;
            }
            else if(grid[i][grid[i].length-1]>0){
                continue;
            }
            else{
                int left=0;
                int right=grid[0].length-1;
                while(left<right-1){
                    int mid=left+(right-left)/2;
                    if(grid[i][mid]>=0){
                        left=mid+1;
                    }
                    else{
                        right=mid;
                    }
                }
                if(grid[i][left]<0){
                    count+=grid[i].length-left;
                }
                else if(grid[i][right]<0){
                    count+=grid[i].length-right;
                }
            }
        }
        return count;


    }

    public static void main(String[] args) {
        countNegatives s=new countNegatives();
        int [][] grid={{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        int result=s.countNegatives(grid);
        System.out.println(result);
    }
}
