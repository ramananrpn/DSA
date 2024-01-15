package permutation_combination.foundation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/permutations/
// TAGS : medium, heaps_algorithm, backtracking, amazon, facebook , paypal, linkedin, microsoft, ebay


// PERMUTATION FORMULA : n! / (n-r)!
// if r is different
// FORMULA  = n!
// note factorial of zero is 1

/*
* Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]
*/

// ------------------------BACK TRACKING --------------------------------
// prefered

 class PermutationsUsingBacktracking {
     List<List<Integer>> result = new ArrayList<>();

     public List<List<Integer>> permute(int[] nums) {
         List<Integer> numList = new ArrayList<>();

         for(int num : nums) {
             numList.add(num);
         }

         backtrack(numList, 0);

         return result;
     }

     private void backtrack(List<Integer> nums, int start) {
         if(start == nums.size()) {
             result.add(new ArrayList<>(nums));
         }

         for(int i = start ; i < nums.size() ; i++ ){
             // swapping
             Collections.swap(nums, i, start);

             backtrack(nums, start+1);

             // re-swapping to make orig
             Collections.swap(nums, i, start);
         }
     }
 }


// ------------------------HEAP ALGORITHM--------------------------------
// https://medium.com/sodalabs/heaps-algorithm-fun-observation-4986a188a80
// https://www.geeksforgeeks.org/heaps-algorithm-for-generating-permutations/

class PermutationsUsingHeapAlgorithm {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> numList = new ArrayList<>();
        for(int num : nums) {
            numList.add(num);
        }

        heapPermutate(numList, numList.size());

        return result;
    }

    private void heapPermutate(List<Integer> nums, int size) {
        if(size == 1) {
            result.add(new ArrayList<>(nums));
        }

        for(int i = 0 ; i < size ; i++){
            heapPermutate(nums, size-1);

            // size is odd
            if((size & 1) == 1 ){
                Collections.swap(nums, i, size-1);
            }
            // size is even
            else {
                Collections.swap(nums, 0, size-1);
            }
        }

    }
}