package y24.m11.d11.p1;

import java.util.Arrays;

class Solution {
    public int minCost(int n, int[] cuts) {
        int max = Integer.MAX_VALUE;
        int len = cuts.length;
        int[][] cache = new int[len + 2][len + 2];
        for(int i = 0; i < len + 2; ++i){
            Arrays.fill(cache[i], -1);
        }
        Arrays.sort(cuts);
        for(int i = 0;i < len; ++i){
            max = Math.min(max, cutMax(cuts, n, cache, -1, i) + cutMax(cuts, n, cache, i, len));
        }
        return max + n;
    }
    int cutMax(int[] cuts, int n, int[][] cache, int lindex, int rindex){
        if(rindex - lindex == 1){
            return 0;
        }
        if(cache[lindex + 1][rindex + 1] != -1){
            return cache[lindex + 1][rindex + 1];
        }
        int max = Integer.MAX_VALUE;
        for(int i = lindex + 1; i < rindex; ++i){
            max = Math.min(cutMax(cuts, n, cache, lindex, i) + cutMax(cuts, n, cache, i, rindex), max);
        }
        cache[lindex + 1][rindex + 1] = max + (rindex == cuts.length?n:cuts[rindex]) - (lindex == -1?0:cuts[lindex]);
        return cache[lindex + 1][rindex + 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minCost(9, new int[]{5,6,1,4,2});
    }
}