mydict = dict()
mydict[0] = 1

print(mydict)

n, m, k = list(map(int, input().split()))
nums = list(map(int, input().split()))
le = len(nums)
preSum = [0] * le
preSum[0] = nums[0]
print(len(nums[1:]))
for idx, val in enumerate(nums, start=1):
    print(idx)
    preSum[idx + 1] = preSum[idx] + val
sm = m * k
l = 0
r = n - 1
while l < r:
    mid = (l + r) // 2
    t = sm - (nums[mid] * (mid + 1) - preSum[mid])
    if t == 0:
        print(nums[mid])
        break
    elif t > 0:
        l = mid + 1
    else:
        r = mid - 1
sm -= (r + 1) * nums[r]
res = nums[r] + sm // (r + 1)
print(res)