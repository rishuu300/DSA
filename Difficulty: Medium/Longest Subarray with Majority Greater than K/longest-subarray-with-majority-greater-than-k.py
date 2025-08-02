class Solution:
    def longestSubarray(self, arr, k):
        n = len(arr)
        mp = {}
        ans = 0
        sum = 0
    
        for i in range(n):
            if arr[i] <= k:
                sum -= 1
            else:
                sum += 1
    
            if sum > 0:
                ans = i + 1
            else:
                if (sum - 1) in mp:
                    ans = max(ans, i - mp[sum - 1])
    
            if sum not in mp:
                mp[sum] = i
    
        return ans