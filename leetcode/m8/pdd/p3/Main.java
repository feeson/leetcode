package y24.m8.pdd.p3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            int len = Integer.parseInt(reader.readLine());
            run(len);
        }
    }

    static int[] nxt,to,weight,head;
    static int cnt = 0;
    static void init(int m, int n){
        nxt = new int[m + 1];
        to = new int[m + 1];
        weight = new int[m + 1];
        head = new int[n + 1];
        Arrays.fill(head, -1);
    }
    static void add(int f, int t, int w){
        to[cnt] = t;
        weight[cnt] = w;
        nxt[cnt] = head[f];
        head[cnt] = cnt++;
    }
    static void run(int len) throws IOException {
        String[] s1 = reader.readLine().split(" ");
        int[] vn = new int[len];
        for (int i = 0; i < len; i++) {
            vn[i] = Integer.parseInt(s1[i]);
        }
        init(len - 1, len);
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        long sum = 0;
        for (int i = 0; i < len - 1; i++) {
            String[] s = reader.readLine().split(" ");
            int f = Integer.parseInt(s[0]);
            int t = Integer.parseInt(s[1]);
            int w = Integer.parseInt(s[2]);
            sum += w;
            Integer val = treeMap.computeIfAbsent(w, k -> 0);
            treeMap.put(w, val + 1);
        }
        long max = sum + vn[0];
        int index = 1;
        while (!treeMap.isEmpty()){
            Map.Entry<Integer, Integer> entry = treeMap.firstEntry();
            Integer k = entry.getKey();
            Integer v = entry.getValue();
            long val = sum - k + vn[index++];
            sum -= k;
            if (val > max)
                max = val;
            if (v == 1)
                treeMap.remove(k);
            else
                treeMap.put(k, v - 1);
        }
        System.out.println(max);
    }
}
