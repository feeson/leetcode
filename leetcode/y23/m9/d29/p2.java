package y23.m9.d29;
/**
 给定一个非空二叉树的根节点root, 以数组的形式返回每一层节点的平均值。与实际答案相差10-5 以内的答案可以被接受。



 示例 1：



 输入：root = [3,9,20,null,null,15,7]
 输出：[3.00000,14.50000,11.00000]
 解释：第 0 层的平均值为 3,第 1 层的平均值为 14.5,第 2 层的平均值为 11 。
 因此返回 [3, 14.5, 11] 。


 示例 2:



 输入：root = [3,9,20,15,7]
 输出：[3.00000,14.50000,11.00000]




 提示：




 树中节点数量在[1, 104] 范围内
 -231<= Node.val <= 231- 1


 */
/*
https://leetcode.cn/problems/average-of-levels-in-binary-tree/?envType=study-plan-v2&envId=top-interview-150
*/


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


class Solution {

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

    public List<Double> averageOfLevels(TreeNode root) {
        Deque<TreeNode> deque=new LinkedList<>();
        deque.addLast(root);
        deque.addLast(null);
        double sum=0;
        int n=0;
        List<Double> res=new ArrayList<>();
        while (!deque.isEmpty()){
            TreeNode t = deque.pollFirst();
            if (t==null){
                res.add(sum/n);
                sum=0;
                n=0;
                if (!deque.isEmpty())
                    deque.add(null);
            }
            else {
                sum+=t.val;
                n++;
                if(t.left!=null)
                    deque.addLast(t.left);
                if (t.right!=null)
                    deque.addLast(t.right);
            }
        }
        return res;
    }
}