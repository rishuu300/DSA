class Solution:
    def maxLen(self, arr):
        n = len(arr)
        
        for i in range(n):
            if arr[i] == 0:
                arr[i] = -1
        
        mp = {}
        largest = 0
        prefix_sum = 0
        
        for i in range(n):
            prefix_sum += arr[i]
            
            if prefix_sum == 0:
                largest = i+1
            
            if prefix_sum in mp:
                largest = max(largest, i - mp[prefix_sum])
            
            if prefix_sum not in mp:
                mp[prefix_sum] = i
        
        return largest