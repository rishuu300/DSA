class Solution:
    def findSubarray(self, arr):
        mp = {}
        count = 0
        prefix_sum = 0
        
        for num in arr:
            prefix_sum += num
            
            if prefix_sum == 0:
                count += 1
            
            if prefix_sum in mp:
                count += mp[prefix_sum]
            
            mp[prefix_sum] = mp.get(prefix_sum, 0) + 1
            
        
        return count