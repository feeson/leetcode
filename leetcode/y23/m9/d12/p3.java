package y23.m9.d12;

import java.util.*;

/**
 给你一棵以root为根的二叉树，请你返回 任意二叉搜索子树的最大键值和。

 二叉搜索树的定义如下：


 任意节点的左子树中的键值都小于此节点的键值。
 任意节点的右子树中的键值都 大于此节点的键值。
 任意节点的左子树和右子树都是二叉搜索树。




 示例 1：



 输入：root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
 输出：20
 解释：键值为 3 的子树是和最大的二叉搜索树。


 示例 2：



 输入：root = [4,3,null,1,2]
 输出：2
 解释：键值为 2 的单节点子树是和最大的二叉搜索树。


 示例 3：

 输入：root = [-4,-2,-5]
 输出：0
 解释：所有节点键值都为负数，和最大的二叉搜索树为空。


 示例 4：

 输入：root = [2,1,3]
 输出：6


 示例 5：

 输入：root = [5,4,8,3,null,6,3]
 输出：7




 提示：


 每棵树有 1 到 40000个节点。
 每个节点的键值在[-4 * 10^4, 4 * 10^4] 之间。


 */
/*
https://leetcode.cn/problems/maximum-sum-bst-in-binary-tree/?envType=daily-question&envId=2023-09-12
*/

class Solutionp3 {

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
    int max=0;
    List<TreeNode> couldNode=new ArrayList<>();
    Map<TreeNode,Integer> full=new HashMap<>();//==-1 means illegal
    public int maxSumBST(TreeNode root) {
        judge(root, Integer.MAX_VALUE, true,new int[2]);
        for (TreeNode node:couldNode){
            sum(node);
        }
        return max;
    }
    boolean judge(TreeNode root,int lastVal,boolean isLeft,int[] num){
        if (root==null) return true;
        if (root.left==null&&root.right==null){
            couldNode.add(root);
        }
        int[]arr1=new int[2],arr2=new int[2];
        Arrays.fill(arr1,root.val);
        Arrays.fill(arr2,root.val);
        boolean left=judge(root.left,root.val,true,arr1);
        boolean right=judge(root.right,root.val,false,arr2);
        if (root.left==null&&root.right==null){
            num[0]=root.val;
            num[1]=root.val;
            return true;
        }
        if (left&&right&&(root.left==null||root.val>arr1[1])&&(root.right==null||root.val<arr2[0])){
            couldNode.add(root);
            num[0]=Math.min(arr1[0],arr2[0]);
            num[1]=Math.max(arr1[1],arr2[1]);
            return true;
        }else {
            return false;
        }
    }
    int sum(TreeNode root){
        if (root==null)return 0;
        if (full.containsKey(root))return full.get(root);
        if (root.left==null&&root.right==null){
            full.put(root,root.val);
            max=Math.max(max, root.val);
            return root.val;
        }
        int left=sum(root.left);
        int right=sum(root.right);
        int t=root.val+left+right;
        full.put(root,t);
        max=Math.max(max,t);
        return t;
    }
}