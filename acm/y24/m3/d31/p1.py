class Solution(object):
    def minFlipsMonoIncr(self, s):
        """
        :type s: str
        :rtype: int
        """
        le = len(s)
        total = 0
        cnt1 = [0] * le
        cnt0 = [0] * le
        for idx, char in enumerate(s):
            if idx > 0:
                cnt0[idx] = cnt0[idx - 1]
            if char == '1':
                cnt0[idx] += 1
        for idx, char in enumerate(reversed(s)):
            idx = le - idx - 1
            if idx < le - 1:
                cnt1[idx] = cnt1[idx + 1]
            if char == '0':
                cnt1[idx] += 1
        res = cnt1[0]
        for idx, char in enumerate(s):
            c1 = cnt1[idx + 1] if idx + 1 < le else 0
            res = min(res, cnt0[idx] + c1)
        return res
