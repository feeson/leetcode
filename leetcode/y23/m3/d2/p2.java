package y23.m3.d2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给你两个字符串数组 queries 和 dictionary 。数组中所有单词都只包含小写英文字母，且长度都相同。
 *
 * 一次 编辑 中，你可以从 queries 中选择一个单词，将任意一个字母修改成任何其他字母。从 queries 中找到所有满足以下条件的字符串：不超过 两次编辑内，字符串与 dictionary 中某个字符串相同。
 *
 * 请你返回 queries 中的单词列表，这些单词距离 dictionary 中的单词 编辑次数 不超过 两次 。单词返回的顺序需要与 queries 中原本顺序相同。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/words-within-two-edits-of-dictionary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution1 {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            for (int j = 0; j < dictionary.length; j++) {
                String d = dictionary[j];
                if (f(q, d) < 3) {
                    ans.add(q);
                    break;
                }
            }
        }
        return ans;
    }

    private int f(String q, String d) {
        int cnt = 0;
        for (int i = 0; i < q.length(); i++) {
            cnt += q.charAt(i) == d.charAt(i) ? 0 : 1;
        }
        return cnt;
    }

}