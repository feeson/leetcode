import math


def fun():
    n, m = map(int, input().split())
    nums = [int(x) for x in input().split()]

    l = -1
    r = 1e10

    for idx, val in enumerate(nums):
        idx += 1
        l = max(l, val * idx / m)
        r = min(r, (val + 1) * idx / m)
        if l >= r:
            print("xiaogougege")
            return
    l = math.ceil(l)
    r = math.floor(r)
    if l > r:
        print("xiaogougege")
        return
    for i in range(l, r + 1):
        print(i)

fun()