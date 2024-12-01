package y23.m9.d6;
/**
 给你一个有根节点root的二叉树，返回它最深的叶节点的最近公共祖先。

 回想一下：


 叶节点 是二叉树中没有子节点的节点
 树的根节点的深度为0，如果某一节点的深度为d，那它的子节点的深度就是d+1
 如果我们假定 A 是一组节点S的 最近公共祖先，S中的每个节点都在以 A 为根节点的子树中，且 A的深度达到此条件下可能的最大值。




 示例 1：

 输入：root = [3,5,1,6,2,0,8,null,null,7,4]
 输出：[2,7,4]
 解释：我们返回值为 2 的节点，在图中用黄色标记。
 在图中用蓝色标记的是树的最深的节点。
 注意，节点 6、0 和 8 也是叶节点，但是它们的深度是 2 ，而节点 7 和 4 的深度是 3 。


 示例 2：

 输入：root = [1]
 输出：[1]
 解释：根节点是树中最深的节点，它是它本身的最近公共祖先。


 示例 3：

 输入：root = [0,1,3,null,2]
 输出：[2]
 解释：树中最深的叶节点是 2 ，最近公共祖先是它自己。



 提示：


 树中的节点数将在[1, 1000]的范围内。
 0 <= Node.val <= 1000
 每个节点的值都是独一无二的。




 注意：本题与力扣 865 重复：https://leetcode-cn.com/problems/smallest-subtree-with-all-the-deepest-nodes/

 */
/*
https://leetcode.cn/problems/lowest-common-ancestor-of-deepest-leaves/?envType=daily-question&envId=2023-09-06
*/

import y23.m9.d4.TreeNode;

/**
 * Definition for a binary tree node.

 */
class Solution {
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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
         TreeNode res[]=new TreeNode[1];
         dfs(root, 0,res);
         return res[0];

    }
    int dfs(TreeNode root,int level,TreeNode[] res){
         if (root==null) return -1;
         TreeNode[] lN=new TreeNode[1],rN=new TreeNode[1];
         int left=dfs(root.left,level+1,lN);
         int right=dfs(root.right,level+1,rN);
         if (left==-1&&right==-1){
             res[0]=root;
             return level;
         }
         if (left!=-1&&right!=-1){
             if (left==right){
                 res[0]=root;
                 return left;
             }
             else{
                 if (left>right){
                     res[0]=lN[0];
                     return left;
                 }else {
                     res[0]=rN[0];
                     return right;
                 }
             }
         }
         if (left==-1){
             res[0]=rN[0];
             return right;
         }else {
             res[0]=lN[0];
             return left;
         }
    }
}