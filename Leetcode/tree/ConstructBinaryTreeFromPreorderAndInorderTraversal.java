package tree;

import java.util.HashMap;
// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

// Tags : medium, amazon, microsoft, facebook, uber

/*
Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

Example 1:
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]

Example 2:
Input: preorder = [-1], inorder = [-1]
Output: [-1]

Constraints:

1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder and inorder consist of unique values.
Each value of inorder also appears in preorder.
preorder is guaranteed to be the preorder traversal of the tree.
inorder is guaranteed to be the inorder traversal of the tree.
 */
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
class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    HashMap<Integer, Integer> indexMap = new HashMap<>();
    int[] preOrder, inOrder;
    int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preOrder = preorder;
        this.inOrder = inorder;

        for(int i= 0 ; i < inorder.length ; i++) {
            indexMap.put(inorder[i], i);
        }

        return buildTree(0, preOrder.length-1);
    }

    private TreeNode buildTree(int left, int right) {
        if (left > right) {
            return null;
        }

        TreeNode treeNode = new TreeNode(preOrder[preIndex]);

        int inOrderIndex = indexMap.get(preOrder[preIndex]);

        preIndex++;

        // build left
        treeNode.left  = buildTree(left, inOrderIndex -1);

        // build right
        treeNode.right  = buildTree(inOrderIndex + 1, right);



        return treeNode;
    }
}