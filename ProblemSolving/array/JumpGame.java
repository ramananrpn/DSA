package array;

// https://leetcode.com/problems/jump-game/description

/*
You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

Example 1:
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:
Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

Constraints:
1 <= nums.length <= 104
0 <= nums[i] <= 105
* */

// TAGS : medium, top_interview_150

public class JumpGame {
    // 1
     public boolean canJump1(int[] nums) {
     int reachable = 0;
        for(int i = 0; i < nums.length; i ++) {
            if(i > reachable) return false;
            reachable = Math.max(reachable, i + nums[i]);

        }
        return true;
     }

//     -----------------

    // 2
     public boolean canJump2(int[] nums) {
     int reachable = 0;
        for(int i = 0; i <= reachable; i ++) {
            reachable = Math.max(reachable, i + nums[i]);
            if(reachable >= nums.length-1) return true;

        }
        return false;
     }

//     ----------------------

    // 3
    // [3,2,1,0,4]
    public boolean canJump3(int[] nums) {
        int last = nums.length - 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            // checking if the value can cross the last
            // if it can can cross, reducing the last element
            // if not last stays the same and adding the value previous element should cross it
            // [3,2,1,0,4]
            if(i + nums[i] >= last) {
                last = i;
            }
        }
        if(last == 0) return true;
        return false;
    }
}
