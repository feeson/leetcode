package y24.m3.d9;

import java.util.Arrays;

/*
2386. 找出数组的第 K 大和
请问您在哪类招聘中遇到此题？1/5社招校招实习未遇到通过次数7.3K提交次数14.8K通过率49.3%相关标签数组排序堆（优先队列）相关企业提示 1Start from the largest sum possible, and keep finding the next largest sum until you reach the kth sum.提示 2Starting from a sum, what are the two next largest sums that you can obtain from it?评论 (63)预览评论💡 讨论区规则1. 请不要在评论区发表题解！2. 评论区可以发表关于对翻译的建议、对题目的疑问及其延伸讨论。3. 如果你需要整理题解思路，获得反馈从而进阶提升，可以去题解区进行。排序:最热wxyz发布于 湖南11 小时前把握核心：
可以轻松得到所有正数的和，那就是最大的序列和。如何得到第 k 大的呢？删正数 或 添负数
如何做？可以统一成 删绝对值。将负数取反，然后排序，每次取最小的数，得到的就是最小的正数或最大的负数。sum 中减去它，就可以得到下一个更小的子序列和展开全部13展示 1 条回复回复绿月亮发布于 江苏12 小时前零点了本来打算刷完每日题再睡，看完题目难度分后，，，，算了直接睡吧展开全部5展示 2 条回复回复Andreas发布于 广东10 小时前第一眼立刻想到用求子集魔改一下：
class Solution {
private:
    priority_queue<long long, vector<long long>, greater<long long>> result;
    long long sum = 0;
    void backtracking(vector<int>&amp; nums, int startIndex, int k)
    {
        if(result.size() < k)
            result.push(sum);
        else if(sum > result.top())
        {
            result.pop();
            result.push(sum);
        }
        if(startIndex>=nums.size())  return;

        for(int i=startIndex; i<nums.size(); ++i)
        {
            sum += nums[i];
            backtracking(nums, i+1, k);
            sum -= nums[i];
        }
    }
public:
    long long kSum(vector<int>&amp; nums, int k) {
        backtracking(nums, 0, k);

        return result.top();
    }
};
但是在
[153123449,-974739108,-408679566,-996444415,-978921261,805907128,-102259288,-397930077,51033052,-193994032,158654659,-486195972,-294264190,-65262667,375941242,-890038230,315970860,403847239,-32469129,-350561293,192113942,794248972,-632675681,434029943,746632801,500370163,164413366,346449701,473890512], n = 1906超时
于是想到不能真的把每个子集跑一遍。新的思路就是从所有正数之和开始（这个必是最大子集）慢慢放小（通过两种种情况放小：+0（实际没小，但也是下一个）；减去正数最小的/加上负数最大的（二者要选）。留个思路，明天起来验证。困得不行了，睡觉。展开全部1回复MRevenger发布于 山东12 小时前一看困难题，再看提交次数11.1K，再看通过率42.7%？CV睡觉喽，这种题就不是我能写的展开全部2回复woruteyqi发布于 湖南12 小时前急速入睡🤣展开全部1回复5DUA0RVkna发布于 四川3 分钟前发现关键在于求一组数的任意自由排列和的排序 很好 求不了一点展开全部0回复Determined 6oldvvasseru0f发布于 江苏(编辑过)43 分钟前哎，不知道题目说的是什么，2，2是怎么来的？展开全部0回复罒醐发布于 北京1 小时前总感觉题目不是中国人写的，读不懂展开全部0回复Luke发布于 陕西1 小时前有没有人翻译一下展开全部0回复Candysad发布于 辽宁1 小时前数学题

逆向思维想到用最大的减去第kkk小的得到第kkk大的
用什么技巧在不定元素个数所有序列组合中找第kkk小的序列和
展开全部0回复123456贡献者
*/
/*
href: https://leetcode.cn/problems/find-the-k-sum-of-an-array/?envType=daily-question&envId=2024-03-09
*/
class Solution {
    long sum = 0;
    int[] nums;
    int len;
    long right = 0;
    public long kSum(int[] nums, int k) {
        this.nums = nums;
        len = nums.length;
        for (int i=0;i<len;++i){
            if (nums[i] >0 )
                sum+= nums[i];
            else
                nums[i] = -nums[i];
            right+=nums[i];
        }

        Arrays.sort(nums);

        long left = -1;
        while (left + 1 < right){
            long mid = (left + right)/2;
            // 计算是否有k个数的和大于mid
            cnt = k;
            dfs(nums, 0, mid);
            if (cnt == 0)
                right = mid;
            else
                left = mid;
        }
        return left;
    }
    int cnt;
    // sum 最大值 -> 第一大
    // k 第k大
    // ->0 小了
    // 检测remain
    void dfs(int[] nums, int index, long remain){
        if (remain < 0 || index >= len || cnt == 0)
            return;
        cnt--;
        dfs(nums, index+1, sum - nums[index]);
        dfs(nums, index+1, remain);
    }
}
class Main{
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.kSum(new int[]{2,4,-2}, 5));
    }
}