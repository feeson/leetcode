package y24.m5.d5.p1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    int preLen = 0;
    public long maxTaxiEarnings(int n, int[][] rides) {
        int len = rides.length;
        Arrays.sort(rides, Comparator.comparingInt(a->a[1]));
        TreeMap<Integer,Long> treeMap = new TreeMap<>();

        treeMap.put(rides[0][1], (long) (rides[0][1] - rides[0][0] + rides[0][2]));
        for (int i = 1;i < len; ++i){
            int s = rides[i][0];
            int e = rides[i][1];
            int p = rides[i][2];
            Map.Entry<Integer, Long> entry = treeMap.floorEntry(s);
            long preSum = entry == null?0:entry.getValue();
            long v = preSum + e - s + p;
            v = Math.max(v, treeMap.isEmpty()?0:treeMap.lastEntry().getValue());
            treeMap.put(e, v);
        }
        return treeMap.floorEntry(Integer.MAX_VALUE).getValue();
    }
}
class Main{
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = new int[][]{{9,10,2},{4,5,6},{6,8,1},{1,5,5},{4,9,5},{1,6,5},{4,8,3},{4,7,10},{1,9,8},{2,3,5}};
        solution.maxTaxiEarnings(10, arr);
    }
}