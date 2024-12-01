package y23.m5.d2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定三个整数 x 、 y 和 bound ，返回 值小于或等于 bound 的所有 强整数 组成的列表 。
 *
 * 如果某一整数可以表示为 xi + yj ，其中整数 i >= 0 且 j >= 0，那么我们认为该整数是一个 强整数 。
 *
 * 你可以按 任何顺序 返回答案。在你的回答中，每个值 最多 出现一次。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/powerful-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();

        int m = x == 1 ? 0 : (int) (Math.log10(bound) / Math.log10(x));
        int n = y == 1 ? 0 : (int) (Math.log10(bound) / Math.log10(y));
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                int cur = (int) Math.pow(x, i) + (int) Math.pow(y, j);
                if (cur <= bound) {
                    set.add(cur);
                }
            }
        }

        return new ArrayList<>(set);
    }
}