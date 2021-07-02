package permutation_combination;

// https://leetcode.com/problems/subsets-ii/

// tags: medium, apple

// array nums of duplicate elements, all possible sub-arrays without duplicates

/*
* Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> powerSet = new ArrayList<>();
        powerSet.add(new ArrayList<>());

        // sorting
        Arrays.sort(nums);

        for(int cur = 0 ; cur < nums.length ; cur++) {


            int elementCount = 1;

            // finding duplicate count of current element
            // sliding cur pointer if duplicates
            while( cur+1 < nums.length && nums[cur+1] == nums[cur]) {
                elementCount++;
                cur++;
            }

            // getting powerSet size for iterating
            int size = powerSet.size();

            for(int j = 0; j < size ; j++){
                List<Integer> subset = new ArrayList<>(powerSet.get(j));

                // Iterating with dupCount and adding those times
                for(int rep = elementCount ; rep > 0 ; rep--) {

                    // adding current element in array
                    subset.add(nums[cur]);

                    // adding to powerset
                    // append with new object as we make changing subset obj on every dup iteration
                    powerSet.add(new ArrayList<>(subset));
                }
            }
        }

        return powerSet;
    }
}