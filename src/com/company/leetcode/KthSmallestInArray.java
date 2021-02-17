package com.company.leetcode;

import com.company.HeapAndBFS.KthSmallest;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestInArray {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Cell> minHeap=new PriorityQueue<>(k, new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                if(o1.val==o2.val){
                    return 0;
                }
                return o1.val>o2.val?1:-1;
            }
        });
        boolean[][] visited=new boolean[matrix.length][matrix[0].length];
        minHeap.offer(new Cell(0,0,matrix[0][0]));
        for(int i=0;i<k-1;i++){
            Cell Cur=minHeap.poll();
            if(Cur.row+1<matrix.length&&!visited[Cur.row+1][Cur.col]){
                minHeap.offer(new Cell(Cur.row+1, Cur.col,matrix[Cur.row+1][Cur.col]));
                visited[Cur.row+1][Cur.col]=true;
            }
            if(Cur.col+1<matrix[0].length&&!visited[Cur.row][Cur.col+1]){
                minHeap.offer(new Cell(Cur.row,Cur.col+1,matrix[Cur.row][Cur.col+1]));
                visited[Cur.row][Cur.col+1]=true;
            }
        }
        return minHeap.poll().val;
    }

    static class Cell{
        int row;
        int col;
        int val;

        public Cell(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        KthSmallestInArray s=new KthSmallestInArray();
        int[][] test={{1,5,9},{10,11,13},{12,13,15}};
        System.out.println(s.kthSmallest(test,6));
    }
}
