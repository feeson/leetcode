package y23.m9.d12;

import java.util.HashSet;
import java.util.Set;

/**
 给定正整数 k，你需要找出可以被 k整除的、仅包含数字 1 的最 小 正整数 n的长度。

 返回 n的长度。如果不存在这样的 n，就返回-1。

 注意： n 可能不符合 64 位带符号整数。



 示例 1：

 输入：k = 1
 输出：1
 解释：最小的答案是 n = 1，其长度为 1。

 示例 2：

 输入：k = 2
 输出：-1
 解释：不存在可被 2 整除的正整数 n 。

 示例 3：

 输入：k = 3
 输出：3
 解释：最小的答案是 n = 111，其长度为 3。



 提示：


 1 <= k <= 105


 */
/*
https://leetcode.cn/problems/smallest-integer-divisible-by-k/?envType=daily-question&envId=2023-09-12
*/
class Solutionp2 {
    public int smallestRepunitDivByK(int k) {
        if (k==2||k==5)
            return -1;
        int xn=1;
        Set<Integer> set=new HashSet<>();
        for (int i=1;i<10e5;++i){
            int xnmodk=xn%k;
            if (set.contains(xnmodk))
                return -1;
            else
                set.add(xnmodk);
            if (xnmodk==0)
                return i;
            else
                xn=(10*xn+1)%k;
        }
        return -1;
    }
}
