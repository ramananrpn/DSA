package array;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

// https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values/description/
/*
* You are given two 2D integer arrays nums1 and nums2.

nums1[i] = [idi, vali] indicate that the number with the id idi has a value equal to vali.
nums2[i] = [idi, vali] indicate that the number with the id idi has a value equal to vali.
Each array contains unique ids and is sorted in ascending order by id.

Merge the two arrays into one array that is sorted in ascending order by id, respecting the following conditions:

Only ids that appear in at least one of the two arrays should be included in the resulting array.
Each id should be included only once and its value should be the sum of the values of this id in the two arrays. If the id does not exist in one of the two arrays then its value in that array is considered to be 0.
Return the resulting array. The returned array must be sorted in ascending order by id.



Example 1:

Input: nums1 = [[1,2],[2,3],[4,5]], nums2 = [[1,4],[3,2],[4,1]]
Output: [[1,6],[2,3],[3,2],[4,6]]
Explanation: The resulting array contains the following:
- id = 1, the value of this id is 2 + 4 = 6.
- id = 2, the value of this id is 3.
- id = 3, the value of this id is 2.
- id = 4, the value of this id is 5 + 1 = 6.
Example 2:

Input: nums1 = [[2,4],[3,6],[5,5]], nums2 = [[1,3],[4,3]]
Output: [[1,3],[2,4],[3,6],[4,3],[5,5]]
Explanation: There are no common ids, so we just include each id with its value in the resulting list.


Constraints:

1 <= nums1.length, nums2.length <= 200
nums1[i].length == nums2[j].length == 2
1 <= idi, vali <= 1000
Both arrays contain unique ids.
Both arrays are in strictly ascending order by id.
* */

// TAGS : array, easy, treemap


// own solution
public class MergeTwo2DArraysBySummingValues {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int[][] res = new int[nums1.length + nums2.length][2];
        int r=0;

        int p1 = 0, p2 = 0;

        while(p1 < nums1.length && p2 < nums2.length) {
            if(nums1[p1][0] == nums2[p2][0]) {
                res[r][0] = nums1[p1][0];
                res[r][1] = nums1[p1][1] + nums2[p2][1];
                p1++; p2++; r++;
            }
            else if (nums1[p1][0] < nums2[p2][0]){
                res[r][0] = nums1[p1][0];
                res[r][1] = nums1[p1][1];
                p1++;
                r++;
            } else {
                res[r][0] = nums2[p2][0];
                res[r][1] = nums2[p2][1];
                p2++;
                r++;
            }
        }
        while(p1 < nums1.length) {
            res[r][0] = nums1[p1][0];
            res[r][1] = nums1[p1][1];
            p1++; r++;
        }

        while(p2 < nums2.length) {
            res[r][0] = nums2[p2][0];
            res[r][1] = nums2[p2][1];
            p2++; r++;
        }

        return Arrays.copyOf(res, r);
    }
}


// ------------------------------- TREEMAP ------------------------------

class MergeTwo2DArraysBySummingValuesTreeMap {
    public int[][] mergeArrays(int[][] a1, int[][] a2) {//tree map
        Map<Integer, Integer> m = new TreeMap<>();
        Arrays.stream(a1).forEach(n -> m.put(n[0], n[1]));
        Arrays.stream(a2).forEach(n -> m.put(n[0], m.getOrDefault(n[0], 0) + n[1]));
        return m.keySet().stream().map(k -> new int[]{k, m.get(k)}).toList().toArray(new int[0][]);
    }
}