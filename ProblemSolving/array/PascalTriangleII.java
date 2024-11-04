package array;

// https://leetcode.com/problems/pascals-triangle-ii/description/

/*
Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Example 1:

Input: rowIndex = 3
Output: [1,3,3,1]
Example 2:

Input: rowIndex = 0
Output: [1]
Example 3:

Input: rowIndex = 1
Output: [1,1]
* */

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
  public List<Integer> getRow(int rowIndex) {
    List<Integer> res = new ArrayList<>();
    res.add(1);

    for(int i = 1 ; i <= rowIndex ; i++) {
      for(int j = i-1 ; j > 0 ; j--) {
        res.set(j, res.get(j-1) + res.get(j));
      }
      res.add(1);
    }
    return res;
  }
}
