package y24.m8.d17.p1;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        int len = word.length();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0;i < len; i+=k){
            String str = word.substring(i, i + k);
            int count = map.computeIfAbsent(str, z -> 0);
            count += 1;
            map.put(str, count);
        }
        int max = 0;
        for (Integer val : map.values()) {
            max = Math.max(val, max);
        }
        int total = len / k;
        return total - max;
    }
}