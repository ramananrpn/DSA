package array;

// https://leetcode.com/problems/rotate-array/

/*
* Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
*
* */

//TAGS : rotation, medium
public class RotateArray {
    public void rotate(int[] nums, int k) {
        k %= nums.length;

        if(k == 0) return;

        // [1, 2, 3, 4, 5, 6, 7] -> [7, 6, 5, 4, 3, 2, 1,]
        reverse(nums, 0, nums.length-1);

        // [7, 6, 5, 4, 3, 2, 1,] -> [5, 6, 7, 4, 3, 2, 1]
        reverse(nums, 0, k-1);

        // [5, 6, 7, 4, 3, 2, 1] -> [5, 6, 7, 1, 2, 3, 4]
        reverse(nums, k, nums.length-1);
    }

    void reverse(int[] nums, int start, int end) {
        while(start < end) {
            swap(nums, start++, end--);
        }
    }

    void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}
