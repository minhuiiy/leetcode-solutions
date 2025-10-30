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
class Solution {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private int height(TreeNode node) {
        if(node == null) return 0;

        int hl = height(node.left);
        if(hl == -1) return -1;

        int hr = height(node.right);
        if(hr == -1) return -1;

        if(Math.abs(hl - hr) > 1) return -1;

        return Math.max(hl, hr) + 1;
    }
}