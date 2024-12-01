class Solution(object):
    def numSimilarGroups(self, strs):
        """
        :type strs: List[str]
        :rtype: int
        """
        pa = [-1 for _ in strs]

        def find(node):
            if pa[node] == -1:
                return node
            pa[node] = find(pa[node])
            return pa[node]

        def union(i, j):
            findi = find(i)
            findj = find(j)
            if findi == findj:
                return
            pa[findj] = findi

        def compare(s1, s2):
            if s1 == s2:
                return True
            incompatible = 0
            ans = [0, 0]
            ans_index = 0
            for index in range(len(s1)):
                if s1[index] != s2[index]:
                    incompatible += 1
                    if incompatible > 2:
                        return False
                    ans[ans_index] = index
                    ans_index += 1
            if s1[ans[0]] == s2[ans[1]] and s1[ans[1]] == s2[ans[0]]:
                return True
            else:
                return False

        for pindex, pattern in enumerate(strs):
            for sindex, s in enumerate(strs[pindex + 1:]):
                sindex += pindex + 1
                if compare(pattern, s):
                    if pa[sindex] != -1:
                        union(pa[sindex], pindex)
                    union(pindex, sindex)
        st = set()
        for i in range(len(strs)):
            p = find(i)
            if p == -1:
                st.add(i)
            else:
                st.add(p)
        return len(st)

if __name__ == '__main__':
    s = Solution()
    s.numSimilarGroups([
        "kccomwcgcs",
        "socgcmcwkc",
        "sgckwcmcoc",
        "coswcmcgkc",
        "cowkccmsgc",
        "cosgmccwkc",
        "sgmkwcccoc",
        "coswmccgkc",
        "kowcccmsgc",
        "kgcomwcccs"])