package y24.m9.d6.p1;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class Solution {
    public int maximumLength(int[] nums, int k) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int[] vals = new int[len];
        int cnt = 0;
        for (int val : nums) {
            if (!map.containsKey(val)){
                vals[cnt] = val;
                map.put(val, cnt++);
            }
        }
        int[][] dp = new int[map.size()][k + 1];
        for (int index = 0; index < len; index++){
            int val = nums[index];
            int vIdx = map.get(val);
            for (int idxk = 0; idxk <= k; idxk++) {
                dp[vIdx][idxk]++;
            }
            // update
            for (int upd = 0; upd < map.size(); ++upd){
                int uv = vals[upd];
                if (val != uv){
                    for (int idxk = 1; idxk <= k; idxk++) {
                        if (dp[upd][idxk - 1] != 0)
                            dp[vIdx][idxk] = Math.max(dp[vIdx][idxk], dp[upd][idxk - 1] + 1);
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j <= k; j++) {
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maximumLength(new int[]{1,2,1,1,3},2);
    }
}