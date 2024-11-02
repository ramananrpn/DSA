package dynamic_programming;

/*
Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).

Example 1:


Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
Output: 13
Explanation: There are two falling paths with a minimum sum as shown.
Example 2:


Input: matrix = [[-19,57],[-40,-5]]
Output: -59
Explanation: The falling path with a minimum sum is shown.


Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 100
-100 <= matrix[i][j] <= 100
* */

// https://leetcode.com/problems/minimum-falling-path-sum/description/

// TAGS : medium, dfs, dynamic_programming


import java.util.Arrays;

// without memoization causes TIME LIMIT EXCEEDED
public class MinimumFallingPathSum {
  public int minFallingPathSum(int[][] matrix) {
    // without memo
    int row = matrix.length;
    int col = matrix[0].length;

    // Iterate from the second last row to the first row
    for (int i = row - 2; i >= 0; i--) {
      for (int j = 0; j < col; j++) {
        // Get the minimum path sum from the row below
        int down = matrix[i + 1][j]; // directly below
        int downLeft = (j > 0) ? matrix[i + 1][j - 1] : Integer.MAX_VALUE; // down-left
        int downRight = (j < col - 1) ? matrix[i + 1][j + 1] : Integer.MAX_VALUE; // down-right

        // Update the current cell with the minimum path sum
        matrix[i][j] += Math.min(down, Math.min(downLeft, downRight));
      }
    }

    // The answer will be the minimum value in the first row
    int minSum = Integer.MAX_VALUE;
    for (int j = 0; j < col; j++) {
      minSum = Math.min(minSum, matrix[0][j]);
    }

    return minSum;
  }
}

// ----------------------------------------------------------------------
// USING DP memoization
// BEST SOLUTION
class MinimumFallingPathSumWithMemo {
  // with memo
  int[][] memo;
  public int minFallingPathSum(int[][] matrix) {
    int row = matrix.length;
    int col = matrix[0].length;
    int minSum = Integer.MAX_VALUE;

    // Memoization array to store the minimum path sum for each cell
    memo = new int[row][col];
    for (int i = 0; i < row; i++) {
      Arrays.fill(memo[i], Integer.MAX_VALUE);
    }


    for( int j = 0 ; j < col; j++) {
      minSum = Math.min(minSum, dfs(matrix, row, col, 0, j));
    }

    return minSum;
  }

  private int dfs(int[][] matrix, int row, int col, int i, int j) {
    if(i<0 || j <0 || i >= row || j >= col ) {
      return Integer.MAX_VALUE;
    }

    if(i== row-1) {
      return matrix[i][j];
    }

    if(memo[i][j] != Integer.MAX_VALUE) {
      return memo[i][j];
    }

    int left = dfs(matrix, row, col, i+1, j-1);
    int down = dfs(matrix, row, col, i+1, j);
    int right = dfs(matrix, row, col, i+1, j+1);


    memo[i][j] = matrix[i][j] + Math.min(left, Math.min(down, right));
    return memo[i][j];
  }
}

// -----------------------------------------------------------------------

// without MEMO accepted solution
class MinimumFallingPathSumWithOutMemo {
  public int minFallingPathSum(int[][] matrix) {
    // without memo
    int row = matrix.length;
    int col = matrix[0].length;

    // Iterate from the second last row to the first row
    for (int i = row - 2; i >= 0; i--) {
      for (int j = 0; j < col; j++) {
        // Get the minimum path sum from the row below
        int down = matrix[i + 1][j]; // directly below
        int downLeft = (j > 0) ? matrix[i + 1][j - 1] : Integer.MAX_VALUE; // down-left
        int downRight = (j < col - 1) ? matrix[i + 1][j + 1] : Integer.MAX_VALUE; // down-right

        // Update the current cell with the minimum path sum
        matrix[i][j] += Math.min(down, Math.min(downLeft, downRight));
      }
    }

    // The answer will be the minimum value in the first row
    int minSum = Integer.MAX_VALUE;
    for (int j = 0; j < col; j++) {
      minSum = Math.min(minSum, matrix[0][j]);
    }

    return minSum;
  }
}
