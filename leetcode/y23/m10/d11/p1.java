package y23.m10.d11;

import java.util.*;

/**
 给你两个字符串数组positive_feedback 和negative_feedback，分别包含表示正面的和负面的词汇。不会有单词同时是正面的和负面的。

 一开始，每位学生分数为0。每个正面的单词会给学生的分数 加3分，每个负面的词会给学生的分数 减1分。

 给你n个学生的评语，用一个下标从 0开始的字符串数组report和一个下标从 0开始的整数数组student_id表示，其中student_id[i]表示这名学生的 ID ，这名学生的评语是report[i]。每名学生的 ID 互不相同。

 给你一个整数k，请你返回按照得分从高到低最顶尖的k名学生。如果有多名学生分数相同，ID 越小排名越前。



 示例 1：

 输入：positive_feedback = ["smart","brilliant","studious"], negative_feedback = ["not"], report = ["this student is studious","the student is smart"], student_id = [1,2], k = 2
 输出：[1,2]
 解释：
 两名学生都有 1 个正面词汇，都得到 3 分，学生 1 的 ID 更小所以排名更前。


 示例 2：

 输入：positive_feedback = ["smart","brilliant","studious"], negative_feedback = ["not"], report = ["this student is not studious","the student is smart"], student_id = [1,2], k = 2
 输出：[2,1]
 解释：
 - ID 为 1 的学生有 1 个正面词汇和 1 个负面词汇，所以得分为 3-1=2 分。
 - ID 为 2 的学生有 1 个正面词汇，得分为 3 分。
 学生 2 分数更高，所以返回 [2,1] 。




 提示：


 1 <= positive_feedback.length, negative_feedback.length <= 104
 1 <= positive_feedback[i].length, negative_feedback[j].length <= 100
 positive_feedback[i] 和negative_feedback[j]都只包含小写英文字母。
 positive_feedback 和negative_feedback中不会有相同单词。
 n == report.length == student_id.length
 1 <= n <= 104
 report[i]只包含小写英文字母和空格' '。
 report[i]中连续单词之间有单个空格隔开。
 1 <= report[i].length <= 100
 1 <= student_id[i] <= 109
 student_id[i]的值 互不相同。
 1 <= k <= n


 */
/*
https://leetcode.cn/problems/reward-top-k-students/?envType=daily-question&envId=2023-10-11
*/
class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Set<String> positive=new HashSet<>();
        Set<String> negative=new HashSet<>();
        positive.addAll(Arrays.asList(positive_feedback));
        negative.addAll(Arrays.asList(negative_feedback));
        TreeMap<Integer,List<Integer>> res=new TreeMap<>();
        int len= report.length;
        for (int i=0;i<len;++i){
            String str=report[i];
            String[] s = str.split(" ");
            int cnt=0;
            for (String word:s){
                if (positive.contains(word))
                    cnt+=3;
                if (negative.contains(word))
                    cnt--;
            }
            if (!res.containsKey(cnt))
                res.put(cnt,new ArrayList<>());
            res.get(cnt).add(student_id[i]);
        }
        List<Integer> rtn=new ArrayList<>();
        while (k!=0){
            List<Integer> value = res.pollLastEntry().getValue();
            value.sort(Comparator.naturalOrder());
            if (k>=value.size()){
                k-=value.size();
                rtn.addAll(value);
            }else {
                for (int i=0;i<k;++i){
                    rtn.add(value.get(i));
                }
                k=0;
            }
        }
        return rtn;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        String[] arr1=new String[]{"yewmhbgnq","vqhhuaejqw"};
        String[] arr2=new String[]{"zjeyq","oyuetqe","ks","vuvannpwa","qfd","xv","aauvtxrdt","gml","eaky","mwip"};
        String[] arr3=new String[]{"lqiuderzod mwip vqhhuaejqw xrn aqjzkqjsi riuood yewmhbgnq xv nmcvqm onhkkmy","uccz yewmhbgnq rcxdaqicbe vqhhuaejqw yewmhbgnq e vqhhuaejqw b yewmhbgnq vqhhuaejqw","eaky yewmhbgnq eaky dwdzl yewmhbgnq yewmhbgnq ntqpnqtmnb qfd ks gvumi","ecutvv vqhhuaejqw vqhhuaejqw inu vqhhuaejqw vqhhuaejqw uu eodzum zjeyq fxebx","vqhhuaejqw m vuvannpwa mwip atvjp vqhhuaejqw eaky yewmhbgnq vqhhuaejqw yewmhbgnq"};
        int[] arr4=new int[]{581094748,245764367,905556075,127263030,415068015};
        System.out.println(solution.topStudents(arr1,arr2,arr3,arr4,4));
    }
}
