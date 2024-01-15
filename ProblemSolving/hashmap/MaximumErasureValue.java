package hashmap;

import java.util.HashMap;

// https://leetcode.com/problems/maximum-erasure-value/

// TAGS : medium, two_pointers, sliding_window

/*
You are given an array of positive integers nums and want to erase a subarray containing unique elements. The score you get by erasing the subarray is equal to the sum of its elements.

Return the maximum score you can get by erasing exactly one subarray.

An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).



Example 1:

Input: nums = [4,2,4,5,6]
Output: 17
Explanation: The optimal subarray here is [2,4,5,6].
Example 2:

Input: nums = [5,2,1,2,5,2,1,2,5]
Output: 8
Explanation: The optimal subarray here is [5,2,1] or [1,2,5].


Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 104
*/

class MaximumErasureValue {
    public int maximumUniqueSubarray(int[] nums) {
        int max = 0 ;
        int sum = 0;
        int left = 0 , right = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while(right < nums.length){
            if(map.containsKey(nums[right])){
                max = Math.max(sum, max);
                int index = Math.max(map.get(nums[right]), left);
                while(left!=index){
                    sum -= nums[left++];
                }
            }
            sum+=nums[right];
            map.put(nums[right], right+1);
            right++;
        }
        return Math.max(sum, max);
    }
}
