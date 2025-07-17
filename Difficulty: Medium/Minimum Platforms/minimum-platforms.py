#User function Template for python3

class Solution:    
    def minimumPlatform(self,arr,dep):
        n = len(arr)
        arr.sort()
        dep.sort()
        
        i = j = 0
        count = 0
        max_platform = 0
        
        while(i< n and j < n):
            if arr[i] <= dep[j]:
                i += 1
                count += 1
                max_platform = max(max_platform, count)
            else:
                j += 1
                count -= 1
        
        return max_platform
        