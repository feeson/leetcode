class Solution(object):
    def smallestRangeII(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        https://leetcode.cn/problems/smallest-range-ii/
        """
        nums.sort()
        le = len(nums)
        ans = nums[le - 1] - nums[0]
        for idx in range(le):
            mx = max(nums[le - 1] - k, nums[idx] + k)
            nx = min(nums[0] + k, nums[idx + 1 - k])
            ans = min(mx - nx, ans)
        return ans

if __name__ == '__main__':
    so = Solution()
    so.smallestRangeII([9,10,0,7], 1)