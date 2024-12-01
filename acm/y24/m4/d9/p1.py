import math


class Solution(object):
    def superpalindromesInRange(self, left, right):
        """
        :type left: str
        :type right: str
        :rtype: int
        """
        # 回溯
        lb = int(left)
        rb = int(right)
        rg = math.floor(math.sqrt(rb))
        rle = (len(str(rg)) + 1) // 2
        self.ans = 0

        def ispalindrome(val):
            return str(val)[:] == str(val)[::-1]

        r = min(int(math.pow(10, rle)), 100000)
        for i in range(0, r):
            # 构造回文串
            #odd
            val = int(''.join(str(i)[:] + str(i)[::-1]))
            val *= val
            if ispalindrome(val) and rb >= val >= lb:
                self.ans += 1
            #even
            val = int(''.join(str(i)[:] + str(i)[-2::-1]))
            val *= val
            if ispalindrome(val) and  rb >= val >= lb:
                self.ans += 1
        return self.ans


if __name__ == "__main__":
    solution = Solution()
    ans = solution.superpalindromesInRange("4", str(10 ** 18))
    print(ans)
