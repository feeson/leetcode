class Solution(object):
    def hitBricks(self, grid, hits):
        """
        :type grid: List[List[int]]
        :type hits: List[List[int]]
        :rtype: List[int]
        """
        import copy
        cp = copy.deepcopy(grid)
        for (x, y) in hits:
            cp[x][y] = 0
        lex = len(grid)
        ley = len(grid[0])
        sz = lex * ley
        pa = [v for v in range(sz + 1)]
        size = [1 for _ in range(sz + 1)]
        size[sz] = 0

        def getIndex(x, y):
            return x * ley + y

        def find(node):
            if pa[node] == node:
                return node
            pa[node] = find(pa[node])
            return pa[node]

        def union(i, j):
            findi = find(i)
            findj = find(j)
            if findi == findj:
                return
            pa[findj] = findi
            size[findi] += size[findj]

        def getSize(node):
            n = find(node)
            return size[n]

        for j in range(ley):
            if cp[0][j] == 1:
                union(sz, j)
        directs = [-1, 0, 1, 0, -1]
        for i in range(1, lex):
            for j in range(ley):
                if cp[i][j] == 1:
                    if cp[i - 1][j] == 1:
                        union(getIndex(i - 1, j), getIndex(i, j))
                    if j >= 1 and cp[i][j - 1] == 1:
                        union(getIndex(i, j - 1), getIndex(i, j))

        ans = [0 for _ in hits]
        for index, (x, y) in enumerate(hits[::-1]):
            if grid[x][y] == 0:
                continue
            cur = getSize(sz)
            if x == 0:
                union(sz, getIndex(x, y))
            for i in range(4):
                nx = x + directs[i]
                ny = y + directs[i + 1]

                def validate(vx, vy):
                    return 0 <= vx < lex and 0 <= vy < ley

                if validate(nx, ny) and cp[nx][ny] == 1:
                    union(getIndex(nx, ny), getIndex(x, y))

            pad = getSize(sz)
            res = max(0, pad - cur - 1)
            ans[len(hits) - 1 - index] = res
            cp[x][y] = 1

        return ans

if __name__ == '__main__':
    s = Solution()
    s.hitBricks([[1,0,0,0],[1,1,1,0]], [[1,0]])