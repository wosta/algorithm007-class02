package week03.g20200343040172;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * 本周作业
 * LeetCode-236 lowest common ancestor of a binary treel 二叉树的最近公共祖先
 */
public class LeetCode_236_0172 {
    /**
     * 使用回溯的思想，使用递归实现
     */

    class Solution {

        private TreeNode ans;

        public Solution() {
            // Variable to store LCA node.
            this.ans = null;
        }

        private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {

            // If reached the end of a branch, return false.
            if (currentNode == null) {
                return false;
            }

            // Left Recursion. If left recursion returns true, set left = 1 else 0
            int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;

            // Right Recursion
            int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;

            // If the current node is one of p or q
            int mid = (currentNode == p || currentNode == q) ? 1 : 0;


            // If any two of the flags left, right or mid become True
            if (mid + left + right >= 2) {
                this.ans = currentNode;
            }

            // Return true if any one of the three bool values is True.
            return (mid + left + right > 0);
        }

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // Traverse the tree
            this.recurseTree(root, p, q);
            return this.ans;
        }
    }

}
