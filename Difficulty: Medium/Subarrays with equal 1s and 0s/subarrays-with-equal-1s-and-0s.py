class Solution:
    def countSubarray(self, arr):
        for i in range(len(arr)):
            if arr[i] == 0:
                arr[i] = -1
        
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