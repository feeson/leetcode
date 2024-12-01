package y23.m9.d10;

import java.util.ArrayList;
import java.util.List;

/**
 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。



 示例 1:



 输入:[1,2,3,null,5,null,4]
 输出:[1,3,4]


 示例 2:

 输入:[1,null,3]
 输出:[1,3]


 示例 3:

 输入:[]
 输出:[]




 提示:


 二叉树的节点个数的范围是 [0,100]
 -100<= Node.val <= 100


 */
/*
https://leetcode.cn/problems/binary-tree-right-side-view/
*/
class Solutionp4 {
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
    int ml=-1;
    List<Integer> res=new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root,0);
        return res;
    }
    void dfs(TreeNode node,int level){
        if (node==null)return;
        if (level>ml){
            res.add(node.val);
            ml++;
        }
        dfs(node.right,level+1);
        dfs(node.left,level+1);
    }
}
