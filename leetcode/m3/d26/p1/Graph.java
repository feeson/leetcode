package y24.m3.d26.p1;

import y22.m09.d27.p1.Solution;

import java.util.Arrays;

public class Graph {
    int[] head,nxt,to,cost;
    int cnt = 0;
    void add(int f,int t,int c){
        to[cnt] = t;
        nxt[cnt] = head[f];
        cost[cnt] = c;
        head[f] = cnt++;
    }
    int n;
    int[][] edges;
    int min(int i,int j){
        return Math.min(i, j);
    }
    public Graph(int n, int[][] edges) {
        this.n = n;
        this.edges = edges;
        int m = n*(n - 1) + 107;
        head = new int[n];
        Arrays.fill(head,-1);
        nxt = new int[m];
        to = new int[m];
        cost = new int[m];
        floyd = new int[n][n];
        for (int i = 0;i < n;++i){
            Arrays.fill(floyd[i],-1);
            floyd[i][i] = 0;
        }
        for (int[]edge:edges){
            add(edge[0],edge[1],edge[2]);
            if (floyd[edge[0]][edge[1]] == -1)
                floyd[edge[0]][edge[1]] = edge[2];
            else
                floyd[edge[0]][edge[1]] = min(floyd[edge[0]][edge[1]],edge[2]);
        }
        for (int t = 0;t < n; ++t){
            for (int i = 0; i < n;++i){
                for (int j = 0;j < n;++j){
                    if (i == j)
                        continue;
                    if (floyd[i][t] != -1 && floyd[t][j] != -1){
                        if (floyd[i][j] == -1)
                            floyd[i][j] = floyd[i][t] + floyd[t][j];
                        else
                            floyd[i][j] = min(floyd[i][j],floyd[i][t] + floyd[t][j]);
                    }
                }
            }
        }
    }
    int[][] floyd;
    public void addEdge(int[] edge) {
        add(edge[0],edge[1],edge[2]);
        if (floyd[edge[0]][edge[1]] == -1 || edge[2] < floyd[edge[0]][edge[1]]){
            floyd[edge[0]][edge[1]] = edge[2];
            // update
            for (int i = 0; i < n;++i){
                for (int j = 0;j < n;++j){
                    if (floyd[i][edge[0]] != -1 && floyd[edge[1]][j] != -1){
                        if (floyd[i][j] == -1)
                            floyd[i][j] = floyd[i][edge[0]] +floyd[edge[0]][edge[1]] +floyd[edge[1]][j];
                        else
                            floyd[i][j] = min(floyd[i][j],floyd[i][edge[0]] +floyd[edge[0]][edge[1]] +floyd[edge[1]][j]);
                    }
                }
            }
        }
    }

    public int shortestPath(int node1, int node2) {
        return floyd[node1][node2];
    }
}

class Main{
    public static void main(String[] args) {
        int[][]edges = new int[][]{{0,2,5},{0,1,2},{1,2,1},{3,0,3}};
        Graph graph = new Graph(4,edges);
        graph.shortestPath(3,2);
        graph.shortestPath(0,3);
        graph.addEdge(new int[]{1,3,4});
        graph.shortestPath(0,3);

    }
}