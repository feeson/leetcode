package y23.m9.d18;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 给出二叉树的根节点root，树上每个节点都有一个不同的值。

 如果节点值在to_delete中出现，我们就把该节点从树上删去，最后得到一个森林（一些不相交的树构成的集合）。

 返回森林中的每棵树。你可以按任意顺序组织答案。



 示例 1：



 输入：root = [1,2,3,4,5,6,7], to_delete = [3,5]
 输出：[[1,2,null,4],[6],[7]]


 示例 2：

 输入：root = [1,2,4,null,3], to_delete = [3]
 输出：[[1,2,4]]




 提示：


 树中的节点数最大为1000。
 每个节点都有一个介于1 到1000之间的值，且各不相同。
 to_delete.length <= 1000
 to_delete 包含一些从1 到1000、各不相同的值。


 */
/*
https://leetcode.cn/problems/delete-nodes-and-return-forest/?envType=daily-question&envId=2023-09-18
*/
class Solutionp7 {

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
    Set<Integer> toDelete=new HashSet<>();
    List<TreeNode> res=new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for (int val:to_delete)
            toDelete.add(val);
        boolean dfs = dfs(root);
        if (!dfs)
            res.add(root);
        return res;
    }
    boolean dfs(TreeNode root){
        if (root==null)return false;
        boolean left=dfs(root.left);
        boolean right=dfs(root.right);
        if (toDelete.contains(root.val)){
            if (!left&&root.left!=null)
                res.add(root.left);
            if (!right&&root.right!=null)
                res.add(root.right);
            return true;
        }else {
            if (left)
                root.left=null;
            if (right)
                root.right=null;
            return false;
        }
    }

}