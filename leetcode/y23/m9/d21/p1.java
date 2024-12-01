package y23.m9.d21;

import java.util.*;
import java.util.function.IntFunction;

/**
 给你一个 n个节点的无向无根树，节点编号从0到n - 1。给你整数n和一个长度为 n - 1的二维整数数组 edges，其中edges[i] = [ai, bi]表示树中节点ai 和bi之间有一条边。再给你一个长度为 n的数组coins，其中coins[i] 可能为0也可能为1，1表示节点 i处有一个金币。

 一开始，你需要选择树中任意一个节点出发。你可以执行下述操作任意次：


 收集距离当前节点距离为 2以内的所有金币，或者
 移动到树中一个相邻节点。


 你需要收集树中所有的金币，并且回到出发节点，请你返回最少经过的边数。

 如果你多次经过一条边，每一次经过都会给答案加一。



 示例 1：



 输入：coins = [1,0,0,0,0,1], edges = [[0,1],[1,2],[2,3],[3,4],[4,5]]
 输出：2
 解释：从节点 2 出发，收集节点 0 处的金币，移动到节点 3 ，收集节点 5 处的金币，然后移动回节点 2 。


 示例 2：



 输入：coins = [0,0,0,1,1,0,0,1], edges = [[0,1],[0,2],[1,3],[1,4],[2,5],[5,6],[5,7]]
 输出：2
 解释：从节点 0 出发，收集节点 4 和 3 处的金币，移动到节点 2 处，收集节点 7 处的金币，移动回节点 0 。




 提示：


 n == coins.length
 1 <= n <= 3 * 104
 0 <= coins[i] <= 1
 edges.length == n - 1
 edges[i].length == 2
 0 <= ai, bi < n
 ai != bi
 edges表示一棵合法的树。


 */
/*
https://leetcode.cn/problems/collect-coins-in-a-tree/?envType=daily-question&envId=2023-09-21
*/
class Solutionp1 {
    public int collectTheCoins(int[] coins, int[][] edges) {
        int len=coins.length;
        List<Integer>[] nodes=new List[len];
        Arrays.setAll(nodes,
                      (IntFunction<List<Integer>>) value -> new ArrayList<>());
        int[] inDegree=new int[len];
        for (int[]edge:edges){
            nodes[edge[0]].add(edge[1]);
            nodes[edge[1]].add(edge[0]);
            inDegree[edge[0]]++;
            inDegree[edge[1]]++;
        }
        Deque<Integer> deque=new ArrayDeque<>();
        for (int i=0;i<len;++i){
            if (inDegree[i]==1&&coins[i]==0)
                deque.add(i);
        }
        int totalEdge=edges.length;
        while (!deque.isEmpty()){
            Integer poll = deque.poll();
            totalEdge--;
            for (int next:nodes[poll]){
                if (--inDegree[next]==1&&coins[next]==0)
                    deque.add(next);
            }
        }
        for (int i=0;i<len;++i){
            if (inDegree[i]==1&&coins[i]==1)
                deque.add(i);
        }
        while (!deque.isEmpty()){
            Integer poll = deque.poll();
            totalEdge--;
            for (int next:nodes[poll]){
                if (--inDegree[next]==1)
                    totalEdge--;
            }
        }
        return Math.max(0,2*totalEdge);
    }
}