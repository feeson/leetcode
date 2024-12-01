from functools import cache
from math import factorial

le, m = map(int, input().split())
pa = [-1] * (le + 1)


def add(i, j):
    findi = find(i)
    findj = find(j)
    pa[findj] = findi


def find(x):
    if pa[x] == -1:
        return x
    pa[x] = find(pa[x])
    return pa[x]


while m > 0:
    u, v = map(int, input().split())
    add(v, u)
    m -= 1
cnt = -1
for i in range(le + 1):
    if find(i) == i:
        cnt += 1

@cache
def fact(x):
    return factorial(x)

def cal(x):
    return fact(cnt)/fact(x)/fact(cnt - x)
res = 0
MOD = 1_000_000_007
for i in range(cnt):
    x = i + 1
    res = (res + cal(x))%MOD
# 不带根

print(res)