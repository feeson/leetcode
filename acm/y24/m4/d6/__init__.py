class TreeAncestor(object):
    def __init__(self, n, parent):
        """
        :type n: int
        :type parent: List[int]
        """
        self.parent = parent
        self.n = n
        self.lg = [0] * (n + 1)
        for i in range(1, n + 1):
            self.lg[i] = self.lg[i - 1] + (1 if (1 << self.lg[i - 1]) == i else 0)
        self.dp = [([None] * (self.lg[n] - 1)) for _ in range(n)]
        self.depth = [0] * n

        zp = dict()
        for nd, pa in enumerate(parent):
            lst = zp.get(pa, [])
            lst.append(nd)
            zp[pa] = lst

        def dfs(node, parent):
            if node >= n:
                return
            self.dp[node][0] = parent
            if parent != -1:
                self.depth[node] = self.depth[parent] + 1
                for i in range(1, self.lg[self.depth[node]]):
                    self.dp[node][i] = self.dp[self.dp[node][i - 1]][i - 1]
            lst = zp.get(node, [])
            for val in lst:
                dfs(val, node)

        dfs(0, -1)

    def getKthAncestor(self, node, k):
        """
        :type node: int
        :type k: int
        :rtype: int
        """
        lv = self.depth[node]
        if k > lv:
            return -1
        while k > 0:
            node = self.dp[node][self.lg[k] - 1]
            k -= 1 << (self.lg[k] - 1)
        return node


if __name__ == "__main__":
    tree = TreeAncestor(4, [-1, 2, 3, 0])
    tree.getKthAncestor(2, 2)
# Your TreeAncestor object will be instantiated and called as such:
# obj = TreeAncestor(n, parent)
# param_1 = obj.getKthAncestor(node,k)
