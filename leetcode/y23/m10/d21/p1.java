package y23.m10.d21;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 给你一个整数n，表示一张无向图中有 n个节点，编号为0到n - 1。同时给你一个二维整数数组edges，其中edges[i] = [ai, bi]表示节点ai 和bi之间有一条无向边。

 请你返回 无法互相到达的不同 点对数目。



 示例 1：



 输入：n = 3, edges = [[0,1],[0,2],[1,2]]
 输出：0
 解释：所有点都能互相到达，意味着没有点对无法互相到达，所以我们返回 0 。


 示例 2：



 输入：n = 7, edges = [[0,2],[0,5],[2,4],[1,6],[5,4]]
 输出：14
 解释：总共有 14 个点对互相无法到达：
 [[0,1],[0,3],[0,6],[1,2],[1,3],[1,4],[1,5],[2,3],[2,6],[3,4],[3,5],[3,6],[4,6],[5,6]]
 所以我们返回 14 。




 提示：


 1 <= n <= 105
 0 <= edges.length <= 2 * 105
 edges[i].length == 2
 0 <= ai, bi < n
 ai != bi
 不会有重复边。


 */
/*
https://leetcode.cn/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/?envType=daily-question&envId=2023-10-21
*/
class Solution {
    int[]pa;
    int find(int x){
        if (pa[x]<0)
            return x;
        while (pa[x]>=0){
            if (pa[pa[x]]>=0)
                pa[x]=pa[pa[x]];
            x=pa[x];
        }
        return x;
    }
    void union(int i,int j){
        int pai=find(i);
        int paj=find(j);
        if (pai==paj)
            return;
        pa[pai]+=pa[paj];
        pa[paj]=i;
    }
    public long countPairs(int n, int[][] edges) {
        pa=new int[n];
        Arrays.fill(pa,-1);
        for (int[] edge:edges){
            int n1=edge[0];
            int n2=edge[1];
            union(n1,n2);
        }
        List<Integer> list=new ArrayList<>();
        for (int i=0;i<n;++i){
            int t=find(i);
            if (t==i){
                list.add(-pa[i]);
            }
        }
        long sum=0;
        long res=0;
        int len=list.size();
        for (int i=0;i<len;++i){
            res+=list.get(i)*sum;
            sum += list.get(i);
        }
        return res;
    }

//    public static void main(String[] args) {
//        Solution solution=new Solution();
//        int[][]arr=new int[][]{{0,2},{0,5},{2,4},{1,6},{5,4}};
//        long t = solution.countPairs(7, arr);
//        System.out.println(t);
//    }
}