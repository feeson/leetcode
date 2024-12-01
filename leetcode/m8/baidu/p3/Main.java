package y24.m8.baidu.p3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    int[] head,to,nxt;
    boolean[] visit;
    boolean[] know;
    int cnt = 0;
    boolean[] mark;
    void add(int f, int t){
        to[cnt] = t;
        nxt[cnt] = head[f];
        head[f] = cnt++;
    }
    void init(int n, int m){
        head = new int[n + 2];
        to = new int[2 * (m + 1)];
        nxt = new int[2 * (m + 1)];
        Arrays.fill(head, -1);
        visit = new boolean[n + 2];
        know = new boolean[n + 2];
    }
    int dfs(int h, Set<Integer> set, Map<Integer, Integer> cache){
        int res = 0;
        if (!visit[h]){
            visit[h] = true;
            know[h] = true;
            res += 1;
            if (mark[h]){
                if (!cache.containsKey(h))
                    set.add(h);
                // share
                for (int e = head[h]; e != -1 ; e=nxt[e]) {
                    int t = to[e];
                    if (!visit[t] && !know[t]){
                        res += dfs(t, set, cache);
                    }
                }
            }
        }
        return res;
    }
    void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = reader.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int m = Integer.parseInt(line1[1]);
        int q = Integer.parseInt(line1[2]);
        init(n, m);
        for (int i = 0; i < m; i++) {
            String[] s = reader.readLine().split(" ");
            int f1 = Integer.parseInt(s[0]);
            int f2 = Integer.parseInt(s[1]);
            add(f1, f2);
            add(f2, f1);
        }
        mark = new boolean[n + 2];
        String[] markLink = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            mark[i + 1] = markLink[i].equals("1");
        }
        String[] heared = reader.readLine().split(" ");
        Map<Integer, Integer> cache = new HashMap<>();
        for (String s : heared) {
            int h = Integer.parseInt(s);
            if (cache.containsKey(h)){
                System.out.println(cache.get(h));
                continue;
            }
            Arrays.fill(visit, false);
            Arrays.fill(know, false);
            Set<Integer> set = new HashSet<>();
            int res = dfs(h, set, cache);
            for (Integer v : set) {
                cache.put(v, res);
            }
            System.out.println(res);
        }
    }
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.run();
    }
}
