le = int(input())
nums = [int(v) for v in input().split(" ")]

MOD = 1e7 + 7
ans = 0

sum = [0 for _ in range(le)]


def cal(l, r):
    rs = sum[r - 1]
    rs += (r - l)*nums[r]
    time = 1
    for t in range(l, r):
        rs += nums[t] * time
        time += 1
    sum[r] = rs
    return rs


lastBorder = 0
for index, num in enumerate(nums):
    if index == 0:
        continue
    if nums[index - 1] != nums[index]:
        cal(lastBorder, index)
    else:
        ans += sum[index - 1]
        lastBorder = index
ans += sum[le - 1]
print(int(ans % MOD))
