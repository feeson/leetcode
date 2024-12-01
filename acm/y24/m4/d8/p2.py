class Solution(object):
    def splitArray(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        sum = 0
        maxval = 0
        for val in nums:
            sum += val
            maxval = max(maxval, val)
        l = maxval
        r = sum
        while l <= r:
            mid = (l + r) // 2
            slot = 1
            t = 0
            for val in nums:
                if t + val <= mid:
                    t += val
                else:
                    t = val
                    slot += 1
            if slot > k:
                l = mid + 1
            else:
                r = mid - 1
        return r + 1

if __name__ == "__main__":
    solution = Solution()
    solution.splitArray([1,4, 4], 3)