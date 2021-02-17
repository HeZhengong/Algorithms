package com.company.HeapAndBFS;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        int row=matrix.length;
        int col=matrix[0].length;
        PriorityQueue<Cell> minHeap = new PriorityQueue<>(k, new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                if(o1.value==o2.value){
                    return 0;
                }
                return o1.value<o2.value?-1:1;
            }
        });

        boolean[][]visited=new boolean[row][col];
        minHeap.offer(new Cell(0,0,matrix[0][0]));
        visited[0][0]=true;

        for (int i = 0; i <k-1 ; i++) {
            Cell cur=minHeap.poll();
            if(cur.row+1<row&&!visited[cur.row+1][cur.column]){
                minHeap.offer(new Cell(cur.row+1,cur.column,matrix[cur.row+1][cur.column]));
                visited[cur.row+1][cur.column]=true;
            }
            if(cur.column+1<col&&!visited[cur.row][cur.column+1]){
                minHeap.offer(new Cell(cur.row,cur.column+1,matrix[cur.row][cur.column+1]));
                visited[cur.row][cur.column+1]=true;
            }
        }
        return minHeap.peek().value;
    }

    static class Cell{
        int row;
        int column;
        int value;

        Cell(int row, int column, int value){
            this.row=row;
            this.column=column;
            this.value=value;
        }
    }

    public static void main(String[] args) {
        KthSmallest s=new KthSmallest();
        int[][] matrix={{1,2},{2,3}};
        int result=s.kthSmallest(matrix,3);
        System.out.println(result);
    }
}
