package y23.m5.d3;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 在一个无限的 x 坐标轴上，有许多水果分布在其中某些位置。给你一个二维整数数组 fruits ，其中 fruits[i] = [positioni, amounti] 表示共有 amounti 个水果放置在 positioni 上。fruits 已经按 positioni 升序排列 ，每个 positioni 互不相同 。
 *
 * 另给你两个整数 startPos 和 k 。最初，你位于 startPos 。从任何位置，你可以选择 向左或者向右 走。在 x 轴上每移动 一个单位 ，就记作 一步 。你总共可以走 最多 k 步。你每达到一个位置，都会摘掉全部的水果，水果也将从该位置消失（不会再生）。
 *
 * 返回你可以摘到水果的 最大总数 。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-fruits-harvested-after-at-most-k-steps
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        TreeMap<Integer,Integer> treeMap=new TreeMap<>();
        treeMap.put(0,0);
        int n=fruits.length;
        int t=0;
        int o=startPos-k;
        for (int i=0;i<n;++i){
            if (fruits[i][0]>startPos+k)
                break;
            if (fruits[i][0]>=o){
                t+=fruits[i][1];
                treeMap.put(fruits[i][0],t);
            }
        }
        int res=0;
        int lmax=treeMap.floorEntry(startPos).getValue();
        int rmax=treeMap.floorEntry(startPos+k).getValue()-treeMap.floorEntry(startPos).getValue();
        for (Map.Entry entry:treeMap.entrySet()){
            int key= (int) entry.getKey();
            int val= (int) entry.getValue();
            t=startPos-key;
            if (t>0){
                o=k-2*t+startPos;
                if (treeMap.lowerEntry(key)==null){
                    res=Integer.max(res,treeMap.floorEntry(o).getValue());
                }else {
                    res=Integer.max(res,treeMap.floorEntry(o).getValue()-treeMap.lowerEntry(key).getValue());
                }
            }else if (t<0){
                o=startPos-(k+2*t);
                if (treeMap.lowerEntry(o)==null){
                    res=Integer.max(res,val);
                }else {
                    res=Integer.max(res,val - treeMap.lowerEntry(o).getValue());
                }

            }else {
                res=Integer.max(res,val);
            }
        };
        return res;
    }
}