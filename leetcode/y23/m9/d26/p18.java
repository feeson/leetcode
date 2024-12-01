package y23.m9.d26;
/**
 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。


 每条从根节点到叶节点的路径都代表一个数字：


 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。


 计算从根节点到叶节点生成的 所有数字之和 。

 叶节点 是指没有子节点的节点。



 示例 1：

 输入：root = [1,2,3]
 输出：25
 解释：
 从根到叶子节点路径 1->2 代表数字 12
 从根到叶子节点路径 1->3 代表数字 13
 因此，数字总和 = 12 + 13 = 25

 示例 2：

 输入：root = [4,9,0,5,1]
 输出：1026
 解释：
 从根到叶子节点路径 4->9->5 代表数字 495
 从根到叶子节点路径 4->9->1 代表数字 491
 从根到叶子节点路径 4->0 代表数字 40
 因此，数字总和 = 495 + 491 + 40 = 1026




 提示：


 树中节点的数目在范围 [1, 1000] 内
 0 <= Node.val <= 9
 树的深度不超过 10




 */
/*
https://leetcode.cn/problems/sum-root-to-leaf-numbers/?envType=study-plan-v2&envId=top-interview-150
*/

class Solutionp18 {

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

    public int sumNumbers(TreeNode root) {
        return dfs(root,0,0);
    }
    int dfs(TreeNode root,int sum,int n){
        if (root==null)return sum;
        sum=sum*10+root.val;
        if (root.left==null&&root.right==null)
            return sum;
        if (root.left==null)
            return dfs(root.right,sum,n+1);
        if (root.right==null)
            return dfs(root.left,sum,n+1);
        return dfs(root.left,sum,n+1)+dfs(root.right,sum,n+1);
    }

//    public static void main(String[] args) {
//        Solution solution=new Solution();
//        solution.sumNumbers(new TreeNode(1,new TreeNode(2),new TreeNode(3) ));
//    }
}