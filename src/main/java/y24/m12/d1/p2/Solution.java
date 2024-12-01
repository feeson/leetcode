package y24.m12.d1.p2;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        dfs(new int[n], new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1], 0, n);
        return result;
    }
    List<List<String>> result = new ArrayList<>();
    void build(int[] used, int n){
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j == used[i])
                    sb.append("Q");
                else
                    sb.append(".");
            }
            res.add(sb.toString());
        }
        result.add(res);
    }
    void dfs(int[] used, boolean[] col, boolean[] dia1, boolean[] dia2, int cnt, int n){
        for (int c = 0; c < n; c++) {
            if (col[c])
                continue;
            int d1 = cnt - c + n - 1;
            int d2 = c + cnt;
            if (dia1[d1] || dia2[d2])
                continue;
            used[cnt] = c;
            if (cnt == n - 1){
                build(used, n);
            }else {
                col[c] = true;
                dia1[d1] = true;
                dia2[d2] = true;
                dfs(used, col, dia1, dia2, cnt + 1, n);
                col[c] = false;
                dia1[d1] = false;
                dia2[d2] = false;
            }
        }
    }
}