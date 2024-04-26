package array;

/*
You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.



Example 1:
Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.

Example 2:
Input: grid = [[0,0,0,0,0,0,0,0]]
Output: 0

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 50
grid[i][j] is either 0 or 1.
* */

// TAGS: medium, take_for_interview, google

public class MaxAreaOfIsland {
    int m, n;
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int max = 0;
        for(int row = 0; row < m ; row++){
            for(int col = 0; col < n; col++) {
                if(grid[row][col] == 0) continue;

                max = Math.max(max, findRegion(grid, row, col));
            }
        }
        return max;
    }

    private int findRegion(int[][] grid, int row, int col) {
        if(row >= m || col >= n || row < 0 || col < 0 || grid[row][col] == 0 ){
            return 0;
        }
        grid[row][col] = 0;

        return 1 + findRegion(grid, row + 1, col)
                + findRegion(grid, row - 1, col)
                + findRegion(grid, row, col - 1)
                + findRegion(grid, row, col + 1);
    }
}

// ------------------- TEMPLATE CODE -------------------
/*
public class Main {
    public static void main(String[] args) {
        MaxAreaOfIsland solution = new MaxAreaOfIsland();

        int[][] grid1 = {
            {0,0,1,0,0,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,1,1,0,1,0,0,0,0,0,0,0,0},
            {0,1,0,0,1,1,0,0,1,0,1,0,0},
            {0,1,0,0,1,1,0,0,1,1,1,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };

        int maxArea = solution.maxAreaOfIsland(grid1);
        System.out.println("Maximum Area of Island: " + maxArea);
    }
}
* */
