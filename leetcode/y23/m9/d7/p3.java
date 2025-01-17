package y23.m9.d7;

import java.util.HashSet;
import java.util.Set;

/**
 给定一个长度为偶数的整数数组 arr，只有对 arr 进行重组后可以满足 “对于每个 0 <=i < len(arr) / 2，都有 arr[2 * i + 1] = 2 * arr[2 * i]”时，返回 true；否则，返回 false。



 示例 1：

 输入：arr = [3,1,3,6]
 输出：false


 示例 2：

 输入：arr = [2,1,2,6]
 输出：false


 示例 3：

 输入：arr = [4,-2,2,-4]
 输出：true
 解释：可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,-4]




 提示：


 0 <= arr.length <= 3 * 104
 arr.length 是偶数
 -105 <= arr[i] <= 105


 */
/*
https://leetcode.cn/problems/array-of-doubled-pairs/
*/
class Solutionp3 {
    Set<Integer> set=new HashSet<>();
    public boolean canReorderDoubled(int[] arr) {
        int min=Integer.MAX_VALUE;
        for (int val:arr){
            set.add(val);
            min=Math.min(min,Math.abs(val));
        }
        min=set.contains(min)?min:-min;
        for (int i=0;i<arr.length/2;++i) {
            if (!set.contains(min)) {
                return false;
            }
            min *= 2;

        }
        return true;

    }

}