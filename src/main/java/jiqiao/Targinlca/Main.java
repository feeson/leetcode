package jiqiao.Targinlca;

public class Main {
    // 倍增LCA
    int[] nxt,head,to;
    int[][] pa;
    int[] lg;
    int[] depth;

    int root;
    void init(int n){
        lg = new int[n];
        pa = new int[n][31];
        depth = new int[n];
        for (int i = 1;i < n;++i){
            lg[i] = lg[i - 1] + (((1<<lg[i - 1]) == i)?1:0);
        }
        for (int e = head[root];e != -1;e = nxt[e]){
            dfs(to[e],root);
        }
    }
    void dfs(int node,int parent){
        pa[node][0] = parent;
        depth[node] = depth[parent] + 1;
        for (int i = 1;i <= (lg[depth[node]] - 1);i++){
            pa[node][i] = pa[pa[node][i-1]][i-1];
        }
        for (int e = head[node];e != -1;e = nxt[e]){
            if (to[e] != parent)
                dfs(to[e],node);
        }
    }
    int lca(int a,int b){
        if (depth[a] < depth[b]){
            a = a^b;
            b = a^b;
            a = a^b;
        }
        while (depth[a] > depth[b]){
            a = pa[a][lg[depth[a] - depth[b]] - 1];
        }
        if (a == b)
            return a;
        for (int k = lg[depth[a]] - 1;k>=0;k--){
            if (pa[a][k] != pa[b][k]){
                a = pa[a][k];
                b = pa[b][k];
            }
        }
        return pa[a][0];
    }
}
