package array;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/

/*
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.



Example 1:

Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
Example 2:

Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).

*/

// TAGS : easy, two_pointers

// OWN CODE
public class RemoveDuplicatesFromSortedArray {
    // own solution
    public int removeDuplicates(int[] nums) {
        if(nums.length == 1) {
            return 1;
        }
        int cur = 0, runner = 1;
        int resultCount = 1;

        while(runner < nums.length) {
            // pointed chars are not matching then
            // swap the runner char with next char for cur
            // increment runner & cur
            // [1(cur), 1(runner), 2] => [1(cur), 1, 2 (runner)] => [1, 2(cur), 1](runner)
            if (nums[cur] != nums[runner]) {
                nums[cur+1] = nums[runner];
                cur++;
                resultCount++;
            }
            runner++;
        }

        return resultCount;
    }

    // ----------------------------------------

    // own solution
    public int removeDuplicatesTwoPointer(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int cur = nums[0];
        int pointer = 1, runner = 1;

        while(runner < nums.length) {
            if(nums[runner] < cur) {
                break;
            }
            if(nums[runner] != cur) {
                cur = nums[runner];
                nums[pointer++] = cur;
            }
            runner++;
        }
        return pointer;
    }
}

