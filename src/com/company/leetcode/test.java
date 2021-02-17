package com.company.leetcode;

import com.company.HeapAndBFS.KthSmallest;

import java.util.Comparator;
import java.util.PriorityQueue;

public class test {
    public int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        PriorityQueue<Cell> pq = new PriorityQueue<>(k, new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                if (o1.val == o2.val) {
                    return 0;
                }
                return o1.val > o1.val ? 1 : -1;
            }
        });

        boolean[][] visited = new boolean[row][col];
        pq.offer(new Cell(0, 0, matrix[0][0]));
        visited[0][0] = true;

        for (int i = 0; i < k - 1; i++) {
            Cell cur = pq.poll();
            if (cur.row + 1 < row && !visited[cur.row + 1][cur.col]) {
                pq.offer(new Cell(cur.row + 1, cur.col, matrix[cur.row + 1][cur.col]));
                visited[cur.row+1][cur.col]=true;
            }
            if (cur.col + 1 < col && !visited[cur.row][cur.col + 1]) {
                pq.offer(new Cell(cur.row, cur.col + 1, matrix[cur.row][cur.col + 1]));
                visited[cur.row][cur.col+1]=true;
            }
        }
        return pq.peek().val;
    }

    static class Cell {
        int row;
        int col;
        int val;

        Cell(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
    public static void main(String[] args) {
        KthSmallest s=new KthSmallest();
        int[][] matrix={{1,3,5,7},{2,4,8,9},{3,5,11,15},{6,8,13,18}};
        int result=s.kthSmallest(matrix,6);
        System.out.println(result);
    }
}
