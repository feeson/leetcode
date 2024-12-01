package y23.m8.d25;

import java.util.*;

/**
 * 给你一个整数数组 cost 和一个整数 target 。请你返回满足如下规则可以得到的 最大 整数：
 *
 * 给当前结果添加一个数位（i + 1）的成本为 cost[i] （cost 数组下标从 0 开始）。
 * 总成本必须恰好等于 target 。
 * 添加的数位中没有数字 0 。
 * 由于答案可能会很大，请你以字符串形式返回。
 *
 * 如果按照上述要求无法得到任何整数，请你返回 "0" 。
 *
 * https://leetcode.cn/problems/form-largest-integer-with-digits-that-add-up-to-target/
 */
class Solutionp2 {
    Map<Integer,Integer> costMap =new HashMap<>();
    int minCost=Integer.MAX_VALUE;
    Map<Integer,String> targetMap=new HashMap<>();
    int[] cost;
    public String largestNumber(int[] cost, int target) {
        this.cost=cost;
        for (int i=0;i<cost.length;++i){
            minCost=Math.min(minCost,cost[i]);
            costMap.put(cost[i], i);
        }
        String res="0";
        for (int i=0;i<9;++i){
            String dfs = dfs(target-cost[i]);
            if (!dfs.equals("0")&&!dfs.contains("-")){
                for (int j=0;j<dfs.length();++j){
                    if (dfs.charAt(j)<'0'+(j+1)){
                        dfs=dfs.substring(0,j)+(i+1)+dfs.substring(j);
                        break;
                    }
                    if (j==dfs.length()-1){
                        dfs+=(i+1);
                        break;
                    }
                }
                if (res.length()==dfs.length()){
                    for (int j=0;j<res.length();++j){
                        if (dfs.charAt(j)>res.charAt(j)){
                            res=dfs;
                            break;
                        }else if (dfs.charAt(j)<res.charAt(j)){
                            break;
                        }
                    }
                }else {
                    if (res.length()<dfs.length()){
                        res=dfs;
                    }
                }
            }
        }
        return res;
    }
    //dfs(i,target) 选取一个下标i进行破开
    //res= for i in 9 max(dfs(i,target))
    //边界 无法破开/target=0
    String dfs(int target){
        if (target==0)
            return "0";
        if (target<minCost||target<0)
            return "-";
        if (targetMap.containsKey(target))
            return targetMap.get(target);
        String max="0";
        for (int i=0;i<9;++i){
            String dfs = dfs( target - cost[i]);
            if (dfs.contains("-"))
                continue;
            if (dfs.equals("0")){
                dfs=dfs.replaceAll("0",(i+1)+"");
            }else {
                for (int j=0;j<dfs.length();++j){
                    if (dfs.charAt(j)<'0'+(j+1)){
                        dfs=dfs.substring(0,j)+(i+1)+dfs.substring(j);
                        break;
                    }
                    if (j==dfs.length()-1){
                        dfs+=(i+1);
                        break;
                    }
                }
            }
            if (dfs.length()>max.length()){
                max=dfs;
            }else if (dfs.length()==max.length()){
                for (int j=0;j<dfs.length();++j){
                    if (dfs.charAt(j)>max.charAt(j)){
                        max=dfs;
                        break;
                    }else if (dfs.charAt(j)<max.charAt(j))
                        break;
                }
            }
        }
        if (max.equals("0")){
            targetMap.put(target,"-");
            return "-";
        }else {
            targetMap.put(target,max);
            return max;
        }
    }
}