class Solution:
    def majorityElement(self, arr):
        n = len(arr)
        count = 1
        res = 0
        
        for i in range(1, n):
            if arr[i] == arr[res]:
                count += 1
            else:
                count -= 1
            
            if count == 0:
                res = i
                count = 1
        
        count = 0
        for i in range(n):
            if arr[i] == arr[res]:
                count += 1
        
        if count > n/2:
            return arr[res]
        
        return -1