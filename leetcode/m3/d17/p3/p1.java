package y24.m3.d17.p3;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

/*
77. 组合
给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。

你可以按 任何顺序 返回答案。



示例 1：

输入：n = 4, k = 2
输出：
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

示例 2：

输入：n = 1, k = 1
输出：[[1]]



提示：


	1 <= n <= 20
	1 <= k <= n


*/
/*
href: https://leetcode.cn/problems/combinations/description/?envType=study-plan-v2&envId=top-interview-150
*/
class Solution {
    List<List<Integer>> res;
    int times=0;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        dfs(new int[k],0,1,n,k);
//        res.add(List.of(times));
        return res;
    }
    void dfs(int[] work,int idx,int num,int n,int k){
        if (idx == k){
            res.add(Arrays.stream(work).boxed().collect(Collectors.toList()));
            res.clear();
            times ++;
            return;
        }
        if (n - num < k)
            return;
        for (int i = num;i <= n;++i){
            work[idx] = i;
            dfs(work,idx+1,i + 1,n,k);
        }
    }
}
class Solution2 {
    List<List<Integer>> res;
    int times = 0;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        dfs(new int[k],0,1,n,k);
//        res.add(List.of(times));
        return res;
    }
    void dfs(int[] work,int idx,int num,int n,int k){
        if (idx == k){
//            var r = new ArrayList<Integer>(k + 1);
//            for (int i = 0;i< idx;++i){
//                r.add(work[i]);
//            }
//            res.add(r);
            res.clear();
            times++;
            return;
        }
        if (k - idx >0)
            return;
        for (int i = num;i <= n;++i){
            work[idx] = i;
            dfs(work,idx+1,i + 1,n,k);
        }
    }
}
class Main{
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        Long now = Instant.now().toEpochMilli();
        List<List<Integer>> combine = solution.combine(1020, 1000);
        System.out.println("times:"+combine);
        System.out.println(Instant.now().toEpochMilli() - now);
        now = Instant.now().toEpochMilli();
        combine = solution2.combine(1020,1000);
        System.out.println("times:"+combine);
        System.out.println(Instant.now().toEpochMilli() - now);
    }
}