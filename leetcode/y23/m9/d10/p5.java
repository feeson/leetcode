package y23.m9.d10;

import java.util.*;

/**
 给定一个候选人编号的集合candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。

 candidates中的每个数字在每个组合中只能使用一次。

 注意：解集不能包含重复的组合。



 示例1:

 输入: candidates =[10,1,2,7,6,1,5], target =8,
 输出:
 [
 [1,1,6],
 [1,2,5],
 [1,7],
 [2,6]
 ]

 示例2:

 输入: candidates =[2,5,2,1,2], target =5,
 输出:
 [
 [1,2,2],
 [5]
 ]



 提示:


 1 <=candidates.length <= 100
 1 <=candidates[i] <= 50
 1 <= target <= 30


 */
/*
https://leetcode.cn/problems/combination-sum-ii/
*/
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        int len=candidates.length;
        Deque<Integer> deque=new ArrayDeque<>();
        Arrays.sort(candidates);
        dfs(res,0,target,len,candidates,deque);
        return res;

    }
    void dfs(List<List<Integer>> res,int from,int target,int len,int[] candidates,Deque<Integer> path){
        if (target<0){
            return;
        }
        if (target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        if (from!=0&&candidates[from-1]==candidates[from]){
            while (candidates[++from]==candidates[from-1]);
        }
        for (int i=from;i<len;++i){
            path.addLast(candidates[i]);
            dfs(res,i+1,target-candidates[i],len,candidates,path);
            path.pollLast();
        }
    }
}