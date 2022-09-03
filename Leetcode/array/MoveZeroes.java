package array;

// https://leetcode.com/problems/move-zeroes/

/*
* Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]


Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1


Follow up: Could you minimize the total number of operations done?
* */

// TAGS : easy, array_transformation

// own code BRUTE FORCE
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if(nums.length == 1) return;

        int pointer = 0;
        int runner;

        while (pointer != nums.length) {
            if(nums[pointer] == 0 && pointer < nums.length-1) {
                runner = pointer + 1;
                while(nums[runner] == 0) {
                    runner++;
                    if(runner==nums.length) {
                        return;
                    }
                }
                swap(nums, pointer, runner);
            }
            pointer++;
        }
    }

    void swap(int[] nums, int low, int high) {
        int temp = nums[low];
        nums[low] = nums[high];
        nums[high] = temp;
    }
}
