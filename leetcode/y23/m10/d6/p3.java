package y23.m10.d6;

import Bean.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。



 示例 1：

 输入：root = [3,9,20,null,null,15,7]
 输出：[[3],[20,9],[15,7]]


 示例 2：

 输入：root = [1]
 输出：[[1]]


 示例 3：

 输入：root = []
 输出：[]




 提示：


 树中节点数目在范围 [0, 2000] 内
 -100 <= Node.val <= 100


 */
/*
https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/?envType=study-plan-v2&envId=top-interview-150
*/
class Solutionp3 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if (root==null)
            return res;
        boolean vec=true;
        Deque<TreeNode> deque=new LinkedList<>();
        deque.addLast(root);
        int i=0;
        int cur=1;
        int next=0;
        while (!deque.isEmpty()){
            TreeNode node=null;
            if (vec)
                node=deque.pollFirst();
            else
                node=deque.pollLast();
            if (i==0){
                res.add(new ArrayList<>());
            }
            res.get(res.size()-1).add(node.val);
            if (vec){
                if (node.left!=null){
                    deque.addLast(node.left);
                    next++;
                }
                if (node.right!=null){
                    deque.addLast(node.right);
                    next++;
                }
            }else {

                if (node.right!=null){
                    deque.addFirst(node.right);
                    next++;
                }
                if (node.left!=null){
                    deque.addFirst(node.left);
                    next++;
                }
            }

            i++;
            if (i==cur){
                i=0;
                cur=next;
                next=0;
                vec=!vec;
            }
        }
        return res;
    }
}