package hashmap;

import java.util.HashMap;
import java.util.Map;

/* https://leetcode.com/problems/number-of-good-pairs/ */

/*
* Given an array of integers nums.

A pair (i,j) is called good if nums[i] == nums[j] and i < j.

Return the number of good pairs.

Example 1:

Input: nums = [1,2,3,1,1,3]
Output: 4
Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
Example 2:

Input: nums = [1,1,1,1]
Output: 6
Explanation: Each pair in the array are good.
Example 3:

Input: nums = [1,2,3]
Output: 0
* */

// BRUTE FORCE
 class NOGP_BruteForce {
     public int numIdenticalPairs(int[] nums) {
         int count = 0;
         for(int i = 0 ; i < nums.length -1 ; i++){
           for(int j = i+1 ; j< nums.length ; j++) {
               if(nums[i] == nums[j]) count++;
           }

         }
         return count;
     }
 }

// HashMap
class NOGP_HashMap{
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int n : nums){
            int value = map.getOrDefault(n, 0);
            count += value;
            map.put(n, value +1);
        }
        return count;
    }

}
