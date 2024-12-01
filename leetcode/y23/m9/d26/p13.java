package y23.m9.d26;
/**
 给定两个整数数组preorder 和 inorder，其中preorder 是二叉树的先序遍历， inorder是同一棵树的中序遍历，请构造二叉树并返回其根节点。



 示例 1:

 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 输出: [3,9,20,null,null,15,7]


 示例 2:

 输入: preorder = [-1], inorder = [-1]
 输出: [-1]




 提示:


 1 <= preorder.length <= 3000
 inorder.length == preorder.length
 -3000 <= preorder[i], inorder[i] <= 3000
 preorder和inorder均 无重复 元素
 inorder均出现在preorder
 preorder保证 为二叉树的前序遍历序列
 inorder保证 为二叉树的中序遍历序列


 */
/*
https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/?envType=study-plan-v2&envId=top-interview-150
*/

class Solutionp13 {

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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder,inorder,preorder[0],0,0,inorder.length);
    }
    TreeNode buildTree(int[]preorder,int[]inorder,int root,int index,int boundLeft,int boundRight){
        if (boundRight-boundLeft==1)
            return new TreeNode(root);
        else if (boundRight-boundLeft==0)
            return null;
        int mid=0;
        for (int i=boundLeft;i<boundRight;++i)
            if (inorder[i]==root){
                mid=i;
                break;
            }
        TreeNode node=new TreeNode(root);
        if (index+1<inorder.length)
            node.left=buildTree(preorder,inorder,preorder[index+1],index+1,boundLeft,mid);
        int ss=index+mid-boundLeft+1;
        if (ss< inorder.length)
            node.right=buildTree(preorder,inorder,preorder[ss],ss,mid+1,boundRight);
        return node;
    }

//    public static void main(String[] args) {
//        Solution solution=new Solution();
//        int[]arr1=new int[]{1,2};
//        int[]arr2=new int[]{1,2};
//        TreeNode treeNode = solution.buildTree(arr1, arr2);
//    }
}