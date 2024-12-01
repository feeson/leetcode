package y23.m9.d27;
/**
 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。

 路径和 是路径中各节点值的总和。

 给你一个二叉树的根节点 root ，返回其 最大路径和 。



 示例 1：

 输入：root = [1,2,3]
 输出：6
 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6

 示例 2：

 输入：root = [-10,9,20,null,null,15,7]
 输出：42
 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42




 提示：


 树中节点数目范围是 [1, 3 * 104]
 -1000 <= Node.val <= 1000


 */
/*
https://leetcode.cn/problems/binary-tree-maximum-path-sum/?envType=study-plan-v2&envId=top-interview-150
*/

class Solutionp2 {

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

    public int maxPathSum(TreeNode root) {
        int dfs = dfs(root);
        return res;
    }
    int res=Integer.MIN_VALUE;
    int dfs(TreeNode root){
        if(root.left==null&root.right==null){
            res=Math.max(res,root.val);
            return root.val;
        }
        int left = Integer.MIN_VALUE/2,right = Integer.MIN_VALUE/2;
        if(root.left!=null)
            left=root.val+dfs(root.left);
        if(root.right!=null)
            right=root.val+dfs(root.right);
        res=Math.max(res,root.val);
        res=Math.max(res,left);
        res=Math.max(res,right);
        res=Math.max(res,left+right-root.val);
        return Math.max(left,Math.max(right,root.val));
    }

//    public static void main(String[] args) {
//        Solution solution=new Solution();
//        solution.maxPathSum(new TreeNode(-2,new TreeNode(-1),null));
//    }
}