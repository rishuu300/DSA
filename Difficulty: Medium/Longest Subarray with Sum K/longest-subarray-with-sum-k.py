class Solution:
    def longestSubarray(self, arr, k):
        mp = {}
        prefix_sum = 0
        longest = 0
        
        for i in range(len(arr)):
            prefix_sum += arr[i]
            diff = prefix_sum - k
            
            if prefix_sum == k:
                longest = i+1
            
            if diff in mp:
                longest = max(longest, i - mp[diff])
            
            if prefix_sum not in mp:
                mp[prefix_sum] = i
        
        return longest