package array;

import java.util.Arrays;

/* https://leetcode.com/problems/merge-sorted-array/ */

// TAGS : easy

/*
* Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

The number of elements initialized in nums1 and nums2 are m and n respectively. You may assume that nums1 has a size equal to m + n such that it has enough space to hold additional elements from nums2.

Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]

 * */



/*
* Time complexity : \mathcal{O}((n + m)\log(n + m))O((n+m)log(n+m)).

The cost of sorting a list of length xx using a built-in sorting algorithm is \mathcal{O}(x \log x)O(xlogx). Because in this case we're sorting a list of length m + nm+n, we get a total time complexity of \mathcal{O}((n + m) \log (n + m))O((n+m)log(n+m)).

Space complexity : \mathcal{O}(n)O(n), but it can vary.

Most programming languages have a built-in sorting algorithm that uses \mathcal{O}(n)O(n) space.
* */
class MergeAndSort {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = m ; i < m + n ; i++){
            nums1[i] = nums2[i-m];
        }
        Arrays.sort(nums1);
    }
}


/* ------------------------------------  */


//Time complexity : O(n + m)
// space complexity : O(1)

class ThreePointers {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1;
        int p2 = n-1;

        for(int runner = m+n-1 ; runner >= 0 ; runner--){
//            p1 < 0 is needed for the case nums = {0}, m = 0
            if( p1 < 0 || p2 >= 0 && nums2[p2] > nums1[p1]){
                nums1[runner] = nums2[p2--];
            }
            else{
                nums1[runner] = nums1[p1--];
            }
        }
    }
}