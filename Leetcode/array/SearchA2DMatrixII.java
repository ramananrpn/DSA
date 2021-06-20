package array;

// https://leetcode.com/problems/search-a-2d-matrix-ii/
// TAGS : medium, binary_search, 2d_array, amazon, microsoft, facebook

/*
* Write an efficient algorithm that searches for a target value in an m x n integer matrix. The matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.

Example 1:
Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
Output: true

Example 2:
Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
Output: false

Constraints:
m == matrix.length
n == matrix[i].length
1 <= n, m <= 300
-109 <= matix[i][j] <= 109
All the integers in each row are sorted in ascending order.
All the integers in each column are sorted in ascending order.
-109 <= target <= 109
*/

public class SearchA2DMatrixII {
}

// ---------------- Binary Search -----------------
 class SearchA2DMatrixIIBinarySearch {
     public boolean searchMatrix(int[][] matrix, int target) {
         int shorterDim = Math.min(matrix.length, matrix[0].length);

         // Iterating for every dimention
         for(int i = 0 ; i< shorterDim ; i++) {
             boolean verical = binarySearch(matrix, target, i, true);
             boolean horizontal = binarySearch(matrix, target, i, false);

             if(verical || horizontal){
                 return true;
             }
         }
         return false;
     }

     private boolean binarySearch(int[][] m, int target, int start, boolean isVertical) {
         int low = start;
         int high = isVertical ? m.length -1 : m[0].length - 1 ;

         while(low<=high) {
             int mid = (low + high)/ 2;
             if(isVertical) { // seraching through column (vertical)
                 if(m[mid][start] < target){
                     low = mid+1;
                 }
                 else if(m[mid][start] > target) {
                     high = mid-1;
                 }
                 else {
                     return true;
                 }
             }
             else { // seraching through row (horizontal)
                 if(m[start][mid] < target){
                     low = mid+1;
                 }
                 else if(m[start][mid] > target) {
                     high = mid-1;
                 }
                 else {
                     return true;
                 }
             }
         }
         return false;
     }
 }
 //Time complexity : O(log(n!))


// ------------------ Search Space Reduction ---------------------

class SearchA2DMatrixIISearchSpaceReduction {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = 0;

        while(row >= 0 && col < matrix[0].length){
            if(matrix[row][col] > target){
                row--;
            }
            else if(matrix[row][col] < target) {
                col++;
            }
            else{
                return true;
            }
        }

        return false;
    }
}
// Time complexity : O(n+m)
