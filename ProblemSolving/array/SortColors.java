package array;

// https://leetcode.com/problems/sort-colors/
// Dutch national flag problem

// TAGS: medium, sort, two_pointers, amazon, facebook, apple, microsoft

/*
* Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]
Example 3:

Input: nums = [0]
Output: [0]
Example 4:

Input: nums = [1]
Output: [1]


Constraints:

n == nums.length
1 <= n <= 300
nums[i] is 0, 1, or 2.
* */


// Time - complexity - O(n)
class SortColors {
    public void sortColors(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int mid = 0;
        while(mid<=high) {
            if(nums[mid] == 0){
                nums = swap(low, mid, nums);
                low++;
                mid++;
            }
            else if(nums[mid] == 1) {
                mid++;
            }
            else { // mid == 2
                nums = swap(mid, high, nums);
                high--;
            }
        }
    }

    private int[] swap(int n1, int n2, int[] nums){
        int temp = nums[n1];
        nums[n1] = nums[n2];
        nums[n2] = temp;
        return nums;
    }
}
