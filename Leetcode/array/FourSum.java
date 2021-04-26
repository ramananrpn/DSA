package array;


/* https://leetcode.com/problems/4sum/ */

/*
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]

Test Cases :
[1,0,-1,0,-2,2]
0
[2,2,2,2,2]
8
[-2,-1,-1,1,1,2,2]
0
[-1,-5,-5,-3,2,5,0,4]
-7
[0,0,0,0]
0
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// TIME-COMPLEXITY - O(n^3)
class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for(int i = 0; i<nums.length - 3; i++){
            // skipping duplicates
            if(i!=0 && nums[i] == nums[i-1]){
                continue;
            }

            int quad2 = i+1;

            while(quad2 < nums.length - 2) {
                // skipping duplicates
                if (quad2!=i+1 && nums[quad2] == nums[quad2-1]){
                    quad2++;
                    continue;
                }

                int quad3 = quad2 +1;
                int quad4 = nums.length -1;

                while(quad3<quad4){

                    if(nums[i] + nums[quad2] + nums[quad3] + nums[quad4] == target) {
                        result.add(Arrays.asList(nums[i],nums[quad2], nums[quad3], nums[quad4]));

                        // skipping duplicates
                        do{
                            quad3++ ;
                            quad4--;
                        }while(quad3 < quad4 && nums[quad3] == nums[quad3-1] &&  nums[quad4] == nums[quad4+1]);
                    }
                    else if(nums[i] + nums[quad2] + nums[quad3] + nums[quad4] < target) {
                        quad3++;
                    }
                    else{
                        quad4--;
                    }


                }
                quad2++;
            }
        }
        return result;
    }
}