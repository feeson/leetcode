package y24.m12.d1.p1;

import java.util.*;

class Solution {
    int[] pa;
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        pa = new int[n];
        int qlen = queries.length;
        for (int i = 0; i < n; i++) {
            pa[i] = i + 1;
        }
        pa[n - 1] = n - 1;
        int res = n - 1;
        int cnt = 0;
        int[] result = new int[qlen];
        for (int[] query : queries) {
            for (int i = query[0]; i < query[1];) {
                int rt = i;
                while (pa[rt] != rt && rt < query[1]){
                    rt = pa[rt];
                }
                while (pa[i] != rt){
                    int nxt = pa[i];
                    pa[i] = rt;
                    res--;
                    i = nxt;
                }
                i = pa[i];
            }
            result[cnt++] = res;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.shortestDistanceAfterQueries(5, new int[][]{
                {2,4},
                {0,2},
                {0,4}
        });
//        0 1 2 3 4
    }
}