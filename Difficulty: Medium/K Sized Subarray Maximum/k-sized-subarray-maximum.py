from collections import deque

class Solution:
    def maxOfSubarrays(self, arr, k):
        n = len(arr)
        dq = deque()
        result = []
        
        for i in range(k):
            while dq and arr[i] >= arr[dq[-1]]:
                dq.pop()
            
            dq.append(i)
        
        for i in range(k, n):
            result.append(arr[dq[0]])
            
            while dq and dq[0] <= i-k:
                dq.popleft()
            
            while dq and arr[i] >= arr[dq[-1]]:
                dq.pop()
            
            dq.append(i)
        
        result.append(arr[dq[0]])
        
        return result