import math
from functools import cache


class Solution(object):
    def consecutiveNumbersSum(self, n):
        """
        :type n: int
        :rtype: int
        """

        def cal(x, l):
            m = 2 * x - l ** 2 + l
            c = 2 * l
            if m % c != 0:
                return -1
            return m // c

        ans = 1
        for i in range(2, math.ceil((-1 + math.sqrt(1 + 8 * n))/2) + 1):
            a0 = cal(n, i)
            if a0 > 0:
                ans += 1
        return ans

if __name__ == '__main__':
    s = Solution()
    s.consecutiveNumbersSum(4)