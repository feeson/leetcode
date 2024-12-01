import collections
import math


class Solution(object):

    def maxSlidingWindow(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        deque = collections.deque()
        # 建队
        for _, val in enumerate(nums[:k]):
            if not deque:
                deque.append(val)
                continue
            while deque and val > deque[len(deque) - 1]:
                deque.pop()
            deque.append(val)
        res = [deque[0]]
        for i in range(1, len(nums) + 1 - k):
            rmv = nums[i - 1]
            if rmv == deque[0]:
                deque.popleft()
            append = nums[i + k - 1]
            while deque and append > deque[len(deque) - 1]:
                deque.pop()
            deque.append(append)
            res.append(deque[0])
        return res


if __name__ == "__main__":
    solution = Solution
    solution.maxSlidingWindow(solution, [1, 3, -1, -3, 5, 3, 6, 7], 3)
