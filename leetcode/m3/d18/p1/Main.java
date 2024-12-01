package y24.m3.d18.p1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static int[] countPerfectSquares(int[][] matrix) {
        int n = matrix.length;
        int[][] prefixSum0 = new int[n + 1][n + 1];
        int[][] prefixSum1 = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                prefixSum0[i][j] = prefixSum0[i - 1][j] + prefixSum0[i][j - 1] - prefixSum0[i - 1][j - 1] + (matrix[i - 1][j - 1] == 0 ? 1 : 0);
                prefixSum1[i][j] = prefixSum1[i - 1][j] + prefixSum1[i][j - 1] - prefixSum1[i - 1][j - 1] + (matrix[i - 1][j - 1] == 1 ? 1 : 0);
            }
        }
        int[] counts = new int[n + 1];
        for (int size = 1; size <= n; size++) {
            for (int i = size; i <= n; i++) {
                for (int j = size; j <= n; j++) {
                    int count0 = prefixSum0[i][j] - prefixSum0[i - size][j] - prefixSum0[i][j - size] + prefixSum0[i - size][j - size];
                    int count1 = prefixSum1[i][j] - prefixSum1[i - size][j] - prefixSum1[i][j - size] + prefixSum1[i - size][j - size];
                    if (count0 == count1) {
                        counts[size]++;
                    }
                }
            }
        }
        return counts;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int n = Integer.parseInt(reader.readLine());
        int[][] mat = new int[n][n];
        for (int i =0;i<n;++i){
            line = reader.readLine();
            int j = 0;
            for (char c : line.toCharArray()) {
                mat[i][j++] = Character.getNumericValue(c);
            }
        }
        int[]res = countPerfectSquares(mat);

        // res
        System.out.println(0);
        for (int i =2;i<=n;++i){
            System.out.println(res[i]);
        }
    }
}