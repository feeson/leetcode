class Solution(object):
    def minStoneSum(self, piles, k):
        """
        :type piles: List[int]
        :type k: int
        :rtype: int
        """
        r = len(piles) - 1
        piles.sort()
        mx = -1
        while k > 0:
            if r < 0:
                r = len(piles) - 1
            if piles[r] >= mx:
                piles[r] -= piles[r] // 2
                mx = max(mx, piles[r])
                r -= 1
                k -= 1
            else:
                piles.sort()
                r = len(piles) - 1
                mx = -1
        return sum(piles)
