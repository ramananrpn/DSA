package searching;

// https://www.geeksforgeeks.org/binary-search/

/* https://leetcode.com/problems/binary-search/ */

/*
Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1
 */

// TAGS : searching , binary_search

public class BinarySearch {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length-1);
    }

    int binarySearch(int[] nums, int target, int left, int right) {
        if (left <= right) {


            int mid = ( left + right ) / 2;

            if(nums[mid] == target) {
                return mid;
            }

            else if (target < nums[mid]) {
                return binarySearch(nums, target, left, mid-1);
            }

            else if (target > nums[mid]) {
                return binarySearch(nums, target, left+1, right);
            }

        }
        return -1;
    }
}
