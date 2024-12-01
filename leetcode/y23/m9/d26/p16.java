package y23.m9.d26;
/**
 给你二叉树的根结点 root ，请你将它展开为一个单链表：


 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 展开后的单链表应该与二叉树 先序遍历 顺序相同。




 示例 1：

 输入：root = [1,2,5,3,4,null,6]
 输出：[1,null,2,null,3,null,4,null,5,null,6]


 示例 2：

 输入：root = []
 输出：[]


 示例 3：

 输入：root = [0]
 输出：[0]




 提示：


 树中结点数在范围 [0, 2000] 内
 -100 <= Node.val <= 100




 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？

 */
/*
https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/?envType=study-plan-v2&envId=top-interview-150
*/

class Solutionp16 {
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

    public void flatten(TreeNode root) {
        dfs(root);
    }
    TreeNode dfs(TreeNode root){
        if (root==null)return null;
        TreeNode lastL=dfs(root.left);
        if (lastL==null)
            lastL=root.left;
        if (lastL==null)
            lastL=root;
        TreeNode lastR = dfs(root.right);
        if (lastR==null)
            lastR=root.right;
        TreeNode t=root.right;
        root.right=root.left;
        root.left=null;
        lastL.right=t;
        if (lastR==null)
            return lastL;
        return lastR;
    }

//    public static void main(String[] args) {
//        Solution solution=new Solution();
//        solution.flatten(new TreeNode(1,new TreeNode(2,new TreeNode(3),null),null));
//    }
}