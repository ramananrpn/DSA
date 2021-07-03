package permutation_combination;

//https://leetcode.com/problems/next-permutation/
// tags: medium, permutation, facebook, amazon, google apple, microsoft, adobe, goldman_sachs

/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

The replacement must be in place and use only constant extra memory.

Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]

Example 2:
Input: nums = [3,2,1]
Output: [1,2,3]

Example 3:
Input: nums = [1,1,5]
Output: [1,5,1]

Example 4:
Input: nums = [1]
Output: [1]
 */

// INSIGHTS :
/*
All the permutations of a word when arranged in a dictionary, the order of words so obtained is called lexicographical order.

First, we observe that for any given sequence that is in descending order, no next larger permutation is possible.
We need to find the first pair of two successive numbers a[i]a[i] and a[i-1]a[i−1], from the right, which satisfy a[i] > a[i-1]a[i]>a[i−1]. Now, no rearrangements to the right of a[i-1]a[i−1] can create a larger permutation since that subarray consists of numbers in descending order. Thus, we need to rearrange the numbers to the right of a[i-1]a[i−1] including itself.

-- ALGORITHM: --

Given : str = “nmhdgfecba”

 * Traverse from the right of the string and look for the first character that does not follow the descending order.    ‘d’ in str doesn’t follow descending order. index of ‘d’ = 3.

* To the right of ‘d’, search for the character that is just (or closest) greater than ‘d’ in ASCII value. ‘e’ in       [nmhd]gfecba is just greater than ‘d’.This is done using binarySearch() function.

* swap ‘e’ and ‘d’.The resulting string is “nmhegfdcba”.

* Now reverse (done using the reverse() function) the part of resulting string occurring after the index found in
  step 1. reverse “gfdcba” and append it back to the main string.

  output = “nmheabcdfg”,it is the lexicographically next permutation of  “nmhgfedcba”.

-> Find the longest non-increasing suffix and find the pivot.
-> If the suffix is the whole array, then there is no higher order permutation for the data.
-> Find the rightmost successor to the pivot.
-> Swap the successor and the pivot.
-> Reverse the suffix.


word = 'cat'
lexicographical order of permutations of 'cat' : 'cta'

act
atc
cat
cta
tac
tca

*/


// https://www.geeksforgeeks.org/implementing-next_permutation-in-java-with-examples/
// https://www.tutorialcup.com/interview/string/next-permutation.htm

class NextPermutation {
    public void nextPermutation(int[] nums) {
        int len = nums.length;

        // pivot - first non-increasing index from right
        // starting from len-2 for comparing with next element
        int pivot = len-2;

        while(pivot >= 0) {
            // break if non-increasing
            // 1,2,3,4,6,5 -> breaks in 4
            if(nums[pivot] < nums[pivot+1]){
                break;
            }

            pivot--;
        }

        // next greater permutation occurs only if non-increasing pair from right is present
        if(pivot >= 0) {
            // finding next nearest greater element
            int nextGreaterIndex = binarySearch(nums, pivot+1, len-1, nums[pivot]);

            // swapping pivot & next greater element
            swap(nums, pivot, nextGreaterIndex);
        }

        // reverse subarray after pivot index
        reverse(nums, pivot+1, len-1);
    }

    // function to find next nearest greater element index using binary search
    private int binarySearch(int[] nums, int left, int right, int target) {
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // using <= and >= conditions when nums has duplicates
            if(nums[mid] <= target ){
                right = mid - 1;
            }
            else if(nums[mid] >= target) {
                left = mid + 1;

                if(index == -1 || nums[mid] <= nums[index]){
                    index = mid;
                }
            }
        }
        return index;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while(start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}