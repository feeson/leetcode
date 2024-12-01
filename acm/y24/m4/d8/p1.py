class Solution(object):
    def finalString(self, s):
        """
        :type s: str
        :rtype: str
        """
        ans = ""
        for c in s:
            if c == "i":
                ans = ans[::-1]
            else:
                ans = ans + c
        return ans