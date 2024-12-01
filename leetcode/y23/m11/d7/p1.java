package y23.m11.d7;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solutionp1 {
    int[]heads;
    int[]next;
    int[]to;
    int[]values;
    int cnt = 0;
    int m;
    void add(int i,int j){
        to[cnt] = j;
        next[cnt] = heads[i];
        heads[i] = cnt++;
    }
    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        this.values=values;
        int n = values.length;
        m = edges.length*2;
        heads = new int[n];
        Arrays.fill(heads, -1);
        next = new int[m];
        to = new int[m];
        for(int[] edge : edges){
            int f =edge[0];
            int t = edge[1];
            add(f,t);
            add(t,f);
        }
        return dfs(0, -1)[0];
    }
    long[] dfs(int f,int from){// 0: 合法条件下最大值 1: 全取出的值
        long[]res=new long[2];
        boolean flag =true;
        for (int e = heads[f];e != -1;e = next[e]){
            if (to[e]==from)
                continue;
            flag=false;
            long[] dfs = dfs(to[e],f);
            res[0]+=dfs[0];
            res[1]+=dfs[1];
        }
        if (flag)
            res[0] = 0;
        else
            res[0]=Math.max(res[1],res[0]+values[f]);
        res[1]=res[1]+values[f];
        return res;
    }

//    public static void main(String[] args) {
//        Solution solution=new Solution();
//        int[][]arr=new int[][] {{2,0},{4,1},{5,3},{4,6},{2,4},{5,2},{5,7}};
//        int[]arr1=new int[] {12,12,7,9,2,11,12,25};
//        long l = solution.maximumScoreAfterOperations(arr, arr1);
//        System.out.println(l);
//    }
}