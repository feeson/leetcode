package jiqiao.JumpLca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    // 倍增LCA
    static int[] head,nxt,to;
    static int cnt = 0;
    static void init(int n,int m){
        n+=1;
        head = new int[n];
        Arrays.fill(head,-1);
        m*=2;
        nxt = new int[m];
        to = new int[m];
    }
    static void add(int f,int t){
        to[cnt] = t;
        nxt[cnt] = head[f];
        head[f] = cnt++;
    }
    static int n;
    static int[][] pa;
    static int[] lg;
    static int[] depth;
    static void buildTree(){
        pa = new int[n + 1][31];
        depth = new int[n + 1];
        lg = new int[n + 1];
        for (int i = 1; i < (n + 1);++i){
            lg[i] = lg[i - 1] +((1<<lg[i - 1]) == i?1:0);
        }
        for (int e = head[root];e != -1; e = nxt[e]){
            dfs(to[e],root);
        }
    }
    static void dfs(int node,int parent){
        pa[node][0] = parent;
        depth[node] = depth[parent] + 1;
        for (int i = 1; i <= (lg[depth[node]] - 1);++i){
            pa[node][i] = pa[pa[node][i - 1]][i - 1];
        }
        for (int e = head[node];e != -1;e = nxt[e]){
            if (to[e] != parent)
                dfs(to[e],node);
        }
    }
    static int lca(int a,int b){
        if (depth[a] < depth[b]){
            a = a^b;
            b = a^b;
            a = a^b;
        }
        while (depth[a] > depth[b]){
            a = pa[a][lg[depth[a] - depth[b]]-1];
        }
        if (a == b)
            return a;
        for (int k = lg[depth[a]]-1;k >=0;k--){
            if (pa[a][k] != pa[b][k]){
                a = pa[a][k];
                b = pa[b][k];
            }
        }
        return pa[a][0];
    }
    static int root;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] line0 = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = line0[0];
        int e = n - 1;
        int q = line0[1];
        root = line0[2];
        init(n,e);
        for (int i = 0;i < n - 1;++i){
            int[] line = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            add(line[0],line[1]);
            add(line[1],line[0]);
        }
        // build
        buildTree();
        String str;
        for (int i = 0;i < q;++i){
            int[] line = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int lca = lca(line[0], line[1]);
            System.out.println(lca);
        }
    }
}
