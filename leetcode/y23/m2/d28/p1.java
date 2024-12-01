package y23.m2.d28;

import java.util.*;

/**
 * 给你一个整数 n ，请你找出所有可能含 n 个节点的 真二叉树 ，并以列表形式返回。答案中每棵树的每个节点都必须符合 Node.val == 0 。
 *
 * 答案的每个元素都是一棵真二叉树的根节点。你可以按 任意顺序 返回最终的真二叉树列表。
 *
 * 真二叉树 是一类二叉树，树中每个节点恰好有 0 或 2 个子节点。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/all-possible-full-binary-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public List<TreeNode> allPossibleFBT(int n) {
        if (n==1){
            List<TreeNode> res= new ArrayList<>();
            res.add(new TreeNode(0));
            return  res;
        }
        if (n%2==0)
            return new ArrayList<>();
        List<List<TreeNode>>dp=new ArrayList<>();
        List<TreeNode> dpN1=new ArrayList<>();
        dpN1.add(new TreeNode(0));
        dp.add(0,new ArrayList<>());
        dp.add(1,dpN1);
        for(int j=1;j<= n; ++j){
            //dp[j]
            if (j%2==0){
                dp.add(j,new ArrayList<>());
                continue;
            }
            for (int k=1;k<j;k+=2){
                //左子树有k个节点
                //右子树有j-k-1个节点
                for (int l=0;l<dp.get(k).size();++l){
                    for (int m=0;m<dp.get(j-k-1).size();++m){
                        TreeNode node=new TreeNode(0);
                        node.left=dp.get(k).get(l);
                        node.right=dp.get(j-k-1).get(m);
                        if (dp.size()==j)
                            dp.add(j,new ArrayList<TreeNode>());
                        dp.get(j).add(node);
                    }
                }
            }
        }
        return dp.get(n);
    }
}