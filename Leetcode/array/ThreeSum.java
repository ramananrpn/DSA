package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* https://leetcode.com/problems/3sum/ */

/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Example 2:

Input: nums = []
Output: []
Example 3:

Input: nums = [0]
Output: []
 */


// TIME-COMPLEXITY - O(n^2  )
class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0) return result;

        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length ; i++) {
            // skipping duplicates if 2 values are same , third should be same to get 0
            if(i!=0 && nums[i] == nums[i-1]) {
                continue;
            }

            int left = i + 1;

            int right = nums.length-1;

            while(left < right){
                // Another way of skipping duplicates  of left & right
                    // if(right!=nums.length -1 && nums[right] == nums[right+1]){
                    //     right--;
                    //     continue;
                    // }

                if(nums[left]+nums[right]+nums[i] == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    /* skipping duplicates of left & right element i.e [-2,0,0,2,2] -> [[-2,0,2],[-2,0,2]] can                          be ignored */
                    do{
                        left++;
                        right--;
                    }while(left<right && nums[left-1] == nums[left] && nums[right+1] == nums[right]) ;

                }
                else if(nums[left]+nums[right]+nums[i] > 0){
                    right--;
                }
                else{
                    left++;
                }
            }
        }
        return result;
    }
}