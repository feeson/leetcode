package y24.m3.d30.meituan.p5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static int[] head,nxt,to;
    static int cnt = 0;
    static void edge(int f,int t){
        to[cnt] = t;
        nxt[cnt] = head[f];
        head[f] = cnt++;
    }
    static int[] pa;
    static void add(int i,int j){
        int findi = find(i);
        int findj = find(j);
        if (findi == findj)
        pa[findj] = findi;
    }
    static int find(int x){
        if (pa[x] == -1)
            return x;
        return pa[x] = find(pa[x]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] line0 = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = line0[0];
        head = new int[n];
        pa = new int[n];
        Arrays.fill(head,-1);
        Arrays.fill(pa,-1);
        int m = line0[1];
        nxt = new int[m + 1];
        to = new int[m + 1];
        while (m > 0){
            int[] line = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            line[0]--;
            line[1]--;
            add(line[1],line[0]);
            edge(line[1],line[0]);
            m--;
        }
        int total = 0;
        int res = 0;
        List<Integer> list = new ArrayList<>();
        // 找根
        for (int i = 0;i < n;++i){
            if (find(i) == i){
                total+=1;
                int d = dfs(i);
                list.add(d);
            }
        }
        int t = 1;
        for (int val:list){
            t = (t * (val)%MOD)%MOD;
        }
        System.out.println(t + res);

    }
    static int MOD = 1_000_000_007;
    static int dfs(int i){
        int res = 0;
        for (int e = head[i];e != -1;e = nxt[e]){
            int t = to[e];
            int dfs = dfs(t);
            res += dfs;
            cnt++;
        }
        return res + 1;
    }
}
