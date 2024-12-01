package y24.M10.d31;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new int[n], new boolean[n], 0,nums);
        return result;
    }
    void dfs(List<List<Integer>> result, int[] selected, boolean[] used, int k, int[] nums){
        for(int i = 0;i < nums.length; ++i){
            if(!used[i]){
                used[i] = true;
                selected[k] = nums[i];
                if(k == nums.length - 1){
                    List<Integer> res = new ArrayList<>();
                    for(int j = 0;j <= k; ++j){
                        res.add(selected[j]);
                    }
                    result.add(res);
                }else{
                    dfs(result, selected, used,k + 1, nums);
                }
                used[i] = false;
            }
        }
    }
}