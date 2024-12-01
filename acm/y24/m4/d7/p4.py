class Solution(object):
    def minimumEffortPath(self, heights):
        """
        :type heights: List[List[int]]
        :rtype: int
        https://leetcode.cn/problems/path-with-minimum-effort/description/?envType=daily-question&envId=2024-04-07
        """
        row, col = (len(heights), len(heights[0]))
        visit = [[False for _ in range(col)] for _ in range(row)]
        from sortedcontainers import SortedSet
        candidates = SortedSet()
        # cost idx
        dic = dict()
        # dix (r, c)
        for r in range(row):
            for c in range(col):
                node = (1e9, r, c)
                dic[(r, c)] = node
                candidates.add(node)
        candidates.remove(dic[(0, 0)])
        dic[(0, 0)] = (0, 0, 0)
        candidates.add(dic[(0, 0)])
        vec = [-1, 0, 1, 0, -1]
        while candidates:
            cost, r, c = candidates.pop(0)
            if r == row - 1 and c == col - 1:
                return cost
            visit[r][c] = True

            # 遍历
            def valid(x, y):
                return 0 <= x < row and 0 <= y < col

            for i in range(4):
                x = r + vec[i]
                y = c + vec[i + 1]
                if valid(x, y) and not visit[x][y]:
                    predict = max(cost, abs(heights[x][y] - heights[r][c]))
                    suppose, _, _ = dic[(x, y)]
                    if predict < suppose and dic[(x, y)] in candidates:
                        # 更新
                        candidates.remove(dic[(x, y)])
                        dic[(x, y)] = (predict, x, y)
                        candidates.add(dic[(x, y)])
        return -1


if __name__ == "__main__":
    solution = Solution()
    solution.minimumEffortPath([[1,10,6,7,9,10,4,9]])
