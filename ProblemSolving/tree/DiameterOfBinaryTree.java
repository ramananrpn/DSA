package tree;

// https://leetcode.com/problems/diameter-of-binary-tree/

// TAGS: easy

/*
* Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.

Example 1:

Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3is the length of the path [4,2,1,3] or [5,2,1,3].

Example 2:

Input: root = [1,2]
Output: 1

* */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class DiameterOfBinaryTree {
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        find(root);
        return diameter;
    }
    private int find(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftPath = find(node.left);
        int rightPath = find(node.right);

        diameter = Math.max(diameter, leftPath + rightPath  );

        return Math.max(leftPath, rightPath) + 1; // for current root using +1
    }
}