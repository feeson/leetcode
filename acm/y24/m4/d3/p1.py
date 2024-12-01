class Solution(object):
    def recoverArray(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        nums.sort()
        le = len(nums)
        val = nums[0]
        for idx, pair in enumerate(nums[1:]):
            idx += 1
            if val + pair & 1 != 0:
                continue
            k = (pair - val) // 2

            dic = dict()
            for val in nums:
                if val in dic:
                    dic[val] += 1
                else:
                    dic[val] = 1
            l = 0
            r = idx
            if dic[val] > 1:
                dic[val] -= 1
            else:
                del dic[val]
            if dic[nums[r]] > 1:
                dic[nums[r]] -= 1
            else:
                del dic[nums[r]]
            items = dic.items()
            (k, v) = items[0]
            print(k, v)

        return None






if __name__ == "__main__":
    solution = Solution()
    solution.recoverArray([2,10,6,4,8,12])
