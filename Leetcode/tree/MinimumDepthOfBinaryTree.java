package tree;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/minimum-depth-of-binary-tree/
// tags : easy, bfs, facebook, amazon, recursion

/*
* Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: 2

Example 2:
Input: root = [2,null,3,null,4,null,5,null,6]
Output: 5
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

// --------------------------  RECURSION -------------------------------
// O(n)
 class MinimumDepthOfBinaryTreeUsingRecursion {

     public int minDepth(TreeNode root) {
         if(root == null) return 0;

         return levelTraversal(root, 1);
     }

     private int levelTraversal(TreeNode root, int level) {
         if(root.left == null && root.right == null) {
             return level;
         }
         int left = Integer.MAX_VALUE;
         int right = Integer.MAX_VALUE;
         if(root.left != null) {
             left = levelTraversal(root.left, level+1);
         }

         if(root.right != null) {
             right = levelTraversal(root.right, level+1);
         }

         return Math.min(left, right);

     }
 }

// -------------------------------   BFS -------------------------------
// Efficient 0ms
class MinimumDepthOfBinaryTreeUsingRecursionUsingBFS {

    public int minDepth(TreeNode root) {
        if(root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        int level = 1;

        while(!queue.isEmpty()) {
            int levelNodes = queue.size();

            while(levelNodes-- > 0) {
                TreeNode node =  queue.poll();

                if(node.left == null && node.right == null){
                    return level;
                }

                if(node.left!=null) {
                    queue.add(node.left);
                }

                if(node.right!=null) {
                    queue.add(node.right);
                }
            }
            level++;
        }
        return 0;
    }
}

// WITH PAIR
/*class MinimumDepthOfBinaryTreeUsingRecursionUsingBFS {

    public int minDepth(TreeNode root) {
        if(root == null) return 0;

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();

        queue.add(new Pair(root, 1));

        while(!queue.isEmpty()) {
            Pair<TreeNode, Integer> data =  queue.poll();
            TreeNode node = data.getKey();
            int depth = data.getValue();

            if(node.left!=null) {
                queue.add(new Pair(node.left, depth+1));
            }

            if(node.right!=null) {
                queue.add(new Pair(node.right, depth+1));
            }

            if(node.left == null && node.right == null){
                return depth;
            }
        }

        return 0;
    }
}*/
