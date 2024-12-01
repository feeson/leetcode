package y24.huawei.p2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringJoiner;

public class Main {
    static int[] pa;
    static int[] total;
    static void union(int i, int j){
        int findi = find(i);
        int findj = find(j);
        if (findi == findj)
            return;
        pa[findj] = findi;
        int val = total[findj];
        total[findj] = 0;
        total[findi] += val;
    }
    static int find(int i){
        if (pa[i] == -1)
            return i;
        int val = total[i];
        total[i] = 0;
        pa[i] = find(pa[i]);
        total[pa[i]] += val;
        return pa[i];
    }
    public static void main(String[] args) throws IOException {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        // please finish the function body here.
        // please define the JAVA output here. For example: System.out.println(s.nextInt());
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] matrix = new int[n][n];
        int len = n;
        pa = new int[len];
        total = new int[len];
        Arrays.fill(pa, -1);
        while (n > 0){
            int x = len - n;
            String[] split = reader.readLine().split(" ");
            int idx = 0;
            for (String str:split){
                if (str.isEmpty())
                    continue;
                matrix[x][idx++] = Integer.parseInt(str);
            }
            n--;
        }
        for (int x = 0;x < len; ++x){
            for (int y = x + 1;y < len; ++y){
                if (matrix[x][y] > 0){
                    total[y] = matrix[x][y];
                    union(x, y);
                }
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0;i < len; ++i){
            find(i);
        }
        for (int i = 0;i < len; ++i){
            int findi = find(i);
            if (findi == i){
                res.add(total[i]);
            }
        }
        res.sort(Comparator.reverseOrder());
        StringJoiner joiner = new StringJoiner(" ");
        for (int val:res){
            joiner.add(Integer.toString(val));
        }
        System.out.println(joiner);
    }
}
