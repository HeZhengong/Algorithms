package com.company.BinarySearch;

public class SearchInSortedMatrixI {
    public int[] search(int[][] matrix, int target) {
        int row = matrix[0].length;
        int col = matrix.length;
        int left = 0;
        int right = row * col - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midRow = mid / row;
            int midCol = mid % row;
            if (matrix[midRow][midCol] < target) {
                left = mid + 1;
            } else if (matrix[midRow][midCol] > target) {
                right = mid - 1;
            } else {
                return new int[]{midRow, midCol};
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        SearchInSortedMatrixI test = new SearchInSortedMatrixI();
        int [] result = test.search(new int[][]{{1, 2, 3, 4}},4);
        System.out.println(result);
    }
}
