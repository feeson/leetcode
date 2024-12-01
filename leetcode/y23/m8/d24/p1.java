package y23.m8.d24;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 这里有一幅服务器分布图，服务器的位置标识在 m * n 的整数矩阵网格 grid 中，1 表示单元格上有服务器，0 表示没有。
 *
 * 如果两台服务器位于同一行或者同一列，我们就认为它们之间可以进行通信。
 *
 * 请你统计并返回能够与至少一台其他服务器进行通信的服务器的数量。
 *
 *  https://leetcode.cn/problems/count-servers-that-communicate/
 */
class Solution {
    public int countServers(int[][] grid) {
        int[] xcontain=new int[grid[0].length];
        int[] ycontain=new int[grid.length];
        int groupNums=0;
        ArrayList<Integer> group=new ArrayList<>();
        group.add(0);
        int height=grid.length;
        int width=grid[0].length;

        for (int i=0;i<height;++i){
            for (int j = 0; j < width;++j){
                if (grid[i][j]==0)
                    continue;
                if (xcontain[j]==0&&ycontain[i]==0){
                    groupNums++;
                    group.add(1);
                    xcontain[j]=groupNums;
                    ycontain[i]=groupNums;
                }else {
                    if (xcontain[j]==0&&ycontain[i]!=0){
                        int groupId=ycontain[i];
                        group.set(groupId,group.get(groupId)+1);
                        xcontain[j]=groupId;
                    }else if (xcontain[j]!=0&&ycontain[i]==0){
                        int groupId=xcontain[j];
                        group.set(groupId,group.get(groupId)+1);
                        ycontain[i]=groupId;
                    }else {
                        if (xcontain[j]!=ycontain[i]){
                            int tGroupId=xcontain[j];
                            for (int t=0;t<width;++t){
                                if (xcontain[t]==tGroupId)
                                    xcontain[t]=ycontain[i];
                            }
                            for (int t=0;t<i;++t){
                                if (ycontain[t]==tGroupId)
                                    ycontain[t]=ycontain[i];
                            }
                            int groupId=ycontain[i];
                            group.set(groupId,group.get(tGroupId)+group.get(groupId)+1);
                            group.set(tGroupId,0);
                        }else {
                            int groupId=ycontain[i];
                            group.set(groupId,group.get(groupId)+1);
                        }
                    }
                }
            }
        }
        int res = 0;
        for (int nums:group){
            if (nums>1)
                res+=nums;
        }
        return res;
    }
}