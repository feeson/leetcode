package y23.m10.d6;

import Bean.TreeNode;

import java.security.KeyManagementException;

/**
 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。

 差值是一个正数，其数值等于两值之差的绝对值。



 示例 1：

 输入：root = [4,2,6,1,3]
 输出：1


 示例 2：

 输入：root = [1,0,48,null,null,12,49]
 输出：1




 提示：


 树中节点的数目范围是 [2, 104]
 0 <= Node.val <= 105




 注意：本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 相同

 */
/*
https://leetcode.cn/problems/minimum-absolute-difference-in-bst/?envType=study-plan-v2&envId=top-interview-150
*/
class Solutionp4 {
    int res=Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return res;
    }
    void dfs(TreeNode root){
        if (root==null)
            return;
        if (root.left!=null){
            res=Math.min(res,root.val-getLeft(root.left));
            dfs(root.left);
        }
        if (root.right!=null){
            res= Math.min(res, getRight(root.right)-root.val);
            dfs(root.right);
        }
    }
    int getLeft(TreeNode root){
        if (root.right==null)
            return root.val;
        return getLeft(root.right);
    }
    int getRight(TreeNode root){
        if (root.left==null)
            return root.val;
        return getRight(root.left);
    }
}