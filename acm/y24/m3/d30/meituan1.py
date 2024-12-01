import copy


class Solution(object):
    def rampartDefensiveLine(self, rampart):
        """
        :type rampart: List[List[int]]
        :rtype: int
        """
        le = len(rampart)
        mx = 0
        empt = [0] * (le - 1)
        for idx, ram in enumerate(rampart[1:-1]):
            estimate = ram[0] - rampart[idx][1] + rampart[idx + 2][0] - ram[1]
            mx = max(mx, estimate)
        for idx, ram in enumerate(rampart[1:]):
            empt[idx] = ram[0] - rampart[idx][1]
        l = 0
        r = mx
        while l <= r:
            mid = (l + r) // 2
            cp = copy.copy(empt)
            for i in range(len(cp) - 1):
                remain = mid
                if cp[i] > 0:
                    diff = min(cp[i], remain)
                    cp[i] -= diff
                    remain -= diff
                if cp[i + 1] > 0:
                    diff = min(cp[i + 1], remain)
                    cp[i + 1] -= diff
                    remain -= diff
                if remain > 0:
                    r = mid - 1
                    break
            else:
                l = mid + 1
        print(l - 1)


if __name__ == "__main__":
    solution = Solution
    solution.rampartDefensiveLine(solution, [[0, 3], [4, 5], [7, 9]])
