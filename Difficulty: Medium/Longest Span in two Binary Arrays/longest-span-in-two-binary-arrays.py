class Solution:
    def equalSumSpan(self, a1, a2):
        n = len(a1)
        arr = [0]*n
        
        for i in range(n):
            arr[i] = a1[i] - a2[i]
        
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