import bisect
import math


class Solution(object):
    def circleGame(self, toys, circles, r):
        """
        :type toys: List[List[int]]
        :type circles: List[List[int]]
        :type r: int
        :rtype: int
        """

        def include(tx, ty, tr, cx, cy):
            return r >= math.sqrt((cx - tx) ** 2 + (cy - ty) ** 2) + tr

        le = len(toys)
        toys.sort(lambda x: (x[0], x[1]))
        transx = [(toy[0], idx) for idx, toy in toys]
        transy = [(toy[1], idx) for idx, toy in toys]
        remain = []
        for _, circle in enumerate(circles):
            remain = []
            lb = bisect.bisect_left(transx,)
            for _, toy in enumerate(toys):
                if not include(toy[0], toy[1], toy[2], circle[0], circle[1]):
                    remain.append(toy)
            toys = remain
            if len(toys) == 0:
                return le
        return le - len(remain)


if __name__ == "__main__":
    solution = Solution
    solution.circleGame(solution, [[1, 3, 2], [4, 3, 1]], [[1, 0], [3, 3], [0, 0], [3, 4]], 4)
