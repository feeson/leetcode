package y23.m10.d6;

import Bean.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。



 示例 1：

 输入：root = [3,9,20,null,null,15,7]
 输出：[[3],[9,20],[15,7]]


 示例 2：

 输入：root = [1]
 输出：[[1]]


 示例 3：

 输入：root = []
 输出：[]




 提示：


 树中节点数目在范围 [0, 2000] 内
 -1000 <= Node.val <= 1000


 */
/*
https://leetcode.cn/problems/binary-tree-level-order-traversal/?envType=study-plan-v2&envId=top-interview-150
*/

class Solutionp2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if (root==null)
            return res;
        Deque<TreeNode> deque=new LinkedList<>();
        deque.addLast(root);
        int i=0;
        int cur=1;
        int next=0;
        while (!deque.isEmpty()){
            TreeNode node=deque.pollFirst();
            if (i==0){
                res.add(new ArrayList<>());
            }
            res.get(res.size()-1).add(node.val);
            if (node.left!=null){
                deque.addLast(node.left);
                next++;
            }
            if (node.right!=null){
                deque.addLast(node.right);
                next++;
            }
            i++;
            if (i==cur){
                i=0;
                cur=next;
                next=0;
            }
        }
        return res;
    }

//    public static void main(String[] args) {
//        Solution solution=new Solution();
//
//    }
}