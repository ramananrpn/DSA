package tree;

//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

// tags: medium, microsoft, google

/*
* Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

Example 1:
Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]

Example 2:
Input: inorder = [-1], postorder = [-1]
Output: [-1]


Constraints:

1 <= inorder.length <= 3000
postorder.length == inorder.length
-3000 <= inorder[i], postorder[i] <= 3000
inorder and postorder consist of unique values.
Each value of postorder also appears in inorder.
inorder is guaranteed to be the inorder traversal of the tree.
postorder is guaranteed to be the postorder traversal of the tree.
* */

import java.util.HashMap;

// with hashMap
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    HashMap<Integer, Integer> indexMap = new HashMap<>();
    int[] postOrder, inOrder;
    int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postOrder = postorder;
        this.inOrder = inorder;

        postIndex = postorder.length-1;

        for(int i= 0 ; i < inorder.length ; i++) {
            indexMap.put(inorder[i], i);
        }

        return buildTree(0, postIndex);
    }

    private TreeNode buildTree(int left, int right) {
        if (left > right) {
            return null;
        }

        TreeNode treeNode = new TreeNode(postOrder[postIndex]);

        int inOrderIndex = indexMap.get(postOrder[postIndex]);

        postIndex--;

        // build right
        treeNode.right  = buildTree(inOrderIndex + 1, right);

        // build left
        treeNode.left  = buildTree(left, inOrderIndex -1);

        return treeNode;
    }
}

//   --------------------- without hashmap --------------------------
// fastest

class ConstructBinaryTreeFromInorderAndPostorderTraversalWithoutHashMap {
    int iI;
    int pI;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        pI = iI = inorder.length-1;
        return helper(inorder, postorder, Integer.MIN_VALUE);
    }
    private TreeNode helper(int[] in, int[] post, int stopper) {
        if (pI < 0) return null;
        if (stopper == in[iI]) {
            iI--;
            return null;
        }
        TreeNode node = new TreeNode(post[pI--]);
        node.right = helper(in, post, node.val);
        node.left = helper(in, post, stopper);

        return node;
    }
}
