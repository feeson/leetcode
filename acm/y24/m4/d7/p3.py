class Solution(object):
    def longestAlternatingSubarray(self, nums, threshold):
        """
        :type nums: List[int]
        :type threshold: int
        :rtype: int
        """
        ans = 0
        idx = 0
        le = len(nums)
        while idx < le:
            if nums[idx] % 2 == 0 and nums[idx] <= threshold:
                ans = max(ans, 1)
                # 往后
                left = idx
                right = idx + 1
                while right < le and nums[right] % 2 != 0 and nums[right] <= threshold:
                    ans = max(ans, right - left + 1)
                    idx = right + 1
                    if idx < le and nums[idx] % 2 == 0 and nums[idx] <= threshold:
                        ans = max(ans, idx - left + 1)
                        right = idx + 1
                    else:
                        break
                idx += 1
            else:
                idx += 1
        return ans