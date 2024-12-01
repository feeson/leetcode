package y24.m3.d25.p2;

import java.util.*;

class Solution {
    public static int minCostConnectPoints(int[][] points) {
        int len = points.length;
        int[][] map = new int[len][len];
        Set<Integer> chose = new HashSet<>(len);
        for (int i = 0; i < len;++i){
            chose.add(i);
            for (int j = i+1; j<len;++j){
                int val = Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                map[i][j] = val;
                map[j][i] = val;
            }
        }
        int val = 0;
        int[] cost = new int[len];
        Arrays.fill(cost,Integer.MAX_VALUE);
        cost[0] = 0;
        int start = -1;
        while (!chose.isEmpty()){
            if (start != -1){
                int maxV = Integer.MAX_VALUE;
                for (int i:chose){
                    if (cost[i] < maxV){
                        maxV = cost[i];
                        start = i;
                    }
                }
            }else {
                start = 0;
            }
            chose.remove(start);
            val+=cost[start];
            for (int j:chose){
                cost[j] = Math.min(cost[j],map[start][j]);
            }
        }
        return val;
    }

    public static void main(String[] args) {
        int[][] p =new int[][]{{0,0},{2,2},{3,10},{5,2},{7,0}};
        minCostConnectPoints(p);
    }
}
