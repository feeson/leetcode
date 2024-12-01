package y23.m8.d31;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 给你一个无向图，整数 n表示图中节点的数目，edges数组表示图中的边，其中edges[i] = [ui, vi]，表示ui 和vi之间有一条无向边。

 一个 连通三元组指的是 三个节点组成的集合且这三个点之间 两两有边。

 连通三元组的度数是所有满足此条件的边的数目：一个顶点在这个三元组内，而另一个顶点不在这个三元组内。

 请你返回所有连通三元组中度数的 最小值，如果图中没有连通三元组，那么返回 -1。



 示例 1：

 输入：n = 6, edges = [[1,2],[1,3],[3,2],[4,1],[5,2],[3,6]]
 输出：3
 解释：只有一个三元组 [1,2,3] 。构成度数的边在上图中已被加粗。


 示例 2：

 输入：n = 7, edges = [[1,3],[4,1],[4,3],[2,5],[5,6],[6,7],[7,5],[2,6]]
 输出：0
 解释：有 3 个三元组：
 1) [1,4,3]，度数为 0 。
 2) [2,5,6]，度数为 2 。
 3) [5,6,7]，度数为 2 。




 提示：


 2 <= n <= 400
 edges[i].length == 2
 1 <= edges.length <= n * (n-1) / 2
 1 <= ui, vi <= n
 ui != vi
 图中没有重复的边。


 */
/*
https://leetcode.cn/problems/minimum-degree-of-a-connected-trio-in-a-graph/
*/
class Solution {
    Set<Integer> inTrio=new HashSet<>();
    public int minTrioDegree(int n, int[][] edges) {
        Set<Integer>[] matrix=new Set[n+1];
        //matrix[i][j] from i to j
        for (int i=0;i<edges.length;++i){
            if (matrix[edges[i][0]]==null)
                matrix[edges[i][0]]=new HashSet<>();
            if (matrix[edges[i][1]]==null       )
                matrix[edges[i][1]]=new HashSet<>();
            matrix[edges[i][0]].add(edges[i][1]);
            matrix[edges[i][1]].add(edges[i][0]);
        }
        int res=0xfffffff;
        for (int i=1;i<=n;++i){
            res=Math.min(res,bfs(matrix,null,-1,i,0));
            if (res==0)
                return 0;
        }
        if (inTrio.size()==0)
            return -1;
        return res;
    }
    int bfs(Set<Integer>[] matrix,Set<Integer> upperSet,int upperVal,int from,int level){
        if (matrix[from]==null)
            return 0x7fffffff;
        int res=0x7fffffff;
        if (level==0){
            Set<Integer> couldTo = matrix[from];
            for (int val:couldTo){
                if (val<from)
                    continue;
                res=Math.min(res,bfs(matrix,couldTo,from,val,1)) ;
            }
            return res;
        }else {
            Set<Integer> couldTo=matrix[from];
            for (int val:couldTo){
                if (val<from)
                    continue;
                if (upperSet.contains(val)){
                    inTrio.add(val);
                    inTrio.add(from);
                    inTrio.add(upperVal);
                    res=Math.min(matrix[val].size()+matrix[from].size()+matrix[upperVal].size()-6,res);
                }
            }
            return res;
        }
    }
}