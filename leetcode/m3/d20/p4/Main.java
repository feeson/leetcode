package y24.m3.d20.p4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    static List<List<Integer>>[] from;
    static int edgeLen = 0;
    static int maxCost = 0;
    static void add(int f,int t,int val){
        if(from[f] == null){
            from[f] = new ArrayList<List<Integer>>();
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(t);
        list.add(val);
        from[f].add(list);
        edgeLen++;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt() + 1;
        from = new List[len];
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int from = in.nextInt();
            int to = in.nextInt();
            int cost = in.nextInt();
            add(from,to,cost);
        }
        costs = new int[len];
        int sumCosts = 0;
        for(List<Integer> val:from[1]){
            int t = val.get(0);
            int cost = val.get(1);
//            sumCosts += dfs(1,t,cost);
            sumCosts += 2 * cost;
        }
        int r1 = 0;
        int maxDep = 0;
        for(int val : costs){
            r1 += val;
            maxDep = Math.max(maxDep,val);
        }
        System.out.println(r1 +" "+(sumCosts - maxDep));
    }
    static int[] costs;
    static int dfs(int n,int c){
        if(from[n] == null){
            costs[n] = c;
            return 0;
        }
        int sumCost = c;
        for(List<Integer> val:from[n]){
            int t = val.get(0);
            int cost = val.get(1);
//            sumCost += dfs(n,t,cost + c);
            sumCost += 2 * cost;
        }
        return sumCost;
    }
}