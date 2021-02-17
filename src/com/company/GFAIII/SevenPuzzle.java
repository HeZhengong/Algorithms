package com.company.GFAIII;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class SevenPuzzle {

    static class Board {
        public final static int R = 2;
        public final static int C = 4;

        private int[][] board = new int[R][C];

        public Board() {
        }

        public Board(int[] value) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    board[i][j] = value[i * C + j];
                }
            }
        }

        public void swap(int i1, int j1, int i2, int j2) {
            int temp = board[i1][j1];
            board[i1][j1] = board[i2][j2];
            board[i2][j2] = temp;
        }

        public int[] findZero() {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (board[i][j] == 0) {
                        return new int[]{i, j};
                    }
                }
            }
            return null;
        }

        public boolean outOfBound(int i, int j) {
//            if (i >= R || i < 0) {
//                return false;
//            }
//            if (j >= C || j < 0) {
//                return false;
//            }
//            return true;
            return i<0||i>=R||j<0||j>=C;
        }

        public int hashCode() {
            int code = 0;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    code = code * 10 + board[i][j];
                }
            }
            return code;
        }

        public boolean equals(Object o) {
            if (!(o instanceof Board)) {
                return false;
            }
            Board b = (Board) o;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (board[i][j] != b.board[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        }

        public Board clone() {
            Board c = new Board();
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    c.board[i][j] = board[i][j];
                }
            }
            return c;
        }
    }
        final static int[][] DIRS={{-1,0},{1,0},{0,-1},{0,1}};

        public int numOfSteps(int[] values) {
            Queue<Board> queue=new ArrayDeque<>();
            Map<Board,Integer> boardStep=new HashMap<>();

            Board start=new Board(new int[]{0,1,2,3,4,5,6,7});
            queue.offer(start);
            boardStep.put(start,0);

            while(!queue.isEmpty()){
                Board board=queue.poll();
                int step=boardStep.get(board);

                int[] zeroPos=board.findZero();
                int zeroI = zeroPos[0];
                int zeroJ = zeroPos[1];

                for (int[] dir:DIRS) {
                     int i=zeroI+dir[0];
                     int j=zeroJ+dir[1];
                     if(!board.outOfBound(i,j)){
                        board.swap(zeroI,zeroJ,i,j);
                        if(!boardStep.containsKey(board)){
                            Board newBoard=board.clone();
                            queue.offer(newBoard);
                            boardStep.put(newBoard,step+1);
                        }
                        board.swap(zeroI,zeroJ,i,j);
                     }
                }
            }
            return boardStep.getOrDefault(new Board(values),-1);
        }

    public static void main(String[] args) {
        SevenPuzzle s=new SevenPuzzle();
        System.out.println(s.numOfSteps(new int[]{4,1,2,3,5,0,6,7}));
        
    }
}

