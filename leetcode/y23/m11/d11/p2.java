package y23.m11.d11;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 给定一个 正整数数组beans，其中每个整数表示一个袋子里装的魔法豆的数目。

 请你从每个袋子中拿出一些豆子（也可以不拿出），使得剩下的 非空 袋子中（即 至少还有一颗魔法豆的袋子）魔法豆的数目相等。一旦把魔法豆从袋子中取出，你不能再将它放到任何袋子中。

 请返回你需要拿出魔法豆的 最少数目。



 示例 1：

 输入：beans = [4,1,6,5]
 输出：4
 解释：
 - 我们从有 1 个魔法豆的袋子中拿出 1 颗魔法豆。
 剩下袋子中魔法豆的数目为：[4,0,6,5]
 - 然后我们从有 6 个魔法豆的袋子中拿出 2 个魔法豆。
 剩下袋子中魔法豆的数目为：[4,0,4,5]
 - 然后我们从有 5 个魔法豆的袋子中拿出 1 个魔法豆。
 剩下袋子中魔法豆的数目为：[4,0,4,4]
 总共拿出了 1 + 2 + 1 = 4 个魔法豆，剩下非空袋子中魔法豆的数目相等。
 没有比取出 4 个魔法豆更少的方案。


 示例 2：

 输入：beans = [2,10,3,2]
 输出：7
 解释：
 - 我们从有 2 个魔法豆的其中一个袋子中拿出 2 个魔法豆。
 剩下袋子中魔法豆的数目为：[0,10,3,2]
 - 然后我们从另一个有 2 个魔法豆的袋子中拿出 2 个魔法豆。
 剩下袋子中魔法豆的数目为：[0,10,3,0]
 - 然后我们从有 3 个魔法豆的袋子中拿出 3 个魔法豆。
 剩下袋子中魔法豆的数目为：[0,10,0,0]
 总共拿出了 2 + 2 + 3 = 7 个魔法豆，剩下非空袋子中魔法豆的数目相等。
 没有比取出 7 个魔法豆更少的方案。




 提示：


 1 <= beans.length <= 105
 1 <= beans[i] <= 105


 */
/*
https://leetcode.cn/problems/removing-minimum-number-of-magic-beans/
*/
class Solutionp2 {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        long left = 0;
        long right = 0;
        long sum = 0;
        for (int val:beans)
            sum+=val;
        int len = beans.length;
        long res = Long.MAX_VALUE;
        for (int i=0;i<len;++i){
            right = sum - left - (long) beans[i] *(len-i);
            res=Math.min(res,right+left);
            left+=beans[i];
        }
        return res;
    }
}