package backtracking.dfs;

/*
In a gold mine grid of size m x n, each cell in this mine has an integer representing the amount of gold in that cell, 0 if it is empty.

Return the maximum amount of gold you can collect under the conditions:

Every time you are located in a cell you will collect all the gold in that cell.
From your position, you can walk one step to the left, right, up, or down.
You can't visit the same cell more than once.
Never visit a cell with 0 gold.
You can start and stop collecting gold from any position in the grid that has some gold.


Example 1:

Input: grid = [[0,6,0],[5,8,7],[0,9,0]]
Output: 24
Explanation:
[[0,6,0],
 [5,8,7],
 [0,9,0]]
Path to get the maximum gold, 9 -> 8 -> 7.
Example 2:

Input: grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
Output: 28
Explanation:
[[1,0,7],
 [2,0,6],
 [3,4,5],
 [0,3,0],
 [9,0,20]]
Path to get the maximum gold, 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7.

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 15
0 <= grid[i][j] <= 100
There are at most 25 cells containing gold.
 */


// https://leetcode.com/problems/path-with-maximum-gold/description/

// TAGS: medium, dfs, array

class PathWithMaximumGold {
  public int getMaximumGold(int[][] grid) {
    int maxGold = 0;

    // Iterate over every cell in the grid to start DFS if the cell contains gold (>0)
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] > 0) {
          // Start DFS from each cell with gold and update maxGold
          maxGold = Math.max(maxGold, collectGold(grid, i, j));
        }
      }
    }

    return maxGold;
  }

  // DFS helper function to collect gold from the current cell
  private int collectGold(int[][] grid, int x, int y) {
    // If out of bounds or cell has no gold, return 0
    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) {
      return 0;
    }

    // Collect gold from the current cell
    int goldCollected = grid[x][y];

    // Mark this cell as visited by setting it to 0
    grid[x][y] = 0;

    // Explore all four directions
    int left = collectGold(grid, x, y - 1);
    int right = collectGold(grid, x, y + 1);
    int up = collectGold(grid, x - 1, y);
    int down = collectGold(grid, x + 1, y);

    // Find the maximum gold collected from all paths starting from this cell
    int maxGoldFromHere = goldCollected + Math.max(Math.max(left, right), Math.max(up, down));

    // Backtrack by resetting the cell value
    grid[x][y] = goldCollected;

    return maxGoldFromHere;
  }
}

