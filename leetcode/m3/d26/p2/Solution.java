package y24.m3.d26.p2;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int trapRainWater(int[][] heightMap) {
        int n = heightMap.length;
        int m = heightMap[0].length;
        boolean[][] visit = new boolean[n][m];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[2]));
        for (int i = 0;i < n; i++){
            for (int j = 0;j < m;j++){
                if (i ==0 || i == n-1 || j == 0|| j== m - 1){
                    visit[i][j] = true;
                    pq.add(new int[]{i,j,heightMap[i][j]});
                }
            }
        }
        int[] vic = new int[]{-1,0,1,0,-1};
        int sum = 0;
        while (!pq.isEmpty()){
            int[] poll = pq.poll();
            for (int k = 0; k <4;++k){
                int nx = poll[0] + vic[k],ny = poll[1] + vic[k + 1];
                if (nx > 0&&nx < n-1 && ny> 0&&ny < m - 1){
                    if (!visit[nx][ny]){
                        visit[nx][ny] = true;
                        if (heightMap[nx][ny] < poll[2]){
                            sum+=poll[2] - heightMap[nx][ny];
                            pq.add(new int[]{nx,ny,poll[2]});
                        }else {
                            pq.add(new int[]{nx,ny,heightMap[nx][ny]});
                        }
                    }
                }
            }
        }
        return sum;
    }
}
class Main{
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}};
        Solution solution = new Solution();
        solution.trapRainWater(arr);
    }
}