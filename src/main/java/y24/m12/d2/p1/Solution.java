package y24.m12.d2.p1;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int curlevel = 0;
        int len = triangle.size();
        int[] nxt = new int[len];
        int[] cur = new int[len];
        int[] t = null;
        cur[0] = triangle.get(0).get(0);
        while (curlevel != len - 1){
            List<Integer> nxtrow = triangle.get(curlevel + 1);
            for (int i = 0; i < nxtrow.size(); i++) {
                if (i == 0){
                    nxt[i] = cur[i] + nxtrow.get(i);
                }else if (i > curlevel){
                    nxt[i] = cur[i - 1] + nxtrow.get(i);
                }else {
                    nxt[i] = Math.min(cur[i - 1], cur[i]) + nxtrow.get(i);
                }
            }
            t = cur;
            cur = nxt;
            nxt = t;
            curlevel++;
        }
        int min = Integer.MAX_VALUE;
        for (int val: cur)
            min = Math.min(min, val);
        return min;
    }
}