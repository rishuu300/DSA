class Solution:
    def maxWater(self, arr):
        n = len(arr)
        max_left = [0]*n
        max_right = [0]*n
        
        max_left[0] = arr[0]
        max_right[n-1] = arr[n-1]
        
        for i in range(1, n):
            max_left[i] = max(arr[i], max_left[i-1])
            
            max_right[n-i-1] = max(arr[n-i-1], max_right[n-i])
        
        res = 0
        for i in range(n):
            res += min(max_left[i], max_right[i]) - arr[i]
        
        return res