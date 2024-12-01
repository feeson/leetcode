package y23.m9.d15;

import y22.m09.d27.p1.Solution;

import javax.print.attribute.standard.Finishings;
import java.util.*;

/**
 给你一棵树，树上有 n 个节点，按从 0 到 n-1 编号。树以父节点数组的形式给出，其中 parent[i] 是节点 i 的父节点。树的根节点是编号为 0 的节点。

 树节点的第 k 个祖先节点是从该节点到根节点路径上的第 k 个节点。

 实现 TreeAncestor 类：


 TreeAncestor（int n， int[] parent） 对树和父数组中的节点数初始化对象。
 getKthAncestor(int node, int k) 返回节点 node 的第 k 个祖先节点。如果不存在这样的祖先节点，返回 -1。




 示例 1：



 输入：
 ["TreeAncestor","getKthAncestor","getKthAncestor","getKthAncestor"]
 [[7,[-1,0,0,1,1,2,2]],[3,1],[5,2],[6,3]]

 输出：
 [null,1,0,-1]

 解释：
 TreeAncestor treeAncestor = new TreeAncestor(7, [-1, 0, 0, 1, 1, 2, 2]);

 treeAncestor.getKthAncestor(3, 1);  // 返回 1 ，它是 3 的父节点
 treeAncestor.getKthAncestor(5, 2);  // 返回 0 ，它是 5 的祖父节点
 treeAncestor.getKthAncestor(6, 3);  // 返回 -1 因为不存在满足要求的祖先节点




 提示：


 1 <= k <= n <= 5 * 104
 parent[0] == -1 表示编号为 0 的节点是根节点。
 对于所有的 0 <i < n ，0 <= parent[i] < n 总成立
 0 <= node < n
 至多查询5 * 104 次


 */
/*
https://leetcode.cn/problems/kth-ancestor-of-a-tree-node/?envType=daily-question&envId=2023-09-15
*/
class TreeAncestor {
    int[][]pa;
    int len;
    int n;
    public TreeAncestor(int n, int[] parent) {
        //pa[i][0]=parent[i]
        //pa[i][1]=parent[parent[i]]
        //pa[i][j+1]=pa[pa[i][j]][j]
        len=parent.length;
        this.n=n;
        pa=new int[len][31-Integer.numberOfLeadingZeros(n)];
        for (int i=0;i<len;++i)
            pa[i][0]=parent[i];
        for (int i=1;i<pa[0].length;++i){
            for (int j=0;j<len;++j){
                if (pa[j][i-1]==-1)
                    pa[j][i]=-1;
                else
                    pa[j][i]=pa[pa[j][i-1]][i-1];
            }
        }
    }
    public int getKthAncestor(int node, int k) {
        int m = 32 - Integer.numberOfLeadingZeros(k); // k 的二进制长度
        for (int i = 0; i < m; i++) {
            if (((k >> i) & 1) > 0) { // k 的二进制从低到高第 i 位是 1
                node = pa[node][i];
                if (node < 0) break;
            }
        }
        return node;
    }

//    public static void main(String[] args) {
//        Solution solution=new Solution();
//        int[]arr=new int[]{-1,0,1,2,0,1,0,4,7,1};
//        TreeAncestor treeAncestor=new TreeAncestor(10,arr);
//        treeAncestor.getKthAncestor(3, 3);
//        treeAncestor.getKthAncestor(2, 9);
//        treeAncestor.getKthAncestor(2, 2);
//        int kthAncestor = treeAncestor.getKthAncestor(3, 2);
//        System.out.println(kthAncestor);
//    }

}