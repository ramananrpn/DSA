package dynamic_programming;

/*
* Given an n x n integer matrix grid, return the minimum sum of a falling path with non-zero shifts.

A falling path with non-zero shifts is a choice of exactly one element from each row of grid such that no two elements chosen in adjacent rows are in the same column.

Example 1:


Input: grid = [[1,2,3],[4,5,6],[7,8,9]]
Output: 13
Explanation:
The possible falling paths are:
[1,5,9], [1,5,7], [1,6,7], [1,6,8],
[2,4,8], [2,4,9], [2,6,7], [2,6,8],
[3,4,8], [3,4,9], [3,5,7], [3,5,9]
The falling path with the smallest sum is [1,5,7], so the answer is 13.
Example 2:

Input: grid = [[7]]
Output: 7


Constraints:

n == grid.length == grid[i].length
1 <= n <= 200
-99 <= grid[i][j] <= 99
*
* */

// tags : hard, dynamic_programming

// https://leetcode.com/problems/minimum-falling-path-sum-ii/


import java.util.Arrays;

public class MinimumFallingPathSumII {
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
    int min = Integer.MAX_VALUE;

    for(int n = 0 ; n < col ; n++ ) {
      if (n!=j) {
        min = Math.min(min, dfs(matrix, row, col, i+1, n));
      }
    }


    memo[i][j] = matrix[i][j] + min;
    return memo[i][j];
  }
}

// ---------------------------------
// optimsed
// https://leetcode.com/problems/minimum-falling-path-sum-ii/solutions/5074097/simpler-faster-beast-99-fully-explained/

class MinimumFallingPathSumIISaveMinimum {
  public int minFallingPathSum(int[][] matrix) {
    int n = matrix.length;

    for (int i = 1; i < n; i++) {
      int minVal = Integer.MAX_VALUE, secondMinVal = Integer.MAX_VALUE, minIndex = -1;

      // Find the minimum and second minimum values in the previous row
      for (int j = 0; j < n; j++) {
        if (matrix[i - 1][j] < minVal) {
          secondMinVal = minVal;
          minVal = matrix[i - 1][j];
          minIndex = j;
        } else if (matrix[i - 1][j] < secondMinVal) {
          secondMinVal = matrix[i - 1][j];
        }
      }

      // Update the current row with the minimum sum for each cell
      for (int j = 0; j < n; j++) {
        if (j != minIndex) {
          matrix[i][j] += minVal;
        } else {
          matrix[i][j] += secondMinVal;
        }
      }
    }

    int minSum = Integer.MAX_VALUE;
    for (int val : matrix[n - 1]) {
      minSum = Math.min(minSum, val);
    }

    return minSum;
  }
}
