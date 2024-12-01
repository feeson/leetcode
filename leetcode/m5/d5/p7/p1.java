package y24.m5.d5.p7;

import java.util.*;

class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int len = points.length;
        Map<Integer, List<int[]>> map = new HashMap<>();
        int ans = 0;
        for (int i = 0;i < len; ++i){
            for (int j = i + 1; j < len; ++j){
                int val = cal(
                        points[i][0] - points[j][0],
                        points[i][1] - points[j][1]
                );
                List<int[]> times = map.getOrDefault(val, new ArrayList<>());
                times.add(new int[]{i, j});
                map.put(val,times);
            }
        }
        Optional<Integer> reduce = map.values().stream().map(list -> {
            Map<Integer, Integer> pTimes = new HashMap<>();
            list.forEach(arr -> {
                Integer t = pTimes.getOrDefault(arr[0], 0);
                pTimes.put(arr[0], t + 1);
                t = pTimes.getOrDefault(arr[1], 0);
                pTimes.put(arr[1], t + 1);
            });
            Integer sum = pTimes.values().stream().map(v -> v * (v - 1)).reduce(0, Integer::sum);
            return sum;
        }).reduce(Integer::sum);
        return reduce.orElse(0);
    }
    int cal(int x, int y){
        return x * x + y * y;
    }
}
class Main{
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = new int[][]{{0,0},{1,0},{2,0}};
        solution.numberOfBoomerangs(arr);
    }
}