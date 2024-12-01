package y23.m9.d6;

/**
 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。

 如果指定节点没有对应的“下一个”节点，则返回null。

 示例 1:

 输入: root = [2,1,3], p = 1

 2
 / \
 1   3

 输出: 2

 示例 2:

 输入: root = [5,3,6,2,4,null,null,1], p = 6

 5
 / \
 3   6
 / \
 2   4
 /
 1

 输出: null

 */
/*
https://leetcode.cn/problems/successor-lcci/
*/
class Solutionp2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    boolean isNext=false;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root==null) return null;
        TreeNode left=inorderSuccessor(root.left,p);
        if (isNext){
            isNext=false;
            return root;
        }
        if (root==p)
            isNext=true;
        TreeNode right=inorderSuccessor(root.right,p);
        if (left!=null||right!=null)
            return left==null?right:left;
        else
            return null;
    }

}