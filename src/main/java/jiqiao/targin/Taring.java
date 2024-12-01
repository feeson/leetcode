package jiqiao.targin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Taring {
    // Targin Lca
    static int[] pa,head,nxt,to;
    static int cnt = 0;
    static void add(int f,int t){
        to[cnt] = t;
        nxt[cnt] = head[f];
        head[f] = cnt++;
    }
    static void init(int n){
        n+=1;
        int m = 2 *(n - 1);
        pa = new int[n];
        for (int i =0; i < n;++i){
            pa[i] = i;
        }
        head = new int[n];
        Arrays.fill(head,-1);
        visit = new boolean[n];
        nxt = new int[m];
        to = new int[m];
    }
    static Map<Integer, Map<Integer,List<int[]>>> query = new HashMap<>();
    static int find(int i){
        if (pa[i] == i)
            return i;
        return pa[i] = find(pa[i]);
    }
    static void union(int i,int j){
        int findI = find(i);
        int findJ = find(j);
        if (findI == findJ)
            return;
        pa[findJ] = findI;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] line0 = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = line0[0];
        int q = line0[1];
        int root = line0[2];
        init(n);
        for (int i = 0;i < n-1;++i){
            int[] line = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            add(line[0],line[1]);
            add(line[1],line[0]);
        }
        List<int[]> queries = new ArrayList<>();
        for (int i = 0;i < q;++i){
            int[] line = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] arr = new int[]{i,-1};
            queries.add(arr);
            Map<Integer,List<int[]>> inner = query.getOrDefault(line[0], new HashMap<>());
            query.put(line[0],inner);
            List<int[]> list = inner.getOrDefault(line[1], new ArrayList<>());
            inner.put(line[1],list);
            list.add(arr);
            inner = query.getOrDefault(line[1],new HashMap<>());
            query.put(line[1],inner);
            list = inner.getOrDefault(line[0],new ArrayList<>());
            inner.put(line[0],list);
            list.add(arr);
        }
        dfs(root,0);
        for (int[] arr:queries){
            System.out.println(arr[1]);
        }
    }
    static boolean[] visit;
    static void dfs(int root,int parent){
        visit[root] = true;
        for (int e = head[root];e != -1;e = nxt[e]){
            if (to[e] != parent){
                dfs(to[e],root);
                union(root,to[e]);
            }
        }
        Map<Integer, List<int[]>> inner = query.getOrDefault(root, null);
        if (inner != null){
            for (Map.Entry<Integer,List<int[]>> entry:inner.entrySet()){
                int val = entry.getKey();
                if (visit[val]){
                    int pa = find(val);
                    for (int[] arr: entry.getValue()){
                        if (arr[1] == -1) arr[1] = pa;
                    }
                }
            }
        }
    }
}
