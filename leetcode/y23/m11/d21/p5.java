package y23.m11.d21;

import java.util.*;

/**
 * 2940. 找到 Alice 和 Bob 可以相遇的建筑 显示英文描述
 * 通过的用户数378
 * 尝试过的用户数735
 * 用户总通过次数437
 * 用户总提交次数1682
 * 题目难度Hard
 * 给你一个下标从 0 开始的正整数数组 heights ，其中 heights[i] 表示第 i 栋建筑的高度。
 *
 * 如果一个人在建筑 i ，且存在 i < j 的建筑 j 满足 heights[i] < heights[j] ，那么这个人可以移动到建筑 j 。
 *
 * 给你另外一个数组 queries ，其中 queries[i] = [ai, bi] 。第 i 个查询中，Alice 在建筑 ai ，Bob 在建筑 bi 。
 *
 * 请你能返回一个数组 ans ，其中 ans[i] 是第 i 个查询中，Alice 和 Bob 可以相遇的 最左边的建筑 。如果对于查询 i ，Alice 和 Bob 不能相遇，令 ans[i] 为 -1 。
 *
 *
 */
class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int len = heights.length;
        int[][]t=new int[len][2];
        for (int i=0;i<len;++i){
            t[i][0]=heights[i];
            t[i][1]=i;
        }
        Map<Integer,List<int[]>> qMap = new HashMap<>();
        for (int i=0;i< queries.length;++i){
            int[]q=new int[3];
            q[0]=Math.max(queries[i][0],queries[i][1]);
            q[1]=Math.min(queries[i][0],queries[i][1]);
            q[2]=i;
            if (qMap.containsKey(q[0]))
                qMap.get(q[0]).add(q);
            else {
                List<int[]> list=new ArrayList<>();
                list.add(q);
                qMap.put(q[0],list);
            }
        }
        List<int[]> Q = new ArrayList<>();
        int[]res = new int[queries.length];
        for (int i=0;i<len;++i){
            if (qMap.containsKey(t[i][1])){
                Q.addAll(qMap.get(t[i][1]));
                qMap.remove(t[i][1]);
            }
            for (int j=0;j< Q.size();){
                int[]q = Q.get(j);
                if ((q[0]==q[1]||(heights[q[0]]<=t[i][0] && heights[q[1]]<t[i][0])) && i >= q[1]){
                    res[q[2]] = t[i][1];
                    Q.remove(j);
                }else
                    j++;
            }
        }
        for (int[]q:Q){
            res[q[2]]=-1;
        }
        return res;
    }

//    public static void main(String[] args) {
//        long s = 222;
//        long e=20231013;
//        int cnt = 0;
//        for (long i=s;i<=e;++i){
//            long m=i*i;
//            long x = gets(m);
//            long y = gets(i);
//            if (x == y*y)
//                cnt++;
//        }
//        System.out.println(cnt);
//    }
//    static long gets(long x){
//        int sum = 0;
//        while (x!=0){
//            sum+=x%10;
//            x/=10;
//        }
//        return sum;
//    }
}