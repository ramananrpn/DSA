package permutation_combination;

// https://leetcode.com/problems/subsets/

// TAGS : medium, bit_masking, facebook, google , amazon, uber, goldman_sachs

/*
* Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]

Constraints:
1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.
* */

import java.util.ArrayList;
import java.util.List;

// ----------------------------------- BIT-MASKING --------------------------------------------------

// prefered
// https://www.geeksforgeeks.org/finding-all-subsets-of-a-given-set-in-java/

class SubsetsUsingBitMasking {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // 2^n possibilities
        // 1 << nums.length -> 1 * 2^nums.length
        for(int i = 0; i < (1 << nums.length) ; i++) {
            List<Integer> subSet = new ArrayList<>();

            for(int j = 0 ; j < nums.length ; j++) {
                // check 2^ith bit is ON
                if((i & (1 << j)) > 0) {
                    subSet.add(nums[j]);
                }
            }
            result.add(subSet);
        }
        return result;
    }
}

// Time complexity: O(n * (2^n)) as the outer loop runs for O(2^n) and the inner loop runs for O(n).

// ---------------------------------------------------------------------------------------------------------------

// ---------------------------- BFS using ARRAY LIST ----------------------------
// https://www.geeksforgeeks.org/recursive-program-to-generate-power-set/

// prefered
class SubsetsUsingArrayList {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> powerSet = new ArrayList<>();
        // adding empty set
        powerSet.add(new ArrayList<>());

        for(int num : nums) {
            // Iteraiting current powerSet size number of times
            int size = powerSet.size();

            for(int i = 0 ; i < size; i++){
                // adding current num to each set added in powerSet
                List<Integer> subset = new ArrayList<>(powerSet.get(i));
                subset.add(num);

                // add new subset to powerSet on every iteration
                powerSet.add(subset);
            }
        }

        return powerSet;
    }
}

// ---------------------------------------------------------------------------------------------------------------

// ------------------------------------------ DFS RECURSION ------------------------------------------------

 class SubsetsUsingRecursion {
     public List<List<Integer>> subsets(int[] nums) {
         List<List<Integer>> powerSet = new ArrayList<>();
         List<Integer> subSet = new ArrayList<>();
         dfs(nums, powerSet, subSet, 0);
         return powerSet;
     }

     private List<List<Integer>> dfs(int[] nums, List<List<Integer>> powerSet, List<Integer> subSet, int index) {
         if(index == nums.length){
              powerSet.add(new ArrayList<>(subSet));
              return powerSet;
         }

 //         Without current Index
         powerSet = dfs(nums, powerSet, subSet, index+1);

 //         With Current Index
         subSet.add(nums[index]);
         powerSet = dfs(nums, powerSet, subSet, index+1);
         subSet.remove(subSet.size() -1 );
         return powerSet;
     }
 }

// ---------------------------------------------------------------------------------------------------------------

// --------------- DFS BACKTRACKING --------------------
//https://leetcode.com/problems/subsets/discuss/759398/Simple-Java-with-comments

class SubsetsUsingBackTracking {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        int index = 0;

        backtrack(answer, currentList, nums, index);
        return answer;
    }

    private void backtrack(List<List<Integer>> answer, List<Integer> currentList, int[] nums, int index){

        // Add currentList to answer
        // We want [] in answer as well
        // System.out.println("Adding currentList to answer");
        // System.out.println(currentList);
        answer.add(new ArrayList<>(currentList));

        // Go through every element starting from "index"
        for(int i = index; i < nums.length; i++){

            // Add number at current index to currentList
            currentList.add(nums[i]);

            // Call backtrack and pass next index
            backtrack(answer, currentList, nums, i + 1);

            // When you come back to this point
            // Remove last element from current list
            // So that you can add a new number to it
            // System.out.println("Removing last element from currentList");
            currentList.remove(currentList.size() - 1);
        }
    }
}
