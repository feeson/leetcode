package y24.m4.p10;

import java.util.Map;

/**
 * Definition for a binary tree node.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    int min(int v1, int v2, int v3){
        return Math.min(v1, Math.min(v2, v3));
    }
    int[] dfs(TreeNode node){
        // [record, child_covered, parent_covered]
        if(node == null){
            return new int[]{0, 0, 0};
        }
        int[] ans = new int[]{1, 0, 0};
        if(node.left != null && node.right != null){
            int[] left = dfs(node.left);
            int[] right = dfs(node.right);
            ans[0] += min(left[0], left[1], left[2]);
            ans[0] += min(right[0], right[1], right[2]);

            ans[1] += Math.min(Math.min(left[0] + Math.min(right[0], right[1]), right[0] + Math.min(left[0], left[1])), left[0] + right[0]);

            ans[2] += left[1];
            ans[2] += right[1];
        }else if (node.left != null){
            int[] left = dfs(node.left);
            ans[0] += min(left[0], left[1], left[2]);
            ans[1] += left[0];
            ans[2] += left[1];
        }else {
            int[] right = dfs(node.right);
            ans[0] += min(right[0], right[1], right[2]);
            ans[1] += right[0];
            ans[2] += right[1];
        }
        return ans;
    }
    public int minCameraCover(TreeNode root) {
        int[] ans = dfs(root);
        int res = Math.min(ans[0], ans[1]);
        if(res == 0)
            res = 1;
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(0,null,new TreeNode(0,null,new TreeNode(0, null,new TreeNode(0))));
        solution.minCameraCover(root);
    }
}