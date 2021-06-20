package array;


//https://leetcode.com/problems/search-a-2d-matrix/
// TAGS: medium, binary_search, google, amazon, facebook, microsoft, yahoo, nvidia


/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

        Integers in each row are sorted from left to right.
        The first integer of each row is greater than the last integer of the previous row.

        Example 1:
        Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
        Output: true

        Example 2:
        Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
        Output: false

        Constraints:
        m == matrix.length
        n == matrix[i].length
        1 <= m, n <= 100
        -104 <= matrix[i][j], target <= 104
*/

// own-code
 class SearchA2DMatrixBruteForce {
     public boolean searchMatrix(int[][] matrix, int target) {
         int row = matrix.length;
         int col = matrix[0].length;

         if(target < matrix[0][0] || target > matrix[row-1][col-1]) return false;

         for(int i = 0; i< row ; i++) {
             if(target <= matrix[i][col-1]){
                 for(int j = 0; j < col; j++){
                     if(matrix[i][j] == target){
                         return true;
                     }
                 }
             }
         }

         return false;

     }
 }

// ----------------------BINARY SEARCH----------------------

/* HINT :
idx = low + high / 2; // mid
row = idx / n
col = idx % n
*/

class SearchA2DMatrixBinarySearch {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0)
            return false;
        int n = matrix[0].length;

        // binary search
        int left = 0, right = m * n - 1;
        int pivotIdx, pivotElement;
        while (left <= right) {
            pivotIdx = (left + right) / 2;

            // important
            pivotElement = matrix[pivotIdx / n][pivotIdx % n];

            if (target == pivotElement)
                return true;
            else {
                if (target < pivotElement)
                    right = pivotIdx - 1;
                else
                    left = pivotIdx + 1;
            }
        }
        return false;
    }
}