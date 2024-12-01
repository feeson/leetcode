from math import factorial
from collections import Counter

MOD = 1_000_000_007

def fact(n, i):
    return (factorial(n) // (factorial(i) * factorial(n - i))) % MOD

def main():
    len = int(input())
    str = input()
    cnt = Counter(str)
    max_val = max(cnt.values())
    res = 0
    for i in range(1, max_val + 1):
        for x in range(26):
            if cnt[chr(ord('a') + x)] < i:
                continue
            for y in range(x + 1, 26):
                if cnt[chr(ord('a') + y)] < i:
                    continue
                res = (res + fact(cnt[chr(ord('a') + x)], i) * fact(cnt[chr(ord('a') + y)], i)) % MOD
    print(res)

if __name__ == "__main__":
    main()