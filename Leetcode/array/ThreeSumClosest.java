package array;
// 3Sum Closest

// https://leetcode.com/problems/3sum-closest/
// Tags: medium, two_pointers, binary_search, facebook, google , amazon, apple, adobe, capital_one

/*
* Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

Example 1:
Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

Constraints:
3 <= nums.length <= 10^3
-10^3 <= nums[i] <= 10^3
-10^4 <= target <= 10^4
*/

import java.util.Arrays;

class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int left = 0, right = 0;
        int dif = Integer.MAX_VALUE;

        for(int i = 0 ; i < nums.length - 2 && dif != 0 ; i++) {
            left = i+1; right = nums.length-1;


            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];

                if(sum == target){
                    return sum;
                }

                if(Math.abs(target - sum) < Math.abs(dif)){
                    dif = target - sum;
                }
                if(sum < target){
                    left++;
                }else {
                    right--;
                }
            }
        }

        return target - dif;
    }
}