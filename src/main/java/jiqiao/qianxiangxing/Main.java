package jiqiao.qianxiangxing;

import java.util.*;
class Solution {
    static int[] head,nxt,to,weight;
    static int cnt = 0;
    static void init(int n, int m){
        m<<=1;
        head = new int[n];
        Arrays.fill(head,-1);
        nxt = new int[m];
        to = new int[m];
        weight = new int[m];
    }
    static void add(int f,int t,int w){
        to[cnt] = t;
        nxt[cnt] = head[f];
        weight[cnt] = w;
        head[f] = cnt++;
        to[cnt] = f;
        nxt[cnt] = head[t];
        weight[cnt] = w;
        head[t] = cnt++;
    }
    public static List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int[][] edgeIndex = new int[n][n];
        int index = 0;
        for (int[] edge:edges){
            edgeIndex[edge[0]][edge[1]] = index++;
        }
        Arrays.sort(edges, Comparator.comparingInt(a-> -a[2]));
        int m = edges.length;
        init(n,m);
        for (int[] edge : edges) {
            add(edge[0], edge[1], edge[2]);
        }
        Set<Integer> nes = new HashSet<>();
        Set<Integer> unn = new HashSet<>();
        int start = -1;
        Set<Integer> candidate = new HashSet<>();
        for (int i = 0;i < n;++i){
            candidate.add(i);
        }
        int[] cost = new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE);
        while (!candidate.isEmpty()){
            if (start == -1){
                start = 0;
            }
            else {
                // 寻找最小的作为start
                int minV = Integer.MAX_VALUE;
                for (int i:candidate){
                    int w = cost[i];
                    if (w < minV){
                        minV = w;
                        start = i;
                    }
                }
            }
            candidate.remove(start);
            int fixW = -1;
            List<Integer> list = new ArrayList<>();
            boolean isNes = true;
            for (int e = head[start];e != -1;e = nxt[e]){
                int t = to[e];
                if (!candidate.contains(t))
                    continue;
                if (fixW == -1){
                    fixW = weight[e];
                    // 更新距离
                    cost[t] = Math.min(cost[t],fixW);
                    list.add(edgeIndex[start][t]);
                } else if (fixW == weight[e]) {
                    isNes = false;
                    cost[t] = Math.min(cost[t],fixW);
                    list.add(edgeIndex[start][t]);
                } else if (fixW != weight[e])
                    break;
            }
            if (isNes)
                nes.addAll(list);
            else
                unn.addAll(list);
        }
        List<List<Integer>> res = new ArrayList<>();
//        res.add(0,nes.stream().toList());
//        res.add(1,unn.stream().toList());
        return  res;
    }

    public static void main(String[] args) {
        int[][]arr=new int[][]{{0,1,1},{1,2,1},{2,3,2},{0,3,2},{0,4,3},{3,4,3},{1,4,6}};
        findCriticalAndPseudoCriticalEdges(5,arr);
    }
}