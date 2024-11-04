package backtracking.dfs;

// https://leetcode.com/problems/word-search/description/

/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example 1:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

Example 2:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true

Example 3:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
*/


// TAGS : medium, dfs, backtracking

public class WordSearch {
  public boolean exist(char[][] board, String word) {
    int m = board.length;
    int n = board[0].length;
    for(int i = 0; i < m ; i++) {
      for(int j = 0 ; j < n ; j++) {
        boolean match = traverse(board, word, m, n, i, j, 0);
        if(match) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean traverse(char[][] board, String word, int row, int col, int m, int n, int w) {
    if(w == word.length()) {
      return true;
    }

    if(m < 0 || m >= row || n < 0 || n >= col || board[m][n] == '*') {
      return false;
    }

    // when char matchs
    if(board[m][n] == word.charAt(w)) {
      char ch = board[m][n];
      board[m][n] = '*'; // visited
      w++; // incrementing word runner

      boolean match = traverse(board, word, row, col, m+1, n, w) ||
              traverse(board, word, row, col, m-1, n, w) ||
              traverse(board, word, row, col, m, n+1, w) ||
              traverse(board, word, row, col, m, n-1, w);
      // restore value
      board[m][n] = ch;
      return match;
    }
    // doesn't match
    else {
      return false;
    }
  }
}
