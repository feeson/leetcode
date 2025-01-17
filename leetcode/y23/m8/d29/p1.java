package y23.m8.d29;

import java.math.BigInteger;
import java.util.*;

/**
 给出一个含有不重复整数元素的数组 arr ，每个整数 arr[i] 均大于 1。

 用这些整数来构建二叉树，每个整数可以使用任意次数。其中：每个非叶结点的值应等于它的两个子结点的值的乘积。

 满足条件的二叉树一共有多少个？答案可能很大，返回 对 109 + 7 取余 的结果。



 示例 1:

 输入: arr = [2, 4]
 输出: 3
 解释: 可以得到这些二叉树: [2], [4], [4, 2, 2]

 示例 2:

 输入: arr = [2, 4, 5, 10]
 输出: 7
 解释: 可以得到这些二叉树: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].



 提示：


 1 <= arr.length <= 1000
 2 <= arr[i] <= 109
 arr 中的所有值 互不相同


 */
class Solutionp1 {
    Map<Integer,Long> map=new HashMap<>();
    TreeSet<Integer> set=new TreeSet<>();
    public int numFactoredBinaryTrees(int[] arr) {
        long res=0;
        for (int val:arr){
            set.add(val);
        }
        Arrays.sort(arr);
        for (int val:arr){
            res+=dfs(val);
        }
        return (int) (res% 1000000007);
    }
    long dfs(int val){
        if (!set.contains(val)){
            map.put(val,0l);
            return 0;
        }
        if (map.containsKey(val))
            return map.get(val);
        else {
            SortedSet<Integer> headSet = set.headSet(val );
            long res=1;
            for (int v:headSet){
                int t=val/v;
                if (t*v!=val)
                    continue;
                long base=dfs(t)*dfs(v);
                res+=base;
            }
            map.put(val,res);
            return res;
        }

    }
}
