package y23.m8.d25;

/**
 * 给你一棵根为 root 的二叉树，请你返回二叉树中好节点的数目。
 *
 * 「好节点」X 定义为：从根到该节点 X 所经过的节点中，没有任何节点的值大于 X 的值。
 *
 * https://leetcode.cn/problems/count-good-nodes-in-binary-tree/
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
class Solutionp1 {

    public class TreeNode {
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
    public int goodNodes(TreeNode root) {
        return dfs(root,-Integer.MAX_VALUE);
    }

    int dfs(TreeNode node,int max){
        if (node==null)
            return 0;
        if (node.val>=max){
            return 1+dfs(node.left,node.val)+dfs(node.right,node.val);
        }else {
            return dfs(node.left,max)+dfs(node.right,max);
        }
    }
}