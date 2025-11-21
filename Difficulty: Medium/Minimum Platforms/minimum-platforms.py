class Solution:    
    def minPlatform(self, arr, dep):
        n = len(arr)
        arr.sort()
        dep.sort()
        
        count, res = 0, 0
        
        i, j = 0, 0
        
        while i < n and j < n:
            if arr[i] <= dep[j]:
                count += 1
                i += 1
            else:
                count -= 1
                j += 1
            
            res = max(res, count)
        
        return res