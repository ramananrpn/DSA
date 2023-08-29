package tree;

// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description

// TAGS : easy

/*
Given an integer array nums where the elements are sorted in ascending order, convert it to a
height-balanced
 binary search tree.


Example 1:
Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:

Example 2:
Input: nums = [1,3]
Output: [3,1]
Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
*/

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return createBST(nums,0 ,nums.length-1);
    }

    public TreeNode createBST(int arr[], int st, int end){
        if(st>end){
            return null;
        }

        int mid = (st+end)/2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = createBST(arr,st,mid-1);
        root.right = createBST(arr,mid+1,end);

        return root;
    }
}
