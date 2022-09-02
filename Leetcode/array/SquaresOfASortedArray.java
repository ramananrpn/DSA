package array;

import java.util.Arrays;

// https://leetcode.com/problems/squares-of-a-sorted-array/

// TAGS : easy, google, apple, uber, faccebook

/*
* Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]


Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.
* */

class Sort {
     public int[] sortedSquares(int[] nums) {
         for(int i = 0; i < nums.length; i++){
             nums[i] = nums[i] * nums[i];
         }
         Arrays.sort(nums);
         return nums;
     }
 }
// Time Complexity: O(N log N)

/* ---------------------------------------------- */

class TwoPointer {
    public int[] sortedSquares(int[] nums) {
        int negativePointer = 0;
        int positivePointer , index;
        positivePointer = index = nums.length -1;

        int[] result = new int[nums.length];

        while(negativePointer <= positivePointer){
            int negSquare = nums[negativePointer] * nums[negativePointer];
            int posSquare = nums[positivePointer] * nums[positivePointer];

            if(posSquare >= negSquare){
                result[index--] = posSquare;
                positivePointer--;
            }else{
                result[index--] = negSquare;
                negativePointer++;
            }
        }
        return result;
    }
}

// Time Complexity: O(N)

/*
class TwoPointer {
    public int[] sortedSquares(int[] nums) {
        int low = 0, high = nums.length-1;

        int[] result = new int[nums.length];

        int index = high;

        while(low <= high) {
            int lowSquare = nums[low] * nums[low];
            int highSquare = nums[high] * nums[high];

            if(lowSquare >= highSquare) {
                result[index--] = lowSquare;
                low++;
            }
            else {
                result[index--] = highSquare;
                high--;
            }
        }
        return result;
    }
}*/
