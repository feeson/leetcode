package y24.m5.d4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<Integer>[] to;
    List<Integer>[] come;
    boolean[] visit;
    public int minReorder(int n, int[][] connections) {
        visit = new boolean[n];
        to = new List[n];
        come = new List[n];
        for (int i = 0;i < n - 1; ++i){
            int s = connections[i][0];
            int t = connections[i][1];
            if (to[s] == null)
                to[s] = new ArrayList<>();
            to[s].add(t);
            if (come[t] == null)
                come[t] = new ArrayList<>();
            come[t].add(s);
        }
        return dfs(0);
    }
    int dfs(int i){
        visit[i] = true;
        List<Integer> list = to[i];
        int ans = 0;
        if (list!=null){
            for (int t: list){
                if (!visit[t]){
                    ans++;
                    ans += dfs(t);
                }
            }
        }
        list = come[i];
        if (list != null){
            for (int t:list){
                if (!visit[t]){
                    ans += dfs(t);
                }
            }
        }
        return ans;
    }
}