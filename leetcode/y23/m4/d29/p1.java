package y23.m4.d29;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * 给你一个下标从 0 开始的字符串 word ，字符串只包含小写英文字母。你需要选择 一个 下标并 删除 下标处的字符，使得 word 中剩余每个字母出现 频率 相同。
 *
 * 如果删除一个字母后，word 中剩余所有字母的出现频率都相同，那么返回 true ，否则返回 false 。
 *
 * 注意：
 *
 * 字母 x 的 频率 是这个字母在字符串中出现的次数。
 * 你 必须 恰好删除一个字母，不能一个字母都不删除。
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-letter-to-equalize-frequency
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public boolean equalFrequency(String word) {
        Map<Character,Integer> times=new HashMap<>();
        for (char c:word.toCharArray()){
            if (times.containsKey(c))
                times.replace(c,times.get(c)+1);
            else
                times.put(c,1);
        }
        TreeMap<Integer,Integer>treeMap=new TreeMap<>();
        for (Map.Entry<Character, Integer> characterIntegerEntry : times.entrySet()) {
            int val=characterIntegerEntry.getValue();
            if (treeMap.containsKey(val))
                treeMap.replace(val,treeMap.get(val)+1);
            else
                treeMap.put(val,1);
        }
        if (treeMap.size()==1&&treeMap.firstEntry().getValue()==1)
            return true;
        if (treeMap.size()==1&&treeMap.firstEntry().getKey()==1)
            return true;
        if (treeMap.size()==1&&treeMap.firstEntry().getKey()!=1)
            return false;
        if (treeMap.size()==2&&treeMap.firstEntry().getKey()==1&&treeMap.firstEntry().getValue()==1)
            return true;
        if (treeMap.size()==2&&treeMap.lastEntry().getKey()-treeMap.firstEntry().getKey()==1&&treeMap.lastEntry().getValue()==1)
            return true;
        if (treeMap.size()==2&&treeMap.firstEntry().getKey()==1&&treeMap.firstEntry().getValue()>1)
            return false;

        return false;
    }
}