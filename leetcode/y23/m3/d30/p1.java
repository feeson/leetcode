package y23.m3.d30;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给你 n 个二维平面上的点 points ，其中 points[i] = [xi, yi] ，请你返回两点之间内部不包含任何点的 最宽垂直区域 的宽度。
 *
 * 垂直区域 的定义是固定宽度，而 y 轴上无限延伸的一块区域（也就是高度为无穷大）。 最宽垂直区域 为宽度最大的一个垂直区域。
 *
 * 请注意，垂直区域 边上 的点 不在 区域内。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/widest-vertical-area-between-two-points-containing-no-points
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int[] sorted = Arrays.stream(points)
                .mapToInt((ints) -> {
                    return ints[0];
                })
                .parallel()
                .sorted()
                .toArray();
        int maxDelta=0;
        int pre=sorted[0];
        for (int i=1;i<sorted.length;++i){
            int tmp=sorted[i]-pre;
            if (tmp>maxDelta){
                maxDelta=tmp;
            }
            pre=sorted[i];
        }
        return maxDelta;
    }
}