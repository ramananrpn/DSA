package dynamic_programming;

// https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/description/

/*
* Given an array arr of positive integers, consider all binary trees such that:

Each node has either 0 or 2 children;
The values of arr correspond to the values of each leaf in an in-order traversal of the tree.
The value of each non-leaf node is equal to the product of the largest leaf value in its left and right subtree, respectively.
Among all possible binary trees considered, return the smallest possible sum of the values of each non-leaf node. It is guaranteed this sum fits into a 32-bit integer.

A node is a leaf if and only if it has zero children.



Example 1:


Input: arr = [6,2,4]
Output: 32
Explanation: There are two possible trees shown.
The first has a non-leaf node sum 36, and the second has non-leaf node sum 32.
Example 2:


Input: arr = [4,11]
Output: 44


Constraints:

2 <= arr.length <= 40
1 <= arr[i] <= 15
It is guaranteed that the answer fits into a 32-bit signed integer (i.e., it is less than 231).
*/

/* SOLUTION REFS
  https://www.youtube.com/watch?v=T6E74ypY_tU
  https://algo.monster/liteproblems/1130
  https://www.youtube.com/watch?v=LDiD9fr28tc
* */

// TAGS: medium, tree, dynamic_programming, revisit


public class MinimumCostTreeFromLeafValues {
    // start
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        Pair[][] dp = new Pair[n][n];
        return findMin(arr, 0, n-1, dp).sum;
    }

    private Pair findMin(int[] arr, int l, int r, Pair[][] dp) {
        if(l > r) {
            return new Pair(0, Integer.MAX_VALUE);
        }

        if( l == r) {
            return new Pair(arr[l], 0);
        }

        if(dp[l][r] != null) {
            return dp[l][r];
        }

        Pair ans = new Pair(0, Integer.MAX_VALUE);

        for(int i = l ; i < r ; i++) {
            Pair leftPair = findMin(arr, l, i, dp);
            Pair rightPair = findMin(arr, i+1, r, dp);

            int total = leftPair.sum + rightPair.sum + (leftPair.max * rightPair.max);

            if(total < ans.sum) {
                ans.sum = total;
                ans.max = Math.max(leftPair.max, rightPair.max);

            }
        }
        dp[l][r] = new Pair(ans.max, ans.sum);
        return ans;
    }

    class Pair{
        int max;
        int sum;

        Pair(int max,int sum){
            this.max=max;
            this.sum=sum;
        }
    }
}


