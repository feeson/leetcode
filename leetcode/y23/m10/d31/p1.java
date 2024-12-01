package y23.m10.d31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 节点 0 处现有一棵由 n 个节点组成的无向树，节点编号从 0 到 n - 1 。给你一个长度为 n - 1 的二维 整数 数组 edges ，其中 edges[i] = [ai, bi] 表示在树上的节点 ai 和 bi 之间存在一条边。另给你一个下标从 0 开始、长度为 n 的数组 coins 和一个整数 k ，其中 coins[i] 表示节点 i 处的金币数量。

 从根节点开始，你必须收集所有金币。要想收集节点上的金币，必须先收集该节点的祖先节点上的金币。

 节点 i 上的金币可以用下述方法之一进行收集：


 收集所有金币，得到共计 coins[i] - k 点积分。如果 coins[i] - k 是负数，你将会失去 abs(coins[i] - k) 点积分。
 收集所有金币，得到共计 floor(coins[i] / 2) 点积分。如果采用这种方法，节点 i 子树中所有节点 j 的金币数 coins[j] 将会减少至 floor(coins[j] / 2) 。


 返回收集 所有 树节点的金币之后可以获得的最大积分。



 示例 1：

 输入：edges = [[0,1],[1,2],[2,3]], coins = [10,10,3,3], k = 5
 输出：11
 解释：
 使用第一种方法收集节点 0 上的所有金币。总积分 = 10 - 5 = 5 。
 使用第一种方法收集节点 1 上的所有金币。总积分 = 5 + (10 - 5) = 10 。
 使用第二种方法收集节点 2 上的所有金币。所以节点 3 上的金币将会变为 floor(3 / 2) = 1 ，总积分 = 10 + floor(3 / 2) = 11 。
 使用第二种方法收集节点 3 上的所有金币。总积分 =  11 + floor(1 / 2) = 11.
 可以证明收集所有节点上的金币能获得的最大积分是 11 。


 示例 2：


 输入：edges = [[0,1],[0,2]], coins = [8,4,4], k = 0
 输出：16
 解释：
 使用第一种方法收集所有节点上的金币，因此，总积分 = (8 - 0) + (4 - 0) + (4 - 0) = 16 。




 提示：


 n == coins.length
 2 <= n <= 105
 0 <= coins[i] <= 104
 edges.length == n - 1
 0 <= edges[i][0], edges[i][1] < n
 0 <= k <= 104


 */
/*
https://leetcode.cn/problems/maximum-points-after-collecting-coins-from-all-nodes/
*/
class Solution {
    int[]to;
    int[]next;
    int cnt=0;
    int[]head;
    int[]coins;
    int k;
    void add(int i,int j){
        to[cnt]=j;
        next[cnt]=head[i];
        head[i]=cnt++;
    }
    int NO_SEARCH=Integer.MIN_VALUE;
    public int maximumPoints(int[][] edges, int[] coins, int k) {
        this.coins=coins;
        this.k=k;
        int len=coins.length;
        int numsEdge= edges.length*2;
        memo=new int[len][15];
        for (int i=0;i<len;++i)
            Arrays.fill(memo[i],NO_SEARCH);
        to=new int[numsEdge];
        next=new int[numsEdge];
        head=new int[len];
        Arrays.fill(head,-1);
        for (int[]edge:edges){
            add(edge[0],edge[1]);
            add(edge[1],edge[0]);
        }
        return dfs(-1,0,0);
    }
    int[][]memo;
    int dfs(int pa,int i,int j){
        if (j>=15)
            return 0;
        //return[0] 第一种方式 return[1] 第二种方式
        int[] res= new int[]{j==0?coins[i]-k:NO_SEARCH,j==0?coins[i]>>1:coins[i]>>j};
        if (memo[i][j]!=NO_SEARCH) {
            return memo[i][j];
        }
        for (int edge=head[i];edge!=-1;edge=next[edge]){
            int to=this.to[edge];
            if (to==pa)
                continue;
            if (j==0){
                int l=dfs(i,to,2);
                int r=dfs(i,to,0);
                res[0]+=r;
                res[1]+=l;
            }else {
                int l=dfs(i, to,j+1);
                res[1]+=l;
            }
        }
        memo[i][j]=Math.max(res[0],res[1]);
        ArrayList<int[]> list = new ArrayList<>();
        list.add(new int[]{1,2});
        return memo[i][j];
    }

    /*
    0/9 - 1/0 - 2/9
              \ 7/5
        \ 3/6 - 4/7 - 6/5 - 8/1
        \ 5/6 - 9/10
     */
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[][]edges=new int[][]{{0,1},{2,1},{3,0},{3,4},{5,0},{6,4},{7,1},{6,8},{9,5}};
        int[]coins=new int[]{9,0,9,6,7,6,5,7,1,10};
        int k=7;
        int i = solution.maximumPoints(edges, coins, k);
        System.out.println(i);
    }
}