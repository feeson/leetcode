package y24.m9.mayi.p2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    int n;
    int m;
    int[] head, nxt, to;
    int cnt = 0;
    int[] in;
    boolean[] ecolor;
    boolean[] ncolor;
    void add(int f, int t){
        in[t]++;
        to[cnt] = t;
        nxt[cnt] = head[f];
        head[f] = cnt++;
    }
    void run(int n, int m, Scanner scanner){
        head = new int[n];
        in = new int[n];
        Arrays.fill(head, -1);
        nxt = new int[2 * m];
        to = new int[2 * m];
        ncolor = new boolean[n];
        ecolor = new boolean[2 * m];
        for(int i = 0; i < m; ++i){
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;
            add(x, y);
            add(y, x);
        }
        // group
        List<List<Integer>> group = new ArrayList<>();
        boolean[] visit = new boolean[n];
        for(int i = 0; i < n; ++i){
            if(visit[i]){
                continue;
            }
            List<Integer> list = new ArrayList<>();
            Deque<Integer> queue = new ArrayDeque<>();
            queue.add(i);
            while(!queue.isEmpty()){
                int poll = queue.pollFirst();
                if(visit[poll]){
                    continue;
                }
                list.add(poll);
                visit[poll] = true;
                for(int e = head[poll]; e != -1; e = nxt[e]){
                    int t = to[e];
                    if(!visit[t]){
                        queue.addLast(t);
                    }
                }
            }
            group.add(list);
        }
        int[][] res = new int[group.size()][2];
        for(int j = 0; j < 2; ++j){
            for(int i = 0; i < group.size(); ++i){
                res[i][j] = cal(group.get(i), j);
            }
            Arrays.fill(ecolor, false);
            Arrays.fill(ncolor, false);
        }
        int ret = 0;
        for(int i = 0; i < group.size(); ++i){
            if(res[i][0] == -1 && res[i][1] == -1){
                System.out.println(-1);
                return;
            }else if(res[i][0] == -1){
                ret += res[i][1];
            }else if(res[i][1] == -1){
                ret += res[i][0];
            }else{
                ret += Math.min(res[i][0], res[i][1]);
            }
        }
        System.out.println(ret);
    }
    int cal(List<Integer> list, int i){
        if(list. size() == 1){
            return 1;
        }
        int[] chose = new int[2];
        chose[0] = list.get(0);
        chose[1] = to[head[chose[0]]];
        Integer min = null;
        int cs = chose[i];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(cs);
        int draw = 0;
        while(!queue.isEmpty()){
            int poll = queue.pollFirst();
            if(!ncolor[poll]){
                ncolor[poll] = true;
                draw++;
                for(int e = head[poll]; e != -1; e = nxt[e]){
                    int t = to[e];
                    if(!ecolor[e]){
                        ecolor[e] = true;
                        int revere = (e / 2) << 1;
                        if (e == revere)
                            revere++;
                        ecolor[revere] = true;
                    }
                    if (!ncolor[t]){
                        ncolor[t] = true;
                        queue.addLast(t);
                    }
                }
            }else{
                for(int e = head[poll]; e != -1; e = nxt[e]){
                    int t = to[e];
                    if(!ncolor[t]){
                        queue.addLast(t);
                    }
                }
            }
        }
        for(int index: list){
            for(int e = head[index]; e != -1; e = nxt[e]){
                if(!ecolor[e])
                    return -1;
            }
        }
        return draw;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Main main = new Main();
        main.run(n, m, in);
    }
}