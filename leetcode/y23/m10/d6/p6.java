package y23.m10.d6;

import Bean.TreeNode;
import util.BuildTree;

/**
 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。

 有效 二叉搜索树定义如下：


 节点的左子树只包含 小于 当前节点的数。
 节点的右子树只包含 大于 当前节点的数。
 所有左子树和右子树自身必须也是二叉搜索树。




 示例 1：

 输入：root = [2,1,3]
 输出：true


 示例 2：

 输入：root = [5,1,4,null,null,3,6]
 输出：false
 解释：根节点的值是 5 ，但是右子节点的值是 4 。




 提示：


 树中节点数目范围在[1, 104] 内
 -231 <= Node.val <= 231 - 1


 */
/*
https://leetcode.cn/problems/validate-binary-search-tree/description/?envType=study-plan-v2&envId=top-interview-150
*/
class Solutionp6 {
    public boolean isValidBST(TreeNode root) {
        return check(root)!=null;
    }
    int[] check(TreeNode root){
        if (root.left==null && root.right==null)
            return new int[]{root.val,root.val};
        int[] left=null,right=null;
        if (root.left!=null){
            left=check(root.left);
            if (left==null)
                return null;
            if (root.val<=left[1])
                return null;
        }
        if (root.right!=null){
            right=check(root.right);
            if (right==null)
                return null;
            if (root.val>=right[0])
                return null;
        }
        return new int[]{left==null?root.val:left[0],right==null?root.val:right[1]};
    }

//    public static void main(String[] args) {
//        Solution solution=new Solution();
//        Integer[]arr=new Integer[]{32,26,47,19,null,null,56,null,27};
//        TreeNode root= BuildTree.buildTree(arr);
//        solution.isValidBST(root);
//    }
}