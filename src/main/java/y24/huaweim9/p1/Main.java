package y24.huaweim9.p1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        // please finish the function body here.
        // please define the JAVA output here. For example: System.out.println(s.nextInt());
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[][] mat = new int[m][n];
        List<int[]> induses = new ArrayList<>();
        LinkedList<int[]> garbages = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = in.nextInt();
                if (mat[i][j] == 0)
                    garbages.add(new int[]{i,j});
                if (mat[i][j] == 1)
                    induses.add(new int[]{i, j});
            }
        }
        if (induses.isEmpty() || garbages.isEmpty()){
            System.out.println(0);
            return;
        }
        int[][] minCost = new int[m][n];
        int[][] avi = new int[4][2];
        while (!garbages.isEmpty()){
            int[] grabage = garbages.pollFirst();
            boolean[][] visit = new boolean[m][n];
            LinkedList<int[]> nxt = new LinkedList<>();
            int step = 1;
            nxt.add(grabage);
            visit[grabage[0]][grabage[1]] = true;
            while (!nxt.isEmpty()){
                int sz = nxt.size();
                for (int i = 0; i < sz; ++i){
                    int[] first = nxt.pollFirst();
                    int pi = first[0];
                    int pj = first[1];
                    int size = aviPos(visit, avi, mat, m, n, pi, pj);
                    for (int j = 0; j < size; j++) {
                        int ni = avi[j][0];
                        int nj = avi[j][1];
                        visit[ni][nj] = true;
                        nxt.addLast(new int[]{ni, nj});
                        if (mat[ni][nj] == 1){
                            if (minCost[ni][nj] == 0)
                                minCost[ni][nj] = step;
                            else
                                minCost[ni][nj] = Math.min(minCost[ni][nj], step);
                        }
                    }
                }
                step++;
            }
        }
        int res = 0;
        for (int[] arr : induses) {
            res+=minCost[arr[0]][arr[1]];
        }
        System.out.println(res);
    }
    static int[] vec = new int[]{-1, 0, 1, 0, -1};
    static int aviPos(boolean[][] visit, int[][] res, int[][] mat, int m, int n, int i, int j){
        int pos = 0;
        for (int k = 0; k < 4; k++) {
            int ni = i + vec[k];
            int nj = j + vec[k + 1];
            if (ni >= 0 && ni < m && nj >= 0 && nj < n && mat[ni][nj] != - 1 && !visit[ni][nj]){
                res[pos][0] = ni;
                res[pos][1] = nj;
                pos++;
            }
        }
        return pos;
    }
}
