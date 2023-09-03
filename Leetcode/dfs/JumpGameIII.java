package dfs;

// https://leetcode.com/problems/jump-game-iii/description/

/*
Given an array of non-negative integers arr, you are initially positioned at start index of the array. When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach any index with value 0.

Notice that you can not jump outside of the array at any time.


Example 1:
Input: arr = [4,2,3,0,3,1,2], start = 5
Output: true
Explanation:
All possible ways to reach at index 3 with value 0 are:
index 5 -> index 4 -> index 1 -> index 3
index 5 -> index 6 -> index 4 -> index 1 -> index 3

Example 2:
Input: arr = [4,2,3,0,3,1,2], start = 0
Output: true
Explanation:
One possible way to reach at index 3 with value 0 is:
index 0 -> index 4 -> index 1 -> index 3

Example 3:
Input: arr = [3,0,2,1,2], start = 2
Output: false
Explanation: There is no way to reach at index 1 with value 0.

Constraints:
1 <= arr.length <= 5 * 104
0 <= arr[i] < arr.length
0 <= start < arr.length
* */

// TAGS : medium, dfs, array
public class JumpGameIII {
    // own solution
    public boolean canReach(int[] arr, int start) {
        int[] visited = new int[arr.length];
        return check(visited, arr, start);
    }

    private boolean check(int[] visited, int[] arr, int start) {
        if(start > arr.length-1 || start < 0 || visited[start] == 1) {
            return false;
        }
        visited[start] = 1;
        if(arr[start] == 0) {
            return true;
        }
        boolean left = check(visited, arr, start - arr[start]);
        boolean right = check(visited, arr, start + arr[start]);
        return left || right;
    }
}
