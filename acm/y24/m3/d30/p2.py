class Solution(object):
    def minimumAddedCoins(self, coins, target):
        """
        :type coins: List[int]
        :type target: int
        :rtype: int
        """
        coins.sort()
        le = len(coins)
        s = 1
        idx = 0
        res = 0
        while s < target:
            if idx < le and coins[idx] <= s:
                s += coins[idx]
                idx += 1
            else:
                res += 1
                s *= 2
        return res

