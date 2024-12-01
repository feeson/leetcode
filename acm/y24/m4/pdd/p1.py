le = int(input())
s = input()
if le <= 2:
    print(0, 0)
else:
    if le % 3 == 0:
        ans = 0
        index = 0
        while index < le:
            ans += abs(ord(s[index]) - ord("P"))
            index += 1
            ans += abs(ord(s[index]) - ord("D"))
            index += 1
            ans += abs(ord(s[index]) - ord("D"))
            index += 1
        print(le // 3, ans)
    elif le % 3 == 1:
        ans = 1e18
        for exc in range(0, le, 3):
            res = 0
            index = 0
            od = 0
            arr = ["P", "D", "D"]
            while index < le:
                if index == exc:
                    index += 1
                    continue
                res += abs(ord(s[index]) - ord(arr[od]))
                od += 1
                od %= 3
                index += 1
            ans = min(ans, res)
        print(le // 3, ans)
    else:
        ans = 1e18
        for exc1 in range(0, le, 3):
            for exc2 in range(exc1 + 1, le, 3):
                res = 0
                index = 0
                od = 0
                arr = ["P", "D", "D"]
                while index < le:
                    if index == exc1 or index == exc2:
                        index += 1
                        continue
                    res += abs(ord(s[index]) - ord(arr[od]))
                    od += 1
                    od %= 3
                    index += 1
                ans = min(ans, res)
        print(le//3, ans)