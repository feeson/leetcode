package y23.m9.d21;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;

/**
 树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。

 给你一棵包含n个节点的树，标记为0到n - 1 。给定数字n和一个有 n - 1 条无向边的 edges列表（每一个边都是一对标签），其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条无向边。

 可选择树中任何一个节点作为根。当选择节点 x 作为根节点时，设结果树的高度为 h 。在所有可能的树中，具有最小高度的树（即，min(h)）被称为 最小高度树 。

 请你找到所有的 最小高度树 并按 任意顺序 返回它们的根节点标签列表。
 树的 高度 是指根节点和叶子节点之间最长向下路径上边的数量。



 示例 1：

 输入：n = 4, edges = [[1,0],[1,2],[1,3]]
 输出：[1]
 解释：如图所示，当根是标签为 1 的节点时，树的高度是 1 ，这是唯一的最小高度树。

 示例 2：

 输入：n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
 输出：[3,4]







 提示：


 1 <= n <= 2 * 104
 edges.length == n - 1
 0 <= ai, bi < n
 ai != bi
 所有 (ai, bi) 互不相同
 给定的输入 保证 是一棵树，并且 不会有重复的边


 */
/*
https://leetcode.cn/problems/minimum-height-trees/
*/
class Solutionp2 {
    int[][]maxL;
    List<Integer>[] edge;
    int[]res;
    int min;
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        edge=new List[n];
        maxL=new int[n][2];
        res=new int[n];
        Arrays.setAll(edge, (IntFunction<List<Integer>>) value -> new ArrayList<>());
        for (int[]t:maxL)
            Arrays.fill(t,-1);
        for (int[]t:edges){
            edge[t[0]].add(t[1]);
            edge[t[1]].add(t[0]);
        }
        dfs(0,-1);
        res[0]=maxL[0][0];
        min=res[0];
        for (int val:edge[0])
            dfs2(val,0);
        List<Integer> ret=new ArrayList<>();
        for (int i=0;i<n;++i){
            if (res[i]==min)
                ret.add(i);
        }
        return ret;
    }
    void dfs(int i,int from){
        int lvl=0;
        for (int val:edge[i]){
            if (val==from)
                continue;
            dfs(val,i);
            lvl=Math.max(maxL[val][0]+1,lvl);
            if (lvl>=maxL[i][0]){
                maxL[i][1]=maxL[i][0];
                maxL[i][0]=lvl;
            }
        }
        maxL[i][0]=lvl;
    }
    void dfs2(int i,int from){
        res[i]=Math.max(maxL[i][0],((maxL[i][0]+1)==maxL[from][0]?maxL[from][1]:maxL[from][0])+1);
        if (res[i]<min)
            min=res[i];
        for (int val:edge[i]){
            if (val==from)
                continue;
            dfs2(val,i);
        }
    }
}