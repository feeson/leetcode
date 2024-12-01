class Solution(object):
    def peakIndexInMountainArray(self, arr):
        """
        :type arr: List[int]
        :rtype: int
        """
        l = 1
        r = len(arr) - 1
        while l <= r:
            mid = (l + r) // 2
            if arr[mid - 1] < arr[mid] and arr[mid] > arr[mid + 1]:
                return mid
            if arr[mid - 1] > arr[mid] and arr[mid] > arr[mid + 1]:
                r = mid - 1
            else:
                l = mid + 1

if __name__ == '__main__':
    s = Solution()
    s.peakIndexInMountainArray([0,2,0])