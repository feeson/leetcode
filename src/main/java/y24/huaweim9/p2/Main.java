package y24.huaweim9.p2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int[][] gifts = new int[len][3];
        boolean[][][] visit = new boolean[11][11][11];
        List<int[]> nodes = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 3; j++) {
                gifts[i][j] = in.nextInt();
            }
            if (!visit[gifts[i][0]][gifts[i][1]][gifts[i][2]]){
                nodes.add(new int[]{gifts[i][0], gifts[i][1], gifts[i][2]});
                visit[gifts[i][0]][gifts[i][1]][gifts[i][2]] = true;
            }
        }
        Map<int[], Integer> cache = new HashMap<>();
        int res = 0;
        for (int[] node : nodes) {
            int max = dfs(node, cache, nodes);
            res = Math.max(res, max);
        }
        System.out.println(res);
    }
    static int dfs(int[] node, Map<int[], Integer> cache, List<int[]> nodes){
        if (cache.containsKey(node)){
            return cache.get(node);
        }
        int max = 0;
        for (int[] nd : nodes) {
            if (nd[0] < node[0] && nd[1] < node[1] && nd[2] < node[2]){
                max = Math.max(max, node[2] + dfs(nd, cache ,nodes));
            }
        }
        if (max == 0){
            max = node[2];
        }
        cache.put(node, max);
        return max;
    }
}
