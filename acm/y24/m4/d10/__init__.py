class Solution(object):
    def prisonAfterNDays(self, cells, n):
        """
        :type cells: List[int]
        :type n: int
        :rtype: List[int]
        """
        ans = 0
        le = len(cells)
        mask = 0
        for idx in range(1, le - 1):
            mask |= (1 << idx)
        for idx, val in enumerate(cells[::-1]):
            if val == 1:
                ans = ans + (1 << idx)
        st = set()
        lp = []
        loop = n
        for i in range(n):
            t1 = (ans << 1) | (1 << le)
            t2 = (ans >> 1) | (1 << le)
            ans = t1 ^ t2 | (1 << le)
            ans = ~ans & mask
            ans |= 1 << le
            if ans in st:
                loop = i
                while lp[0] != ans:
                    lp.pop(0)
                break
            else:
                st.add(ans)
                lp.append(ans)
        ans = lp[(n - 1) % loop]
        res = [0] * le
        for idx in range(le):
            if ans & 1 == 1:
                res[le - 1 - idx] = 1
            ans >>= 1
        return res


if __name__ == '__main__':
    print(f"hello{100:.2f}")
