package array;

// https://leetcode.com/problems/sort-array-by-parity/
// tags: easy, google, facebook, capital_one, two_pointer

/*
Given an array nums of non-negative integers, return an array consisting of all the even elements of nums, followed by all the odd elements of nums.

You may return any answer array that satisfies this condition.

Example 1:
Input: nums = [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.

Note:
1 <= nums.length <= 5000
0 <= nums[i] <= 5000
*/

class SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0 ;
        int right = nums.length-1;

        while(left < right) {
            if((nums[left] & 1) == 1 && (nums[right] & 1) == 0){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
            // even
            if((nums[left] & 1) == 0) {
                left++;
            }
            // odd
            if((nums[right] & 1) == 1) {
                right--;
            }
        }
        return nums;
    }
}