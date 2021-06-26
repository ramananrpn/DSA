package array;

// https://leetcode.com/problems/median-of-two-sorted-arrays/
// TAGS : hard, google, amazon, flipkart, paypal, adobe, facebook, goldman_sachs

/*
* Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
Example 3:

Input: nums1 = [0,0], nums2 = [0,0]
Output: 0.00000
Example 4:

Input: nums1 = [], nums2 = [1]
Output: 1.00000
Example 5:

Input: nums1 = [2], nums2 = []
Output: 2.00000
* */

class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int midWithUnion = (m+n)/2;

        boolean even = (m+n) %2 == 0 ? true : false;
        int prevMid = 0;

        int n1Runner = 0, n2Runner = 0, cur = 0;

        // iterating till mid_index when union (m+n/2)
        for(int runner = 0; runner <= midWithUnion ; runner++) {

            if(n1Runner < m && n2Runner < n) {
                cur = nums1[n1Runner] <= nums2[n2Runner]
                        ? nums1[n1Runner++] : nums2[n2Runner++];
            }
            else if(n1Runner < m) {
                cur = nums1[n1Runner++];
            }
            else if(n2Runner < n){
                cur = nums2[n2Runner++];
            }

            // if even have to add (mid + mid-1) / 2 for median
            // so storing prevMid when union count is even
            if(even && (midWithUnion-1 == runner)) prevMid = cur;

        }

        if(even) {
            return (prevMid+cur) / 2.0;
        }
        // odd
        return cur;
    }
}
