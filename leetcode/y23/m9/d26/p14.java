package y23.m9.d26;
/**
 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗二叉树。



 示例 1:

 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 输出：[3,9,20,null,null,15,7]


 示例 2:

 输入：inorder = [-1], postorder = [-1]
 输出：[-1]




 提示:


 1 <= inorder.length <= 3000
 postorder.length == inorder.length
 -3000 <= inorder[i], postorder[i] <= 3000
 inorder和postorder都由 不同 的值组成
 postorder中每一个值都在inorder中
 inorder保证是树的中序遍历
 postorder保证是树的后序遍历


 */
/*
https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/?envType=study-plan-v2&envId=top-interview-150
*/
class Solutionp14 {

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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len=postorder.length;
        return buildTree(postorder,inorder,postorder[len-1],len-1,0,inorder.length);
    }
    TreeNode buildTree(int[]postorder,int[]inorder,int root,int index,int boundLeft,int boundRight){
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
        int ss=index+mid-boundRight;
        if (ss>=0) {
            node.left=buildTree(postorder,inorder,postorder[ss],ss,boundLeft,mid);
        }
        if (index-1>= 0)
            node.right=buildTree(postorder,inorder,postorder[index-1],index-1,mid+1,boundRight);
        return node;
    }

//    public static void main(String[] args) {
//        Solution solution=new Solution();
//        int[]arr1=new int[]{9,3,15,20,7};
//        int[]arr2=new int[]{9,15,7,20,3};
//        TreeNode treeNode = solution.buildTree(arr1, arr2);
//    }
}