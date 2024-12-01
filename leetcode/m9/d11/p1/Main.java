package y24.m9.d11.p1;

import java.util.*;

public class Main {
    static void cutPoint(){
        for (int i = 0; i < head.length; i++) {
            root = i;
            if (dfn[i] == 0)
                targin(i);
        }
        int cnt = 0;
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 0; i < cut.length; i++) {
            if (cut[i]){
                cnt++;
                sj.add(String.valueOf(i + 1));
            }
        }
        System.out.println(cnt);
        System.out.println(sj);
    }
    static int[] dfn,low;
    static int time;
    static boolean[] cut;
    static void targin(int x){
        dfn[x] = low[x] = ++time;
        int skip = 0;
        for (int e = head[x]; e != -1; e = nxt[e]){
            int t = to[e];
            if (dfn[t] == 0){
                targin(t);
                low[x] = Math.min(low[x], low[t]);
                if (dfn[x] <= low[t]){
                    if (x != root){
                        cut[x] = true;
                    }else {
                        skip++;
                    }
                }
            }else {
                low[x] = Math.min(low[x], dfn[t]);
            }
        }
        if (x == root && skip >= 2)
            cut[x] = true;
    }
    static int root;
    static int[] head,nxt,to;
    static int cnt = 0;
    static void add(int f, int t){
        to[cnt] = t;
        nxt[cnt] = head[f];
        head[f] = cnt++;
    }
    static void init(int n, int m){
        head = new int[n];
        to = new int[m * 2];
        nxt = new int[m * 2];
        cut = new boolean[n];
        Arrays.fill(head, -1);
        dfn = new int[n];
        low = new int[n];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        init(n, m);
        for (int i = 0; i < m; i++) {
            int f = scanner.nextInt() - 1;
            int t = scanner.nextInt() - 1;
            add(f, t);
            add(t, f);
        }
        cutPoint();
    }
}
