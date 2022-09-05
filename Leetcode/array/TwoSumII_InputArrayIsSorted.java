package array;

// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

/*
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.

Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
Example 2:

Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
Example 3:

Input: numbers = [-1,0], target = -1
Output: [1,2]
Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].

[-1,0]
-1

[5,25,75]
100

[0, 0, 2, 5]
0
 */


// OWN CODE
public class TwoSumII_InputArrayIsSorted {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        for(int i = 0 ; i < nums.length - 1; i++) {
            int rem = target - nums[i];

            // array is sorted, so if rem is greater than last num
            // rem will be exist, so incrementing i (continue)
            if (rem > nums[nums.length-1]) {
                continue;
            }

            int mid, start = i, end = nums.length - 1;

            // using binary search as the array is sorted
            do {
                mid = start + (end - start) / 2;

                if (nums[mid] < rem || mid == i) {
                    start = mid+1;
                }

                else if( nums[mid] > rem) {
                    end = mid - 1;
                }
                else if(nums[mid] == rem) {
                    result[0] = i+1;
                    result[1] = mid+1;
                    return result;
                }
            } while(end >= start);
        }
        return result;
    }
}
