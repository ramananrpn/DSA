package dynamic_programming;

// https://leetcode.com/problems/greatest-sum-divisible-by-three/

/*
* Given an integer array nums, return the maximum possible sum of elements of the array such that it is divisible by three.

Example 1:

Input: nums = [3,6,5,1,8]
Output: 18
Explanation: Pick numbers 3, 6, 1 and 8 their sum is 18 (maximum sum divisible by 3).

Example 2:
Input: nums = [4]
Output: 0
Explanation: Since 4 is not divisible by 3, do not pick any number.

Example 3:

Input: nums = [1,2,3,4,4]
Output: 12
Explanation: Pick numbers 1, 3, 4 and 4 their sum is 12 (maximum sum divisible by 3).


Constraints:
1 <= nums.length <= 4 * 104
1 <= nums[i] <= 104
* */

/*
* REF
* https://www.youtube.com/watch?v=fH-d_w3Cs4g&list=PLnf_DV97XNw6yHFZQPjAARMuP8AVtSJxV&index=23
*/

// TAGS : medium, array, dynamic_programming

/* DP array for Sample 1
*       0    1    2
* -------------------
* 3 |   3    0    0
* 6 |   9    0    0
* 5 |   9    0    14
* 1 |   15   10   14
* 8 |   18   22   23
*
*
* DP array for Sample 2
 * *       0    1    2
 * -------------------
 * 1 |   0    1    0
 * 2 |   3    1    2
 * 3 |   6    4    5
 * 4 |   9   10    8
 * 4 |   12  13   14
 *
* */
public class GreatestSumDivisibleByThree {
    public int maxSumDivThree(int[] nums) {
        int[][] dp = new int[nums.length][3];

        for(int i = 0; i < nums.length ; i++) {
            int index;
            if(i == 0) {
                index = nums[i] % 3;
                dp[i][index] = nums[i];
            } else {
                for(int j = 0 ; j < 3 ; j++) {
                    // refer above DP array for Samples
                    int num = dp[i-1][j] + nums[i];
                    index = num % 3;
                    dp[i][index] = Math.max(dp[i][index], num);

                    // populating  previous max if current idex is 0
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
                }
                if(dp[i][0] == 0) {
                    dp[i][0] = dp[i-1][0];
                }
            }

        }
        return dp[nums.length - 1][0];
    }
}
