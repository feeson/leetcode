package jiqiao.targin_cutpoint;

import java.util.Arrays;

/*
924. 尽量减少恶意软件的传播
给出了一个由 n 个节点组成的网络，用 n × n 个邻接矩阵图graph表示。在节点网络中，当 graph[i][j] = 1时，表示节点i能够直接连接到另一个节点 j。

一些节点initial最初被恶意软件感染。只要两个节点直接连接，且其中至少一个节点受到恶意软件的感染，那么两个节点都将被恶意软件感染。这种恶意软件的传播将继续，直到没有更多的节点可以被这种方式感染。

假设 M(initial) 是在恶意软件停止传播之后，整个网络中感染恶意软件的最终节点数。

如果从initial中移除某一节点能够最小化 M(initial)， 返回该节点。如果有多个节点满足条件，就返回索引最小的节点。

请注意，如果某个节点已从受感染节点的列表 initial 中删除，它以后仍有可能因恶意软件传播而受到感染。






示例 1：

输入：graph = [[1,1,0],[1,1,0],[0,0,1]], initial = [0,1]
输出：0


示例 2：

输入：graph = [[1,0,0],[0,1,0],[0,0,1]], initial = [0,2]
输出：0


示例 3：

输入：graph = [[1,1,1],[1,1,1],[1,1,1]], initial = [1,2]
输出：1




提示：



	n == graph.length
	n == graph[i].length
	2 <= n <= 300
	graph[i][j]==0或1.
	graph[i][j] == graph[j][i]
	graph[i][i] == 1
	1 <= initial.length <= n
	0 <= initial[i] <= n - 1
	initial中所有整数均不重复


*/
/*
href: https://leetcode.cn/problems/minimize-malware-spread/?envType=daily-question&envId=2024-09-09
time: Mon Sep 09 2024 21:09:58 GMT+0800 (中国标准时间)
*/
//
// 割点判定: dfn[x] <= low[y] 细节：判定时要考虑是不是根节点，根节点至少两个子节点是割点本身才是割点
// 桥判定: dfn[x] < low[y] 细节：传入边编号，更新时不能回去更新
// doc: https://www.cnblogs.com/gzh-red/p/11253230.html
//
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
